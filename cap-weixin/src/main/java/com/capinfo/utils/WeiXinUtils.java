package com.capinfo.utils;

import com.capinfo.base.CurrentUser;
import com.capinfo.shiro.token.WeiXinAuth2Token;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;

public class WeiXinUtils {

    /**
     * 获取当前微信登录者
     */
    public static WeiXinAuth2Token getPrincipal(){
        try{
            org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
            Object principal = subject.getPrincipal();
            System.out.println(principal);
            Session session = subject.getSession();
            return (WeiXinAuth2Token) session.getAttribute("weiXinUser");
        }catch (UnavailableSecurityManagerException e) {

        }catch (InvalidSessionException e){

        }
        return null;
    }


    public static void setPrincipal(WeiXinAuth2Token token){
        try{
            org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            session.setAttribute("weiXinUser",token);
            session.touch();
        }catch (UnavailableSecurityManagerException e) {

        }catch (InvalidSessionException e){

        }
    }


    public static void main(String[] args) {

        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId("wxe8d85e92589eaf95");
        config.setSecret("5b5e98ee43eb5a6e79a23f74fce434fb");
        config.setToken(""); // 设置微信公众号的token
        config.setAesKey(""); // 设置微信公众号的EncodingAESKey

    }



}
