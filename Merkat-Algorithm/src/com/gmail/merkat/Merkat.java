package com.gmail.merkat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Merkat {

	private List<SellStation> sellStationList;
	private List<Employee> employeeList;
	private Queue<Employee> employeeQueue;
	private int totalCustomers = Utils.maxNCustomers;
	
	public Queue<Customer> customerQueue;

	public Merkat() {
		this.sellStationList = new ArrayList<SellStation>();
		this.employeeList = new ArrayList<Employee>();
		this.employeeQueue = new LinkedList<Employee>();
		this.customerQueue = new LinkedList<Customer>();
		for (int i = 0; i < Utils.nSellStations; i++) {
			sellStationList.add(new SellStation("Station " + i));
		}
		for (int i = 0; i < Utils.nEmployees; i++) {
			employeeList.add(new Employee(i));
		}
		for (Employee e : employeeList) {
			employeeQueue.add(e);
		}
	}

	public Merkat(List<SellStation> sellStationList, List<Employee> employeeList) {
		this.sellStationList = sellStationList;
		this.employeeList = employeeList;
		for (Employee e : employeeList) {
			employeeQueue.add(e);
		}
		this.customerQueue = new LinkedList<Customer>();
	}

	public void assignCustomer() {
		for (SellStation s : sellStationList) {
			if (s.getCustomers().size() < 6) {
				if (!s.isAsignedEmployee()) {
					Employee tmpEmployee = employeeQueue.remove();
					employeeQueue.add(tmpEmployee);
					s.setActualEmployee(tmpEmployee);
				}
				while (s.getCustomers().size() < 6) {
					if (customerQueue.size() > 0) {
						s.addCustomer(customerQueue.remove());
						totalCustomers--;
					} else {
						break;
					}
				}
			}
		}
	}
	
	public int getCustomersInQueue() {
		return this.customerQueue.size();
	}
	
	public int getTotalCustomers() {
		return this.totalCustomers;
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
