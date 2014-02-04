package com.gmail.merkat;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Merkat {

	private List<SellStation> sellStationList;
	private List<Employee> employeeList;
	private Queue<Employee> employeeQueue;
	private int awaitingCustomers = 0;
	private int actualCustomerInQueue = 0;

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
	}
	
	public void assignCustomer()  {
		for (int i = awaitingCustomers; i > actualCustomerInQueue; i--) {
			for (SellStation s : sellStationList) {
				while (s.getCustomers().size() < 6) {
					if (!s.isAsignedEmployee()) {
						Employee tmpEmployee = employeeQueue.remove();
						employeeQueue.add(tmpEmployee);
						System.out.println("The selected employee is: " + tmpEmployee.toString());
						s.setActualEmployee(tmpEmployee);
					}
					s.addCustomer(new Customer(i));
				}
			}
		}
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
