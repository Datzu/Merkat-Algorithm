package com.gmail.merkat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Merkat {

	private List<SellStation> sellStationList;
	private List<Employee> employeeList;
	private Queue<Employee> employeeQueue;
	private Queue<Customer> customerQueue;
	private int awaitingCustomers = 0;
	private int actualCustomerInQueue = 0;
	private int totalGenCustomers = Utils.maxNCustomers;

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
		this.employeeQueue = new LinkedList<Employee>();
		this.customerQueue = new LinkedList<Customer>();
	}

	public void genCustomers() {
		int n = new Random().nextInt(Utils.maxGenCustomers) + 1;
		if (n + Start.lidl.getAwaitingCustomers() < Utils.maxNCustomers) {
			Start.lidl.setAwaitingCustomers(Start.lidl.getAwaitingCustomers()
					+ n);
			System.out.println(n + " new customers is waiting.");
		}
	}

	public void start() {
		do {
			genCustomers();
			if (canAssign()) {
				assignCustomer();
				System.out.println(toString());
				break;
			}
			System.out.println(toString());
		} while (totalGenCustomers > 0);
	}

	public void assignCustomer() {
		for (SellStation s : sellStationList) {
			while (s.getCustomers().size() < 5) {
				if (!s.isAsignedEmployee()) {
					Employee tmpEmployee = employeeQueue.remove();
					employeeQueue.add(tmpEmployee);
					s.setActualEmployee(tmpEmployee);
				}
				s.addCustomer(new Customer(awaitingCustomers));
				awaitingCustomers--;
				totalGenCustomers--;
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

	public boolean canAssign() {
		return awaitingCustomers > 0 ? true : false;
	}

	@Override
	public String toString() {
		String s = "";
		for (SellStation sell : sellStationList) {
			s += sell.toString() + "\n";
		}
		return s;
	}

}
