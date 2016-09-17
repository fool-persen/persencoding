package com.persen.beijing.third.metaq;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.taobao.metamorphosis.Message;
import com.taobao.metamorphosis.client.MessageSessionFactory;
import com.taobao.metamorphosis.client.MetaClientConfig;
import com.taobao.metamorphosis.client.MetaMessageSessionFactory;
import com.taobao.metamorphosis.client.consumer.ConsumerConfig;
import com.taobao.metamorphosis.client.consumer.MessageConsumer;
import com.taobao.metamorphosis.client.consumer.MessageListener;
import com.taobao.metamorphosis.exception.MetaClientException;
import com.taobao.metamorphosis.utils.ZkUtils.ZKConfig;

public class Subscribe {
    // New session factory,强烈建议使用单例
    MessageSessionFactory sessionFactory;
    // create consumer,强烈建议使用单例
    MessageConsumer consumer;

    public void init(String zkAddr) throws MetaClientException {

        MetaClientConfig metaConfig = new MetaClientConfig();
        ZKConfig zkConfig = new ZKConfig();
        zkConfig.setZkConnect(zkAddr);
        metaConfig.setZkConfig(zkConfig);
        sessionFactory = new MetaMessageSessionFactory(metaConfig);
        consumer = sessionFactory.createConsumer(new ConsumerConfig("5"));
    }

    public void doSubscribe(String topic) throws MetaClientException {
        MesListener listener = new MesListener();
        consumer.subscribe(topic, 1024 * 1024, listener);
        // complete subscribe
        System.out.println("complete subscribe");
        consumer.completeSubscribe();
    }
}

class MesListener implements MessageListener {

    @Override
    public Executor getExecutor() {
        // return Executors.newFixedThreadPool(6);
        return null;
    }

    @Override
    public void recieveMessages(Message message) throws InterruptedException {
        // TODO Auto-generated method stub
        System.out.println(Thread.currentThread().getName() + " "
                + Thread.currentThread().getId() + " " + this.hashCode()
                + " Receive message " + new String(message.getData()));
    }

}