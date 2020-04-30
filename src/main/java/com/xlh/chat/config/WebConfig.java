package com.xlh.chat.config;

import com.xlh.chat.interceptor.AccessLimitInterceptor;
import com.xlh.chat.interceptor.ApiIdempotentInterceptor;
import com.xlh.chat.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月19日 18:27 胡晓磊 Exp $
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Autowired
    private AccessLimitInterceptor accessLimitInterceptor;

    @Autowired
    private ApiIdempotentInterceptor apiIdempotentInterceptor;

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截路径可自行配置多个 可用 ，分隔开
        registry.addInterceptor(accessLimitInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/js/**", "/css/**", "/images/**", "/wechat/**","/favicon.ico","/error", "/druid/**");
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/js/**", "/css/**", "/images/**", "/wechat/**","/favicon.ico","/error", "/druid/**");
        registry.addInterceptor(apiIdempotentInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/js/**", "/css/**", "/images/**", "/wechat/**","/favicon.ico","/error", "/druid/**");
    }

    /**
     * 跨域支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS", "HEAD")
                .maxAge(3600 * 24);
    }
}
