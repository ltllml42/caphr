package com.capinfo.config;

import com.capinfo.interceptor.MobileInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.naming.factory.BeanFactory;
import org.aspectj.runtime.reflect.Factory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author zhuxiaomeng
 * @date 2018/1/1.
 * @email 154040976@qq.com
 * spring shiro
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Value("${capsp.imagePath}")
    private String imagePath;
    @Value("${capsp.uploadPath}")
    private String filePath;

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }




    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
    }
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(getMappingJackson2HttpMessageConverter());
        converters.add(responseBodyConverter());

    }




    @Bean
    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        //设置日期格式
        mappingJackson2HttpMessageConverter.setPrettyPrint(false);
        ObjectMapper objectMapper = new JsonMapper();
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        //设置中文编码格式
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.APPLICATION_JSON_UTF8);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
        return mappingJackson2HttpMessageConverter;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/").setCachePeriod(0);
        registry.addResourceHandler("/plugin/**", "/static/**")
                .addResourceLocations("classpath:/plugin/", "classpath:/static/");
        registry.addResourceHandler("/ftl/**").addResourceLocations("classpath:/ftl/");
        registry.addResourceHandler("/images/**").addResourceLocations("file:" + imagePath);
        registry.addResourceHandler("/file/**").addResourceLocations("file:" + imagePath);
        super.addResourceHandlers(registry);
    }

    /*保留国际化*/
    @Bean
    public LocaleChangeInterceptor interceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    @Bean
    public MobileInterceptor mobileInterceptor(){
        return new MobileInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(interceptor());
        registry.addInterceptor(mobileInterceptor())
                .addPathPatterns("/**");
    }

    @Bean
    public LocaleResolver resolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(Locale.US);
        return resolver;
    }
}
