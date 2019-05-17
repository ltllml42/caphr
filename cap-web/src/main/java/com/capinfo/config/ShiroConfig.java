package com.capinfo.config;

import com.capinfo.core.filter.PermissionFilter;
import com.capinfo.core.filter.VerfityCodeFilter;
import com.capinfo.core.shiro.CustomeModularRealmAuthenticator;
import com.capinfo.core.shiro.LoginRealm;
import com.capinfo.core.shiro.RetryLimitCredentialsMatcher;
import com.capinfo.shiro.WeChatOauth2Realm;
import com.capinfo.shiro.filter.WeixinPermissionFilter;
import com.google.common.collect.Maps;
import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.*;

/**
 * @author zhuxiaomeng
 * @date 2018/1/1.
 * @email 154040976@qq.com
 * spring shiro
 * 元旦快乐：code everybody
 */
@Configuration
@AutoConfigureAfter(WeiXinConfig.class)
public class ShiroConfig {

    @Bean
    public RetryLimitCredentialsMatcher getRetryLimitCredentialsMatcher() {
//    RetryLimitCredentialsMatcher rm = new RetryLimitCredentialsMatcher(getCacheManager(),2);
        RetryLimitCredentialsMatcher rm = new RetryLimitCredentialsMatcher(getCacheManager());
        rm.setHashAlgorithmName("md5");
        rm.setHashIterations(4);
        return rm;

    }

    @Bean(name = "weChatOauth2Realm")
    public WeChatOauth2Realm getWeChatOauth2Realm() {
        WeChatOauth2Realm realm = new WeChatOauth2Realm();
        return realm;
    }

    @Bean(name = "loginRealm")
    public LoginRealm getLoginRealm() {
        LoginRealm realm = new LoginRealm();
        realm.setCredentialsMatcher(getRetryLimitCredentialsMatcher());
        return realm;
    }

    @Bean
    public EhCacheManager getCacheManager() {
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:ehcache/ehcache.xml");
        return ehCacheManager;
    }

    @Bean
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean(name = "securityManager")
    public SecurityManager getSecurityManager(@Qualifier("loginRealm") LoginRealm loginRealm,
                                              @Qualifier("weChatOauth2Realm") WeChatOauth2Realm weChatOauth2Realm) {
        DefaultWebSecurityManager dwm = new DefaultWebSecurityManager();
        dwm.setAuthenticator(getCustomeModularRealmAuthenticator());
        List<Realm> realms = new ArrayList<Realm>();
        realms.add(loginRealm);
        realms.add(weChatOauth2Realm);
        dwm.setRealms(realms);
        //dwm.setRealm(loginRealm);
        dwm.setCacheManager(getCacheManager());
        dwm.setSessionManager(defaultWebSessionManager());
        return dwm;
    }

    public Authenticator getCustomeModularRealmAuthenticator() {
        CustomeModularRealmAuthenticator cmra = new CustomeModularRealmAuthenticator();
        return cmra;
    }

    @Bean
    public PermissionFilter getPermissionFilter() {
        PermissionFilter pf = new PermissionFilter();
        return pf;
    }

    @Bean
    public VerfityCodeFilter getVerfityCodeFilter() {
        VerfityCodeFilter vf = new VerfityCodeFilter();
        vf.setFailureKeyAttribute("shiroLoginFailure");
        vf.setJcaptchaParam("code");
        vf.setVerfitiCode(true);
        return vf;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager, @Qualifier("wxMpService") WxMpService wxMpService) {
        ShiroFilterFactoryBean sfb = new ShiroFilterFactoryBean();
        sfb.setSecurityManager(securityManager);
        sfb.setLoginUrl("/login");
        sfb.setUnauthorizedUrl("/goLogin");
        Map<String, Filter> filters = new HashMap<>();
        filters.put("per", getPermissionFilter());
        filters.put("verCode", getVerfityCodeFilter());
        filters.put("oauth2", getWeixinPermissionFilter(wxMpService));
        sfb.setFilters(filters);
        Map<String, String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/**","anon");
        filterMap.put("/login", "verCode,anon");
        //http://localhost/wx
        filterMap.put("/oauth2/**", "oauth2");
        filterMap.put("/wx/**", "anon");
        //filterMap.put("/login","anon");
        filterMap.put("/getCode", "anon");
        filterMap.put("/blog/**", "anon");
        filterMap.put("/logout", "logout");
        filterMap.put("/plugin/**", "anon");
        filterMap.put("/user/**", "per");
        filterMap.put("/adviceMobile/**", "anon");
        filterMap.put("/car/**", "anon");
        filterMap.put("/**", "authc");
        sfb.setFilterChainDefinitionMap(filterMap);
        return sfb;
    }

    private WeixinPermissionFilter getWeixinPermissionFilter(WxMpService wxMpService) {
        WeixinPermissionFilter pf = new WeixinPermissionFilter(wxMpService);
        return pf;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor as = new AuthorizationAttributeSourceAdvisor();
        as.setSecurityManager(securityManager);
        return as;
    }

    @Bean
    public DefaultWebSessionManager defaultWebSessionManager() {
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        defaultWebSessionManager.setSessionIdCookieEnabled(true);
        defaultWebSessionManager.setGlobalSessionTimeout(28800000);
        defaultWebSessionManager.setDeleteInvalidSessions(true);
        defaultWebSessionManager.setSessionValidationSchedulerEnabled(true);
        defaultWebSessionManager.setSessionIdUrlRewritingEnabled(false);
        return defaultWebSessionManager;
    }

/*
  @Bean
  public FilterRegistrationBean delegatingFilterProxy(){
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    DelegatingFilterProxy proxy = new DelegatingFilterProxy();
    proxy.setTargetFilterLifecycle(true);
    proxy.setTargetBeanName("shiroFilter");

    filterRegistrationBean.setFilter(proxy);
    return filterRegistrationBean;
  }*/


}
