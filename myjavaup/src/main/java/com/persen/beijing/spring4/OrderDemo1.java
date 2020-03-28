package com.persen.beijing.spring4;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by persen on 16/10/26.
 */

@Order(2)
@Component
public class OrderDemo1 {
    public  OrderDemo1() {
        System.out.println("constructor demo1");
    }
    @PostConstruct
    public void init() {
        System.out.println("demo1 start");
    }
}
