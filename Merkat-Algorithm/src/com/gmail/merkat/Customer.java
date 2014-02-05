package com.gmail.merkat;

public class Customer {

	private int id;
	private Car cart;

	public Customer(int id) {
		this.id = id;
		this.cart = new Car();
	}

	@Override
	public String toString() {
		return "\n\tCustomer " + this.id + " -> " + cart.toString();
	}

}
