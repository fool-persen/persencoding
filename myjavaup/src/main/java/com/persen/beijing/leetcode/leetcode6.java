package com.persen.beijing.leetcode;

/**
 * Created by lijianyu on 2019/2/20.
 */
public class leetcode6 {
    public static void main(String[] args) {
        String str = "LEETCODEISHIRING";
        String ret = convert(str, 3);
        System.out.println(ret);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 0 || numRows == 1 || s.length() == 0) {
            return s;
        }
        String ret = "";
        int zoneLen = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j = j + zoneLen) {
                ret += s.charAt(j);
                int index = j + zoneLen - 2 * i;
                if (i != 0 && i != numRows - 1 && index < s.length()) {
                    ret += s.charAt(index);
                }
            }
        }
        return ret;
    }
}