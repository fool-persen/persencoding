package com.persen.beijing.util;

/**
 * Created by lijy on 2017/3/21.
 */


public class EnumDeam {

	public enum Color {
		RED, BLUE, BLACK, YELLOW, GREEN
	}

	public static void main(String[] args) {
		Enum<Color> ee = Enum.valueOf(Color.class, "RED");

		System.out.println(ee.name());
		System.out.println(ee.ordinal());

	}
}
