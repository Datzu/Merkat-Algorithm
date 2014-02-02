package com.gmail.merkat;

public class Employee {
	
	private int asignedSellStation;
	private int id;
	private boolean active; // per saber si treballa o no

	public Employee(int id) {
		this.id = id;
	}

	public Employee(int id, int asignedSellStation, boolean active) {
		this.id = id;
		this.asignedSellStation = asignedSellStation;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAsignedSellStation() {
		return asignedSellStation;
	}

	public void setAsignedSellStation(int n) {
		this.asignedSellStation = n;
		this.active = true;
	}
	
	public void unasignSellStation() {
		this.asignedSellStation = Utils.nSellStations;
		this.active = false;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return String.valueOf(this.id);
	}
	
	

}
