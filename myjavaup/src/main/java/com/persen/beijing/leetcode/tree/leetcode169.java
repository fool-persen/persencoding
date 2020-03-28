package com.persen.beijing.leetcode.tree;

import org.junit.Test;

/**
 * Created by lijianyu on 2020/3/24.
 */
public class leetcode169 {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int key = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                key = nums[i];
                cnt = 1;
            } else {
                if (key == nums[i]) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }
        if (cnt == 0) {
            return -1;
        }
        return key;
    }

    @Test
    public void test() {
        int[] nums = {2,2,1,1,1,2};
        int ret = majorityElement(nums);
        System.out.println(ret);
    }
}
