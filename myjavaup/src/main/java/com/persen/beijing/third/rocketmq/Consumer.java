package com.persen.beijing.third.rocketmq;

import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;

public class Consumer {
    public void substribe() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(
                "ConsumerGroupName5");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // //nameserver服务
        consumer.setNamesrvAddr("123.57.29.165:9876;101.200.78.122:9876");
        consumer.setInstanceName("Consumber");
        //consumer.setVipChannelEnabled(false);
        // 设置批量消费个数
        // consumer.setConsumeMessageBatchMaxSize(10);

        /**
         * 订阅指定topic下tags分别等于TagA或TagC或TagD
         */
        consumer.subscribe("DATAlijy", null);
        /**
         * 订阅指定topic下所有消息<br>
         * 注意：一个consumer对象可以订阅多个topic
         *
         */
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(
                    List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                // /接收消息个数msgs.size()
                System.out.println(Thread.currentThread().getName()
                        + " Receive New Messages: " + msgs.size());
                MessageExt msg = msgs.get(0);
                System.out.println(new String(msg.getBody()));
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        /**
         * Consumer对象在使用之前必须要调用start初始化，初始化一次即可<br>
         */
        consumer.start();
        System.out.println("ConsumerStarted.");
    }
}
