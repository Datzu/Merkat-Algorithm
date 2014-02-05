package com.gmail.merkat;

public class Start {
	public static Merkat lidl;

	public static void main(String[] args) {

		lidl = new Merkat();

		GenerateCustomer genCus = new GenerateCustomer();
		genCus.start();

		ShowLidl showLidl = new ShowLidl();
		showLidl.start();

		while (lidl.getTotalCustomers() > 0) {
			showLidl.run();
			while (lidl.getCustomersInQueue() > 0) {
				lidl.assignCustomer();
			}
		}

	}

	public static class ShowLidl extends Thread {

		@Override
		public void run() {
			super.run();
			if (!this.isAlive()) {
				try {
					System.out.println(lidl.toString());
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
