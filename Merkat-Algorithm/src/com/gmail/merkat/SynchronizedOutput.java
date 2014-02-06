package com.gmail.merkat;

public class SynchronizedOutput {

	public static synchronized void display() {
		try {
			System.out.println(Start.lidl.toString());
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
