package com.persen.beijing.third.rocketmq;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

public class MainProduct {

    public static void main(String[] args) {
        Product product = new Product();
        try {
            product.init();
            String msg = "hello world11";
            product.publish(msg);
        } catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
