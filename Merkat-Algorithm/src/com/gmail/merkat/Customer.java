package com.gmail.merkat;
/**
 * Classe per representar el client
 * 
 * @author Adria i Gerard
 * @since 31-01-2014
 */
public class Customer {

	private int id;  // id del client
	private Car cart; // Variable de tipus carret per definir un carret

	public Customer(int id) {
		this.id = id;
		this.cart = new Car();
	}
	/**
	 * retorna la id del client 
	 * @return int
	 */
	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "\n\tCustomer " + this.id + " -> " + cart.toString();
	}
	/**
	 * retorna el carret 
	 * @return Car
	 */
	public Car getCart() {
		return cart;
	}

	
}
