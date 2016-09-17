package com.persen.beijing.third.rocketmq;

import com.alibaba.rocketmq.client.exception.MQClientException;

public class MainConsumer {

    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        try {
            consumer.substribe();
        } catch (MQClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
