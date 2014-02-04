package com.gmail.merkat;

public class Start {
	public static Merkat lidl;

	public static void main(String[] args) {

		lidl = new Merkat();
		lidl.start();
		
		GenerateCustomer genCus = new GenerateCustomer();
		genCus.start();
		ShowLidl t = new ShowLidl();
		t.start();
		startRun();
	}

	public Merkat getMerkat() {
		return lidl;
	}

	public synchronized static void startRun() {
		do{
			if (lidl.canAssign()) { 
				lidl.assignCustomer();
				lidl.updateTotalCustomer();
			}
		}while(true);

	}

	public static class ShowLidl extends Thread {
		public void ShowLidl() {

		}

		@Override
		public void run() {
			super.run();
			try {
				do {
					System.out.println(lidl.toString());
					Thread.sleep(500);
				} while (true);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
