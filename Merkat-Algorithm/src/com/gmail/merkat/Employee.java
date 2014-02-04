package com.gmail.merkat;

import java.util.Random;

public class Employee {
	
	private int asignedSellStation;
	private int id;
	private boolean active; // per saber si treballa o no
	private boolean canWork = true;
	private int speed;

	public Employee(int id) {
		this.id = id;
		this.active = false;
		this.speed = new Random().nextInt(Utils.maxTimeScan)+Utils.minTimeScan;
	}

	public Employee(int id, int asignedSellStation, boolean active) {
		this.id = id;
		this.asignedSellStation = asignedSellStation;
		this.active = active;
		this.speed = new Random().nextInt(Utils.maxTimeScan)+Utils.minTimeScan;
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

	public boolean canWork() {
		return canWork;
	}

	public void setCanWork(boolean canWork) {
		this.canWork = canWork;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return String.valueOf(this.id);
	}
	
	

}
