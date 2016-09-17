package com.persen.beijing.third.metaq;

import com.taobao.metamorphosis.Message;
import com.taobao.metamorphosis.client.MessageSessionFactory;
import com.taobao.metamorphosis.client.MetaClientConfig;
import com.taobao.metamorphosis.client.MetaMessageSessionFactory;
import com.taobao.metamorphosis.client.producer.MessageProducer;
import com.taobao.metamorphosis.client.producer.SendResult;
import com.taobao.metamorphosis.exception.MetaClientException;
import com.taobao.metamorphosis.utils.ZkUtils.ZKConfig;

public class Publish {
    private MessageSessionFactory sessionFactory;
    private MessageProducer producer;

    public void init(String topic, String zkAddr) throws MetaClientException {
        MetaClientConfig metaConfig = new MetaClientConfig();
        ZKConfig zkConfig = new ZKConfig();
        zkConfig.setZkConnect(zkAddr);
        metaConfig.setZkConfig(zkConfig);
        sessionFactory = new MetaMessageSessionFactory(metaConfig);
        producer = sessionFactory.createProducer();
        producer.publish(topic);
    }

    public void doPublis(String topic, Object obj) throws MetaClientException,
            InterruptedException {
        Message mess = new Message(topic, obj.toString().getBytes());
        SendResult sendResult = producer.sendMessage(mess);
        // check result
        if (!sendResult.isSuccess()) {
            System.err.println("Send message failed,error message:"
                    + sendResult.getErrorMessage());
        } else {
            System.out.println("Send message successfully,sent to "
                    + sendResult.getPartition());
        }
    }
}
