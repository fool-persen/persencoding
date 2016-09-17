package com.persen.beijing.spring3.ThreadLocal;


public class ForumSrviceImpl {

    public void removeTopic(int topicId) {
        PerformanceMonitor
                .begin("com.persen.beijing.spring3.ForumSrviceImpl.removeTopic");
        System.out.println("模拟删除Topic记录:" + topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PerformanceMonitor.end();
    }
}
