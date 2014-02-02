package com.gmail.merkat;

public class Customer {
	private int id;
	private Car cart;

	public Customer() {
	}
	
	public Customer(int id, Car cart) {
		this.id = id;
		this.cart = cart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Car getCart() {
		return cart;
	}

	public void setCart(Car cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "\n\t\tCustomer [id=" + id + ", cart=" + cart + "]";
	}

	
}
