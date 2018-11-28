package com.persen.bj.annotation;

import java.lang.annotation.*;

/**
 * Created by lijianyu on 2018/11/3.
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface HystrixThreadPoll2 {
    String threadPoolKey() default "poll2";
}
