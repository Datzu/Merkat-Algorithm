package com.gmail.merkat;

import java.util.List;

public class Merkat {
	private List<SellStation> sellStationList;
	private List<Employee> employeeList;

	public Merkat() {
	}

	public Merkat(List<SellStation> sellStationList, List<Employee> employeeList) {
		this.sellStationList = sellStationList;
		this.employeeList = employeeList;
	}
	

	public void start(){
		
	}

	public List<SellStation> getSellStationList() {
		return sellStationList;
	}

	public void setSellStationList(List<SellStation> sellStationList) {
		this.sellStationList = sellStationList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Merkat [sellStationList=" + sellStationList + ", employeeList="
				+ employeeList + "]";
	}
	

}
