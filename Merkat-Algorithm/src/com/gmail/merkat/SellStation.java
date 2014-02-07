package com.gmail.merkat;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Classe que representa una caixa del supermercat
 * 
 * @author Adria i Gerard
 * @since 31-01-2014
 */
public class SellStation extends Thread {

	private String stationName; // nom de la caixa
	private Queue<Customer> customers; // cua de clients de la caixa
	private Employee actualEmployee; // empelat que està actualment assignat a
										// la caixa treballant
	private boolean asignedEmployee; // si està assignat (o no) un empelat a una
										// caixa
	private boolean changeEmployee = false; // Comprovar si s'ha de canviar
											// l'empelat o no

	public SellStation(String s) {
		this.stationName = s;
		this.asignedEmployee = false;
		this.customers = new LinkedList<Customer>();
	}

	public SellStation(String s, Queue<Customer> customers,
			Employee actualEmployee) {
		this.stationName = s;
		this.customers = customers;
		this.actualEmployee = actualEmployee;
		this.asignedEmployee = false;
		this.customers = new LinkedList<Customer>();
	}

	/**
	 * Mètode per començar el thread
	 */
	@Override
	public void run() {
		super.run();
		try {
			do {
				if (this.customers.size() > 0) {
					Customer c = customers.peek();
					while (c.getCart().carSize() > 0) {
						System.out.println("De la caixa " + this.stationName
								+ " el client " + c.getId() + " el producte "
								+ c.getCart().nextProduct()
								+ " ha estat escanejat. ");

						Thread.sleep(actualEmployee.getTime());
					}
					System.out.println("Següent client si us plau... ");
					customers.poll();
				}
				Thread.sleep(1000);
			} while (true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Afegir un nou client a una caixa
	 * 
	 * @param c variable que representa un nou client
	 */
	public void addCustomer(Customer c) {
		customers.add(c);
	}

	public String getStationName() {
		return this.stationName;
	}

	public Queue<Customer> getCustomers() {
		return customers;
	}

	public void setActualEmployee(Employee actualEmployee) {
		this.actualEmployee = actualEmployee;
		this.asignedEmployee = true;
	}

	public boolean isAsignedEmployee() {
		return asignedEmployee;
	}

	public void setAsignedEmployee(boolean asignedEmployee) {
		this.asignedEmployee = asignedEmployee;
	}

	public Employee getActualEmployee() {
		return actualEmployee;
	}

	public void setChangeEmployee(boolean changeEmployee) {
		this.changeEmployee = changeEmployee;
	}

	@Override
	public String toString() {
		String s = "";
		s += ("\n - " + this.stationName + "\n");
		if (asignedEmployee) {
			s += ("\tActual employee: " + actualEmployee.toString());
		} else {
			s += ("\tNo employee asigned.");
		}
		if (customers.size() == 0) {
			s += ("\n\tNo customers in queue.");
		} else {
			for (int i = 0; i < customers.size(); i++) {
				s += (s + customers.element().toString());
			}
		}
		return s;
	}

}
