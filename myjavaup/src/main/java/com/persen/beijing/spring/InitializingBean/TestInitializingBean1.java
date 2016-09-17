package com.persen.beijing.spring.InitializingBean;

import org.springframework.beans.factory.InitializingBean;

public class TestInitializingBean1 implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化1");
    }

}
