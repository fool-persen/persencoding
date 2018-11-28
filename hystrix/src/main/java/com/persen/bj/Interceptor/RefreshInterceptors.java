package com.persen.bj.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lijianyu on 2018/11/27.
 */
public class RefreshInterceptors implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);

    private volatile boolean handleFlag = false;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handleFlag) {
            Thread.sleep(600);
            logger.debug("RefreshInterceptors refuse request");
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public boolean isHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(boolean handleFlag) {
        this.handleFlag = handleFlag;
    }
}
