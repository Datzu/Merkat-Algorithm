package com.gmail.merkat;

import java.util.Random;

public class Start {
	
	public static Merkat lidl;

	public static void main(String[] args) {
		
		lidl = new Merkat();
		lidl.start();
		
		do {
			try {
				System.out.println(lidl.toString());
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);

	}

	public Merkat getMerkat() {
		return lidl;
	}

}
