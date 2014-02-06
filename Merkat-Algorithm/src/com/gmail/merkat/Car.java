package com.gmail.merkat;

import java.util.Random;
import java.util.Stack;

public class Car {
	
	private Stack<Integer> products;

	public Car() {
		this.products = new Stack<Integer>();
		fillCar();
	}

	public void fillCar() {
		for (int i = 0; i < new Random().nextInt(Utils.maxNProducts); i++) {
			products.add(i);
		}
	}

	@Override
	public String toString() {
		return products.toString();
	}

}
