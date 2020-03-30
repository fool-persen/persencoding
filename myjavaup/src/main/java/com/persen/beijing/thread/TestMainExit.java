package com.persen.beijing.thread;

/**
 * Created by lijy on 2018/4/28.
 */
public class TestMainExit {
	public static void main(String[] args) {
		Thread mt = new Thread(new MyThread());
		mt.start();
		System.out.println("main");
		System.exit(1);
	}
}
