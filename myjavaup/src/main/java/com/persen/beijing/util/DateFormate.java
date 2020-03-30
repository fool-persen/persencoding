package com.persen.beijing.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lijy on 2017/11/14.
 */
public class DateFormate {

	public static void main(String[] args) throws ParseException {
		// Date date = new Date();

		String dateStr4UTC = "2017-11-14 16:25:49";
		Date formatDate = new Date(2017, 10, 14, 16, 25, 49);
//		System.out.println("currentTime" + currentTime);
		System.out.println("dateStr4UTC" + dateStr4UTC);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String format = sdf.format(formatDate);
		System.out.println("format"+format);
	}
}
