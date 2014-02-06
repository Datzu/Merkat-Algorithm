package com.gmail.merkat;

public class Start {
	public static Merkat lidl;

	public synchronized static void main(String[] args) {

		lidl = new Merkat();

		GenerateCustomer genCus = new GenerateCustomer();
		genCus.start();

		while (lidl.getTotalCustomers() > 0) {
			while (lidl.getCustomersInQueue() > 0) {
				lidl.assignCustomer();
			}
		}

	}

}
