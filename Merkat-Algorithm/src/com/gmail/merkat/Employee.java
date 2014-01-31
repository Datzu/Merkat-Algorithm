package com.gmail.merkat;

public class Employee {
	private int id;
	private boolean active; // per saber si treballa o no

	public Employee() {
	}

	public Employee(int id, boolean active) {
		this.id = id;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", active=" + active + "]";
	}
	
	

}
