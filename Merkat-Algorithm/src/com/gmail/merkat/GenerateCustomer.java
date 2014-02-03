package com.gmail.merkat;

import java.util.Random;

public class GenerateCustomer extends Thread {

	@Override
	public void run() {
		super.run();
		do {
			try {
				int n = new Random().nextInt(Utils.maxNCustomers) / 20;
				if (n + Start.lidl.getAwaitingCustomers() < Utils.maxNCustomers) {
					Start.lidl.setAwaitingCustomers(Start.lidl
							.getAwaitingCustomers() + n);
					System.out.println("Creating: " + n + " new customers.\n");
				} else {
					System.out.println("Canno't create new customers.\n");
				}
				Thread.sleep(Utils.maxTimeGenCustomers);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);

	}

}
