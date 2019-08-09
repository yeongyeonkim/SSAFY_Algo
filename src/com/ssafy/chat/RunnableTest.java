package com.ssafy.chat;

class MyRunnable implements Runnable {
	private int i = 0;
	private boolean isRunning = true;

	public void stopRun() {
		isRunning = false;
	}

	public void run() {
		while (isRunning) {
			System.out.println(Thread.currentThread() + " i=" + i);
			if (i >= 160)
				break;
			i++;
		}
	}
}

public class RunnableTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread() + " start");
		MyRunnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		r.stopRun();
		System.out.println(Thread.currentThread() + " end");
	}

}
