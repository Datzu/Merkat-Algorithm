package com.gmail.merkat;

import java.util.Random;
import java.util.Stack;

public class Car {
	private Stack<Integer> products;

	public Car() {
		this.products = new Stack<Integer>();
		fillCar();
	}

	public Car(Stack<Integer> products) {
		this.products = products;
	}

	public void fillCar() {
		for (int i = 0; i < new Random().nextInt(Utils.maxNProducts); i++) {
			products.add(i);
		}
	}

	public Stack<Integer> getProducts() {
		return products;
	}

	public void setProducts(Stack<Integer> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return products.toString();
	}

}
