package com.gmail.merkat;

import java.util.Random;
/**
 * Classe per representar un empleat
 * 
 * @author Adria i Gerard
 * @since 31-01-2014
 */
public class Employee {

	private int id; // id de l'empleat
	private int time;  // temps que tarda en escanejar un prodcute
	private int timeWork = 0;  //temps q porta actualment treballant

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
	/**
	 * Incrementa 1 el temps que porta treballant
	 */
	public void incrementTimeWork() {
		this.timeWork++;
	}
/**
 *  Comprova si el temps actual de feina és superior al definit pel sistema (el fuckin boss)
 * @return boolean
 */
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
