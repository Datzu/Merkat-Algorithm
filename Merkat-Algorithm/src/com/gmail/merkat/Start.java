package com.gmail.merkat;

import java.util.ArrayList;

public class Start {

	public static Merkat lidl = new Merkat();

	public synchronized static void main(String[] args) {
		
		lidl.start();
		
	}

}
