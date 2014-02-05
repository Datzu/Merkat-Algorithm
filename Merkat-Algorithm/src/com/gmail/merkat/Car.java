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
		int prova = new Random().nextInt(Utils.maxNProducts);
		for (int i = 0; i < prova; i++) {
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
		String s = "\n\t\t\tProducts: ";
		for (int i = 0; i < products.size(); i++) {
			s += (i + " ");
		}
		return s;
	}

}
