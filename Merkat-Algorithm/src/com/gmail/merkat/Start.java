package com.gmail.merkat;

/**
 * Classe per executar el programa
 * 
 * @author Adria i Gerard
 * @since 31-01-2014
 */
public class Start {
	public static Merkat lidl; // creació d'un mercat

	/**
	 * Classe sincornitzada per que tots els fills s'entenguin
	 * 
	 * @param args
	 */
	public synchronized static void main(String[] args) {

		lidl = new Merkat();

		GenerateCustomer genCus = new GenerateCustomer();
		genCus.start();

		while (lidl.getTotalCustomers() > 0) {
			while (lidl.getCustomersInQueue() > 0) {
				lidl.assignCustomer();
			}
		}

	}

}
