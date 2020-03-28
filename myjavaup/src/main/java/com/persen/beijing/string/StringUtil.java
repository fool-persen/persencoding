package com.persen.beijing.string;

import org.springframework.util.StringUtils;

public class StringUtil {

    public static String func() {
        String deviceNumber = "170";
        String imsi = null;
        boolean bb = StringUtils.isEmpty(deviceNumber);
        return bb ? deviceNumber : imsi;

    }

    public static String func1() {
        StringBuilder builder = new StringBuilder();
        String value0 = "11";
        String value = null;
        System.out.print(builder.toString());
        builder.append(value0);
        builder.append(value);
        return builder.toString();
    }

    public static void main(String[] args) {
        String ss = func();
        System.out.println(ss);
        System.out.print(func1());
    }
}
