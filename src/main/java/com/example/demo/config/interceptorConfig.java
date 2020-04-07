package com.example.demo.config;

import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 */
@Configuration
public class interceptorConfig implements WebMvcConfigurer {
    /**
     * 添加拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册interceptor拦截器
        InterceptorRegistration interceptorRegistry=registry.addInterceptor(new LoginInterceptor());
        //所有路径都拦截
        interceptorRegistry.addPathPatterns("/**");
        //添加不拦截路径
        interceptorRegistry.excludePathPatterns("/Login");
    }
}
