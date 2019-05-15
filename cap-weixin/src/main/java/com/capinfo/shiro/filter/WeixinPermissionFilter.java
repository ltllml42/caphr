package com.capinfo.shiro.filter;

import com.capinfo.shiro.token.WeiXinAuth2Token;
import lombok.Data;
import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 微信 OAuth2 权限验证管理
 */

@Data
public class WeixinPermissionFilter extends AuthenticatingFilter {

    //绑定
    private WxMpService wxService;

    @Autowired
    public WeixinPermissionFilter(WxMpService wxService) {
        this.wxService = wxService;
    }


    //表明是访问微信资源的请求,省略set方法
    private String urlPattern;
    //微信请求对应跳转页面,省略set方法
    private String wxloginUrl;
    //未登录重定向到登陆页


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        System.out.println(httpRequest.getRequestURI());
        Subject subject = getSubject(request, response);
        if (subject.isAuthenticated()) {
            WeiXinAuth2Token wxToken = (WeiXinAuth2Token)subject.getPrincipal();
            if(wxToken==null){
                return false;
            }
            if(StringUtils.isBlank(wxToken.getAccessTaken())){//需要处理Seesion的实效问题
                return false;
            }
            return true;
        }

        if (httpRequest.getRequestURI().contains("oauth2")) {
            String code = httpRequest.getParameter("code");
            if (StringUtils.isBlank(code)) {
                return false;
            }
            String[] paths = StringUtils.split(httpRequest.getRequestURI(), '/');
            if (paths.length > 2) {
                return subject.isAuthenticated();
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        return true;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        //System.out.println("我失败了onLoginFailure");
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        String code = httpRequest.getParameter("code");
        if (StringUtils.isBlank(code)) {
            try {
                String url = wxService.oauth2buildAuthorizationUrl("http://litaolin.nat300.top/" + httpRequest.getRequestURI(), "snsapi_userinfo", "");
                HttpServletResponse httpResponse = WebUtils.toHttp(response);
                httpResponse.sendRedirect(url);
                // WebUtils.issueRedirect(request, response, url);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return false;
        }
        try {
            WebUtils.issueRedirect(request, response, "http://litaolin.nat300.top/wx/message/fail");
            return false;
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return false;
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        WeiXinAuth2Token wxToken = new WeiXinAuth2Token(request,response);
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        String code = httpRequest.getParameter("code");
        if (StringUtils.isNotBlank(code)) {
            wxToken.setCode(code);
        }
        return wxToken;
    }


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return executeLogin(request, response);
    }


}
