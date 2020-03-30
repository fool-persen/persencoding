package com.persen.beijing.spring4;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by persen on 16/10/26.
 */

@Order(1)
@Component
public class OrderDemo2 {

    public  OrderDemo2() {
        System.out.println("constructor demo2");
    }
    @PostConstruct
    public void init() {
        System.out.println("demo2 start");
    }
}
