package com.ssafy.chat;

class MyThread extends Thread {
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

public class ThreadTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread() + " start");
		MyThread t = new MyThread();
		t.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.stopRun();
		System.out.println(Thread.currentThread() + " end");
	}

}
