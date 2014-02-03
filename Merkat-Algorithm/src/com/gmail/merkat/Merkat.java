package com.gmail.merkat;

import java.util.ArrayList;
import java.util.List;

public class Merkat {

	private List<SellStation> sellStationList;
	private List<Employee> employeeList;
	private int awaitingCustomers = 0;

	public Merkat() {
		sellStationList = new ArrayList<SellStation>();
		employeeList = new ArrayList<Employee>();
	}

	public Merkat(List<SellStation> sellStationList, List<Employee> employeeList) {
		this.sellStationList = sellStationList;
		this.employeeList = employeeList;
	}

	public void start() {
		for (int i = 0; i < Utils.nSellStations; i++) {
			sellStationList.add(new SellStation("Station " + i));
		}
		for (int i = 0; i < Utils.nEmployees; i++) {
			employeeList.add(new Employee(i));
		}
		GenerateCustomer genCus = new GenerateCustomer();
		genCus.start();
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
	
	public int getAwaitingCustomers() {
		return awaitingCustomers;
	}

	public void setAwaitingCustomers(int awaitingCustomers) {
		this.awaitingCustomers = awaitingCustomers;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < sellStationList.size(); i++) {
			s += (sellStationList.get(i).toString() + "\n");
		}
		return s;
	}

}
