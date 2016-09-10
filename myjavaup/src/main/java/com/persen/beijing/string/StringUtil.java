package com.persen.beijing.string;

import org.springframework.util.StringUtils;

public class StringUtil {

	public static String func() {
		String deviceNumber = "170";
		String imsi = null;
		boolean bb = StringUtils.isEmpty(deviceNumber);
		return bb ? deviceNumber : imsi;

	}

	public static void main(String[] args) {
		String ss = func();
		System.out.println(ss);
	}
}
