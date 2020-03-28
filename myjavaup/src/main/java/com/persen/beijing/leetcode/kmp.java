package com.persen.beijing.leetcode;

/**
 * Created by lijianyu on 2019/9/3.
 */
public class kmp {
    public static void main(String[] args) {
        char[] source = "BBC ABCDAB ABCDABCDABDE".toCharArray();
        char[] sub = "ABCDABD".toCharArray();
        int index = kmpMatch(source, sub);
//        int index = violentMatch(source, sub);

        System.out.println(index);
    }

    private static int violentMatch(char[] source, char[] sub) {
        int i = 0, j = 0;
        while (i < source.length) {
            if (j == sub.length) {
                return i - j;
            }
            if (source[i] == sub[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }

        }
        return -1;
    }

    private static int kmpMatch(char[] source, char[] sub) {
        int[] next = kmpNext(sub);
        int i = 0, j = 0;
        while (i < source.length && j < sub.length) {
            if (j == -1 || source[i] == sub[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == sub.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    private static int[] kmpNext(char[] sub) {
        int lenth = sub.length;
        int[] next = new int[lenth];
        int k = -1, j = 0;

        next[j] = -1;
        k = next[j];
        while (j < lenth - 1) {
            if (k == -1 || sub[j] == sub[k]) {
                j++;
                k++;
                if (sub[j] == sub[k]) {
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        for (int i = 0; i < lenth; i++) {
            System.out.println(next[i]);
        }
        return next;
    }
}
