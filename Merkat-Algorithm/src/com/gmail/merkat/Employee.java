package com.gmail.merkat;

public class Employee {

	private int id;
	
	public Employee() {
		
	}

	public Employee(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.valueOf(this.id);
	}

}
