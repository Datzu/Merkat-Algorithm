package com.gmail.merkat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Merkat {

	private List<SellStation> sellStationList;
	private List<Employee> employeeList;
	private Queue<Employee> employeeQueue;
	private Queue<Customer> customerQueue;
	private int awaitingCustomers = 0;
	private int actualCustomerInQueue = 0;
	private int totalCustomer;
	private boolean canAssign = false;

	public Merkat() {
		this.sellStationList = new ArrayList<SellStation>();
		this.employeeList = new ArrayList<Employee>();
		this.employeeQueue = new LinkedList<Employee>();
		this.customerQueue = new LinkedList<Customer>();
	}



	public Merkat(List<SellStation> sellStationList, List<Employee> employeeList) {
		this.sellStationList = sellStationList;
		this.employeeList = employeeList;
		this.employeeQueue = new LinkedList<Employee>();
		this.customerQueue = new LinkedList<Customer>();
	}

	public void start() {
		for (int i = 0; i < Utils.nSellStations; i++) {	
			sellStationList.add(new SellStation("Station " + i));
		}
		for (int i = 0; i < Utils.nEmployees; i++) {
			employeeList.add(new Employee(i));
		}
		for (Employee e: employeeList) {
			employeeQueue.add(e);
		}
	}

	public void assignCustomer() {		
	int n = awaitingCustomers;
		for (int i = n; i > 0; i--) {
			for (SellStation s : sellStationList) {
				System.out.println(i + " " + s.getStationName());
				if (Start.lidl.getAwaitingCustomers() > 0) {					
					if (!s.isAsignedEmployee()) {
						Employee tmpEmployee = employeeQueue.remove();
						employeeQueue.add(tmpEmployee);
						s.setActualEmployee(tmpEmployee);
					}
					if (s.getCustomers().size() < 6) {
						s.addCustomer(new Customer(i));
						awaitingCustomers--;
						break;
					}
					
				}else{
					break;
				}
			}
		}
		updateTotalCustomer();
//		System.exit(0);
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

	public void updateTotalCustomer() {
		this.totalCustomer = this.awaitingCustomers
				+ this.actualCustomerInQueue;
	}
	public boolean canAssign() {
		return canAssign;
	}

	public void setCanAssign(boolean canAssign) {
		this.canAssign = canAssign;
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
