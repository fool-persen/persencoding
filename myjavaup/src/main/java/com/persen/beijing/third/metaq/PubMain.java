package com.persen.beijing.third.metaq;

import com.taobao.metamorphosis.exception.MetaClientException;

public class PubMain {

    public static void main(String[] args) {
        Publish publish = new Publish();
        final String topic = "cloudTest";
        final String zkAddr = "172.168.1.217:2181";
        try {
            publish.init(topic, zkAddr);
            for (int i = 0; i < 10; i++) {
                String obj = "String " + i;
                publish.doPublis(topic, obj);
            }
        } catch (MetaClientException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        System.exit(0);
    }

}
