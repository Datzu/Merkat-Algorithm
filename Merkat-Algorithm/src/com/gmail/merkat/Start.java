package com.gmail.merkat;


public class Start {
	
	public static Merkat lidl;

	public static void main(String[] args) {
		
		lidl = new Merkat();
		lidl.start();
		
		GenerateCustomer genCus = new GenerateCustomer();
		genCus.start();
		
		do {
			try {
				System.out.println(lidl.toString());
				do {
					
				} while (lidl.getAwaitingCustomers() > 0);
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);

	}

	public Merkat getMerkat() {
		return lidl;
	}
	
	public class asignCustomers extends Thread {
		
		@Override
		public void run() {
			super.run();
			lidl.assignCustomer();
		}
		
	}

}
