package com.persen.bj.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lijianyu on 2018/11/27.
 */
public class RefreshConfigAdapter extends WebMvcConfigurerAdapter {

    @Autowired
    RefreshInterceptors interceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(interceptors).addPathPatterns("/**");
    }
}
