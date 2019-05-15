package com.capinfo.shiro.token;

import com.capinfo.entity.CapVehicleInfo;
import com.capinfo.entity.CapWxAccountFans;
import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Date;
import java.util.List;

@Data
public class WeiXinAuth2Token implements AuthenticationToken {

    private String code;
    private String accessTaken;
    private String refreshToken;//可以使用20天的refreshToken
    private Date lastVisitDate;//最后一次访问时间
    private int effectiveTime;
    private int codeCount;//code只能用一次，所以用过之后就不能在用了
    private CapWxAccountFans fansInfo = new CapWxAccountFans();
    private List<CapVehicleInfo> cvInfoList;
    private String appid;
    private ServletRequest request;
    private ServletResponse response;

    @Override
    public Object getPrincipal() {
        return this;
    }

    @Override
    public Object getCredentials() {
        return this.getFansInfo().getOpenId();
    }


    public WeiXinAuth2Token(ServletRequest request, ServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public WeiXinAuth2Token() {

    }


    public void setCvInfoList() {
    }
}
