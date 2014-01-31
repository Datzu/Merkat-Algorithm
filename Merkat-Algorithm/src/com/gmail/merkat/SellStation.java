package com.gmail.merkat;

import java.util.Queue;

public class SellStation extends Thread{
	private Queue<Customer> customers;
	private Employee actualEmployee;

	public SellStation() {
	}

	public SellStation(Queue<Customer> customers, Employee actualEmployee) {
		this.customers = customers;
		this.actualEmployee = actualEmployee;
	}

	@Override
	public void run() {
		super.run();
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

	public void setActualEmployee(Employee actualEmployee) {
		this.actualEmployee = actualEmployee;
	}

	@Override
	public String toString() {
		return "SellStation [customers=" + customers + ", actualEmployee="
				+ actualEmployee + "]";
	}

}
