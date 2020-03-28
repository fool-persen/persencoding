package com.persen.beijing.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lijianyu on 2019/12/20.
 */
public class leetcode793 {
    @Test
    public void test() {
        int input = 12;
        int ret = preimageSizeFZF(input);
        System.out.println(ret);
    }

    public int preimageSizeFZF(int K) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 0);
        map.put(5, 0);
        if (K == 0)
            return 0;
        for (int i = 1; i <= K; i++) {
            if (i % 2 == 0) {
                Integer value2 = map.get(2);
                int j = i;
                while (j % 2 == 0) {
                    value2 += 1;
                    j = j / 2;
                }
                map.put(2, value2);
            }
            if (i % 5 == 0) {
                Integer value5 = map.get(5);
                int j = i;
                while (j % 5 == 0) {
                    value5 += 1;
                    j = j / 5;
                }
                map.put(5, value5);
            }
        }
        int value2 = map.get(2);
        int value5 = map.get(5);
        int ret = value2 > value5 ? value5 : value2;
        return ret;
    }
}
