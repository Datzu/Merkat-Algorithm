package com.gmail.merkat;

import java.util.Stack;

public class Car {
	private Stack products;

	public Car() {
	}

	public Car(Stack products) {
		this.products = products;
	}

	public Stack getProducts() {
		return products;
	}

	public void setProducts(Stack products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Car [products=" + products + "]";
	}
	
}
