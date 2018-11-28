package com.persen.bj.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

/**
 * Created by lijianyu on 2018/11/28.
 */
public class StringHystrixCommond extends HystrixCommand<String> {

    private String id;

    public StringHystrixCommond(String id) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("stringCommandGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("stringCommand")));
        this.id = id;
    }


    /**
     * 覆写run方法，此处写业务逻辑
     */
    @Override
    protected String run() throws Exception {
        System.out.println("command string: " + Thread.currentThread().getName() + "  is running......");

        return "StringHystrixCommond runnable";
    }

    /**
     * 服务降级方法，当调用服务发生异常时，会调用该降级方法
     */
    @Override
    protected String getFallback() {
        System.out.println("进入fallback方法!");
        return "fail";
    }
}

