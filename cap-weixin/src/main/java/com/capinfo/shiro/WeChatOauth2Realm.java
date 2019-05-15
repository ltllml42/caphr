package com.capinfo.shiro;

import com.capinfo.core.shiro.ShiroUtil;
import com.capinfo.entity.CapVehicleInfo;
import com.capinfo.entity.CapWxAccountFans;
import com.capinfo.service.CapVehicleInfoService;
import com.capinfo.service.CapWxAccountFansService;
import com.capinfo.shiro.token.WeiXinAuth2Token;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class WeChatOauth2Realm extends AuthenticatingRealm {

    @Autowired
    private CapWxAccountFansService capWxAccountFansService;
    @Autowired
    private CapVehicleInfoService capVehicleInfoService;

    @Autowired
    private WxMpService wxService;

    public WeChatOauth2Realm(){
        setAuthenticationTokenClass(WeiXinAuth2Token.class);
    }


    @Override
    public void setAuthenticationTokenClass(Class<? extends AuthenticationToken> authenticationTokenClass) {
        super.setAuthenticationTokenClass(WeiXinAuth2Token.class);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        WeiXinAuth2Token xwToken = (WeiXinAuth2Token) token;
        HttpServletRequest httpRequest = org.apache.shiro.web.util.WebUtils.toHttp(xwToken.getRequest());
        String appId = caAuthentication(httpRequest);
        if(StringUtils.isBlank(appId)){
            throw new AuthenticationException("无效的appid：" + appId);
        }
        if (!this.wxService.switchover(appId)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appId));
        }
        try {
            if(StringUtils.isBlank(xwToken.getCode())){
                throw new IllegalArgumentException("无权证code请先获取权证code");
            }
            //  = org.apache.shiro.web.util.WebUtils.getCleanParam(httpRequest,"code");
            if(xwToken.getCodeCount()!=0){
                throw new IllegalArgumentException("为什么在来了一遍");
            }
            WxMpOAuth2AccessToken accessToken = wxService.oauth2getAccessToken(xwToken.getCode());
            WxMpUser user = wxService.oauth2getUserInfo(accessToken, null);
            xwToken.setAppid(appId);
            xwToken.setAccessTaken(accessToken.getAccessToken());
            xwToken.setRefreshToken(accessToken.getRefreshToken());
            xwToken.setCodeCount(xwToken.getCodeCount()+1);
            xwToken.setLastVisitDate(new Date());
            xwToken.setEffectiveTime(accessToken.getExpiresIn());
            CapWxAccountFans fans = new CapWxAccountFans();
            fans.setOpenId(user.getOpenId());
            List<CapWxAccountFans> lists = capWxAccountFansService.select(fans);
            if (CollectionUtils.isEmpty(lists)){
                //加入数据库中
                CapWxAccountFans fansRelation = getFansRelation(appId, user);
                capWxAccountFansService.insert(fansRelation);
                xwToken.setFansInfo(fansRelation);
            }else{
                //重新与数据库同步一下
                CapWxAccountFans capWxAccountFans = lists.get(0);
                CapWxAccountFans fansRelation = getFansRelation(appId,user,capWxAccountFans);
                capWxAccountFansService.updateByPrimaryKey(fansRelation);
                CapVehicleInfo t = new CapVehicleInfo();
                t.setFansId(fansRelation.getId());
                //车辆
                xwToken.setCvInfoList(capVehicleInfoService.select(t));
                xwToken.setFansInfo(fansRelation);
            }
            Subject subject = ShiroUtil.getSubject();
            Session session= subject.getSession();
            session.setAttribute("weiXinUser",xwToken);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return new SimpleAuthenticationInfo(xwToken,xwToken.getCredentials(),getName());
    }

    private CapWxAccountFans getFansRelation(String appId, WxMpUser user) {
        CapWxAccountFans fans = new CapWxAccountFans();
        return getFansRelation(appId,user,fans);
    }

    private CapWxAccountFans getFansRelation(String appId, WxMpUser user,CapWxAccountFans fans) {
        fans.setOpenId(user.getOpenId());
        fans.setCity(user.getCity());
        fans.setCountry(user.getCountry());
        fans.setWxId(appId);
        fans.setHeadImgUrl(user.getHeadImgUrl());
        fans.setNickName(user.getNickname());
        fans.setLanguage(user.getLanguage());
        fans.setProvince(user.getProvince());
        fans.setRemark(user.getRemark());
        //值为1时是男性，值为2时是女性，值为0时是未知
        if(0==user.getSex()){//如果是未知则默认为0
            fans.setGender(Byte.parseByte(1+""));
            fans.setSex(1+"");
            fans.setSexDesc("男");
        }else{
            fans.setGender(Byte.parseByte(user.getSex()+""));
            fans.setSex(user.getSex()+"");
            fans.setSexDesc(user.getSexDesc());
        }
        return fans;
    }

    private String caAuthentication(HttpServletRequest request) {

        if(request.getRequestURI().contains("oauth2")){
            String[] paths = StringUtils.split(request.getRequestURI(), '/');
            if(paths.length>2){
                return paths[1];
            }
        }
        return "";
    }

}
