package com.persen.bj.annotation;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by lijianyu on 2018/11/3.
 */
//@Aspect
//@Component
public class HystrixCommandThreadPoll1Aspect extends HystrixCommandAspect {
    @Pointcut("@annotation(com.persen.bj.annotation.HystrixThreadPoll1)")

    public void hystrixThhreadPoll1AnnotationPointcut() {
    }


    @Override
    @Around("hystrixThhreadPoll1AnnotationPointcut()")
    public Object methodsAnnotatedWithHystrixCommand(final ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("2222222");
        return super.methodsAnnotatedWithHystrixCommand(joinPoint);
    }
}
