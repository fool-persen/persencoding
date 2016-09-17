package com.persen.beijing.spring3.ThreadLocal;


public class TestForumService {
    public static void main(String[] args) {
        ForumSrviceImpl forumService = new ForumSrviceImpl();
        forumService.removeTopic(2);
    }
}
