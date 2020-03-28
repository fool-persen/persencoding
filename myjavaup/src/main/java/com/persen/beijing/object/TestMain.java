package com.persen.beijing.object;

/**
 * Created by lijy on 2018/5/29.
 */
public class TestMain {
	public static void main(String[] args) {
		Object obj = new TypeTest();
		Object target = (TypeDemo)obj;
		System.out.println(target);
	}
}
