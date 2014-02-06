package com.gmail.merkat;

import java.util.Random;

public class GenerateCustomer extends Thread {

	@Override
	public void run() {
		super.run();
		do {
			try {
				int n = new Random().nextInt(Utils.maxGenCustomers);
				System.out.println("Creating: " + n + " new customers.");
				if (n + Start.lidl.customerQueue.size() < Utils.maxNCustomers) {
					for (int i = 0; i < n; i++) {
						Start.lidl.customerQueue.add(new Customer(new Random()
								.nextInt()));
					}
				}
				Thread.sleep(new Random().nextInt(Utils.maxTimeGenCustomers
						- Utils.minimeGenCustomers)
						+ Utils.minimeGenCustomers);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}

}
