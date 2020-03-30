package com.persen.beijing.spring4;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by persen on 16/10/26.
 */

@Order()
@Component
public class OrderDemo3 {
    public  OrderDemo3() {
        System.out.println("constructor demo3");
    }
    @PostConstruct
    public void init() {
        System.out.println("demo3 start");
    }
}
