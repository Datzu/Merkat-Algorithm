package com.gmail.merkat;

import java.util.LinkedList;
import java.util.Queue;

public class SellStation extends Thread {

	private String stationName;
	private Queue<Customer> customers;
	private Employee actualEmployee;
	private boolean asignedEmployee;

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

	@Override
	public void run() {
		super.run();
		try {
			do {
				int actualCustomers = this.customers.size();
				System.out.println(this.stationName + " " + actualCustomers);
				// agafar client i anar treient els productes del carro a la velocitat de l'empleat
				// quan productes = 0 , s'elimina el client
				if(this.customers.size() > 0){
					System.out.println(this.stationName + " : Tinc " + actualCustomers + " customers ");
				}else{
					System.out.println(this.stationName + " : NO Tinc customers ");
				}
				Thread.sleep(1000);
			} while (true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

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
