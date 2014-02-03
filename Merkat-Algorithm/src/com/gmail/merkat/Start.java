package com.gmail.merkat;

import java.util.Random;

public class Start {
	
	public static Merkat lidl;

	public static void main(String[] args) {
		
		lidl = new Merkat();
		lidl.start();
		
		GenerateCustomer genCus = new GenerateCustomer();
		genCus.start();
		
		do {
			try {
				//System.out.println(lidl.toString());
				System.out.println(lidl.getAwaitingCustomers());
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
