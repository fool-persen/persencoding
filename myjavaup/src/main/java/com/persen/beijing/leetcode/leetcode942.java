package com.persen.beijing.leetcode;

/**
 * Created by lijianyu on 2019/2/19.
 */
public class leetcode942 {
    public static void main(String[] args) {
        int[] ret = diStringMatch("IDID");
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i]);
            System.out.print(" ");
        }
    }

    public static int[] diStringMatch(String S) {
        S.toCharArray();
        int max = S.length();
        int length = S.length();
        int min = 0;
        int[] ins = new int[length + 1];
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            switch (c) {
                case 'I':
                    ins[i] = min++;
                    break;
                case 'D':
                    ins[i] = max--;
                    break;
                default:
                    System.out.println("error");
            }
        }
        ins[length] = min;
        return ins;
    }
}

