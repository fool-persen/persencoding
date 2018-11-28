package com.persen.bj.annotation;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import org.springframework.beans.factory.annotation.Value;

import java.lang.annotation.*;

/**
 * Created by lijianyu on 2018/11/3.
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface HystrixThreadPoll1 {

    String threadPoolKey() default "poll1";

    int coreSize() default 10;

    int maxQueueSize() default 10;

}
