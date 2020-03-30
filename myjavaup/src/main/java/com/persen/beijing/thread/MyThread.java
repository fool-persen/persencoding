package com.persen.beijing.thread;

/**
 * Created by lijy on 2018/4/28.
 */
public class MyThread implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("run" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}