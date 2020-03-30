package com.persen.beijing.thread;

/**
 * Created by lijy on 2018/7/1.
 */
public class InOutThreadMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Business business = new Business();
		/*子线程*/
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					business.sub(i);
				}
			}
		}).start();

		/*主线程*/
		for (int i = 1; i <= 50; i++) {
			business.main(i);
		}
	}


}

class Business {//处理线程安全归为一类，这样用的就是同一把同步锁
	boolean subShouldRun = true; //当为true时子线程执行，当为false时主线程执行

	public synchronized void sub(int i) {
		while (!subShouldRun) {
			try {
				this.wait();//等待线程
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 10; j++) {
			System.out.println("sub Thread sequence of " + j + ", loop of " + i);
		}
		subShouldRun = false;
		this.notify();//唤醒线程
	}

	public synchronized void main(int i) {
		while (subShouldRun) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 100; j++) {
			System.out.println("main Thread sequence of " + j + ", loop of " + i);
		}
		subShouldRun = true;
		this.notify();
	}

}
