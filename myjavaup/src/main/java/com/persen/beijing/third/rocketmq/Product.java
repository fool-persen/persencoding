package com.persen.beijing.third.rocketmq;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

public class Product {
    DefaultMQProducer producer;

    public void init() throws MQClientException {
        producer = new DefaultMQProducer("testProductGroup");
        producer.setNamesrvAddr("123.57.29.165:9876;101.200.78.122:9876");
        producer.setInstanceName("product");
        //producer.setVipChannelEnabled(false);
        //producer.setSendMessageWithVIPChannel(false);
        producer.start();
    }

    public void publish(String ms) throws MQClientException, RemotingException,
            MQBrokerException, InterruptedException {
        Message msg = new Message("dccTest",// topic
                "TagA",// tag
                ms.getBytes()// body
        );
        SendResult sendResult = producer.send(msg);
        System.out.println(sendResult);
    }
}
