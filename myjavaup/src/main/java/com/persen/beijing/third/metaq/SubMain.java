package com.persen.beijing.third.metaq;

import com.taobao.metamorphosis.exception.MetaClientException;

public class SubMain {

    public static void main(String[] args) {
        Subscribe subscribe = new Subscribe();
        final String topic = "cloudTest";
        final String zkAddr = "172.168.1.217:2181";

        try {
            subscribe.init(zkAddr);
            subscribe.doSubscribe(topic);
        } catch (MetaClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //System.exit(0);
    }

}
