package com.persen.beijing.object;

import static java.lang.Thread.sleep;

/**
 * Created by persen on 2016/11/10.
 */
class Parent {
	static String name = "hello";

	{
		System.out.println("parent block");
	}

	static {
		System.out.println("parent static block");
	}

	public Parent() {
		System.out.println("parent constructor");
	}

	public void finalize() {
		System.out.println("parent finalize");
	}
}

class Child extends Parent {
	static String childName = "hello";

	{
		System.out.println("child block");
	}

	static {
		System.out.println("child static block");
	}

	public Child() {
		System.out.println("child constructor");
	}

	public void finalize() {

		System.out.println("child finalize");
	}
}

public class StaticIniBlockOrderTest {

	public static void func() {

		Parent p = new Child();//语句(*)
	}

	public static void main(String[] args) throws InterruptedException {
		func();
		System.gc();
		Thread.sleep(10000);
	}
}