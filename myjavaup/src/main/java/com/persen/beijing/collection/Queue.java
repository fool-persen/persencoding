package com.persen.beijing.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by lijianyu on 2019/9/30.
 */
public class Queue {
    @Test
    public void testSynchronousQueue() {
        SynchronousQueue queue = new SynchronousQueue();
        Map<String, String> map = new HashMap<>();
        Set<String> set = map.keySet();
        set.stream();
    }
}
