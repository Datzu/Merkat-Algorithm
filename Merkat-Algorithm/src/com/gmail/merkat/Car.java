package com.gmail.merkat;

import java.util.Stack;

public class Car {
	private Stack<Integer> products;

	public Car() {
		fillCar();
	}

	public Car(Stack<Integer> products) {
		this.products = products;
	}
	
	public void fillCar() {
		for (int i = 0; i < Utils.maxNProducts; i++) {
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
		return "Car [products=" + products + "]";
	}
	
}
