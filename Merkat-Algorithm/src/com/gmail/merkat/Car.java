package com.gmail.merkat;

import java.util.Random;
import java.util.Stack;

/**
 * Classe per represantar el carro de la compra
 * 
 * @author Adria i Gerard
 * @since 31-01-2014
 */
public class Car {

	private Stack<Integer> products; // Pila de productes

	public Car() {
		this.products = new Stack<Integer>();
		fillCar();
	}
	/**
	 * Metode per omplir el carret
	 * 
	 */
	public void fillCar() {
		for (int i = 0; i < new Random().nextInt(Utils.maxNProducts); i++) {
			products.add(i);
		}
	}

	/**
	 * Metode per tornar el següent producte
	 * 
	 * @return int
	 */
	public int nextProduct() {
		return products.pop();
	}
	/**
	 * Metode per tornar veure el numero de productes que te el client
	 * 
	 * @return int
	 */
	public int carSize() {
		return products.size();
	}

	@Override
	public String toString() {
		return products.toString();
	}

}
