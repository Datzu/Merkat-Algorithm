package com.gmail.merkat;

import java.util.Queue;

public class SellStation {
	
	private String stationName;
	private Queue<Customer> customers;
	private Employee actualEmployee;
	private boolean asignedEmployee;

	public SellStation(String s) {
		this.stationName = s;
		this.asignedEmployee = false;
	}

	public SellStation(String s, Queue<Customer> customers, Employee actualEmployee) {
		this.stationName = s;
		this.customers = customers;
		this.actualEmployee = actualEmployee;
		this.asignedEmployee = true;
	}
	
	public String getStationName() {
		return stationName;
	}
	
	public void setStationName(String name) {
		this.stationName = name;
	}

	public Queue<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Queue<Customer> customers) {
		this.customers = customers;
	}

	public Employee getActualEmployee() {
		return actualEmployee;
	}
	
	public void unasignEmployee() {
		this.actualEmployee = null;
		this.asignedEmployee = false;
	}

	public void setActualEmployee(Employee actualEmployee) {
		this.actualEmployee = actualEmployee;
		this.asignedEmployee = true;
	}

	@Override
	public String toString() {
		String s = "";
		s += ("- " + this.stationName + "\n");
		if (asignedEmployee) {
			s += ("\tActual employee: " + actualEmployee.toString());
		} else {
			s += ("\tNo employee asigned.");
		}
		s += "\n";
		if (customers != null) {
			s += customers.toString();
		} else {
			s += ("\tNo customers in queue.");
		}
		
		return s;
	}

}
