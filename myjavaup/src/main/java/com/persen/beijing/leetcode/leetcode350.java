package com.persen.beijing.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lijianyu on 2019/2/25.
 */
/*
350. 两个数组的交集 II
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。
进阶:

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class leetcode350 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {1, 2};
        int[] ret = intersect(nums1, nums2);
        System.out.println();
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();
        int checked = 0;
        int num2Lenth = nums2.length;
        for (int i = 0; i < nums1.length; i++) {
            checked = 0;
            for (int j = 0; j < num2Lenth; j++) {
                if (nums1[i] == nums2[j] && checked == 0) {
                    list.add(nums2[j]);
                    checked = 1;
                    continue;
                }
                if (checked == 1 && num2Lenth >= 1) {
                    nums2[j - 1] = nums2[j];
                }
            }
            if (checked == 1) {
                num2Lenth--;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
