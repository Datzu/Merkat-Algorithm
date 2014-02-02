package com.gmail.merkat;

public class Start {
	private static Merkat lidl;

	public static void main(String[] args) {
		lidl = new Merkat();
		lidl.start();
		System.out.println(lidl.toString());
	}
	
	public Merkat getMerkat() {
		return lidl;
	}

}
