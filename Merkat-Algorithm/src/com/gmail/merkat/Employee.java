package com.gmail.merkat;

import java.util.Random;

public class Employee {

	private int id;
	private int time;
	private int timeWork = 0;

	public Employee() {

	}

	public Employee(int id) {
		this.id = id;
		this.time = new Random().nextInt(Utils.maxTimeScan) + 5;
	}

	public int getTime() {
		return this.time;
	}

	public int getTimeWork() {
		return this.timeWork;
	}

	public void incrementTimeWork() {
		this.timeWork++;
	}

	public boolean haveToChange() {
		if (this.timeWork > Utils.maxEmployeeTimeWork) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", time=" + time + "]";
	}
}
