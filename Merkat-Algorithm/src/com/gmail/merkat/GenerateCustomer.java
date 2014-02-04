package com.gmail.merkat;

import java.util.Random;

public class GenerateCustomer extends Thread {

	@Override
	public void run() {
		super.run();
		do {
			try {
				int n = new Random().nextInt(Utils.maxGenCustomers);
				if (n + Start.lidl.getAwaitingCustomers() < Utils.maxNCustomers) {
					Start.lidl.setAwaitingCustomers(Start.lidl
							.getAwaitingCustomers() + n);
//					System.out.println("Creating: " + n + " new customers.\n");
				}
				Thread.sleep(new Random().nextInt(Utils.maxTimeGenCustomers-Utils.minimeGenCustomers)+Utils.minimeGenCustomers);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);

	}

}
