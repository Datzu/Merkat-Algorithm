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
		for (SellStation s : sellStationList) {
			try {
				System.out.println(s.getStationName() + " started.");
				s.start();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(s.getStationName() + " error executing.");
			}
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
		int n = customerQueue.size();
		for (int i = 0; i < n; i++) {
			for (SellStation s : sellStationList) {
				if (s.isAsignedEmployee()) {
					new EmployeeHandler().start();
					if (s.getActualEmployee().haveToChange()) {
						System.out
								.println("L'empleat "
										+ s.getActualEmployee()
										+ " ha superat el temps de feina i va a descansar");
						changeEmployee();
						s.setActualEmployee(employeeQueue.peek());
						System.out.println("L'empelat " + s.getActualEmployee()
								+ " entra a subsituir l'anterior. ");

					}
				}
				if (s.getCustomers().size() < 5) {
					if (!s.isAsignedEmployee()) {
						Employee tmpEmployee = employeeQueue.remove();
						employeeQueue.add(tmpEmployee);
						s.setActualEmployee(tmpEmployee);
					}
					while (s.getCustomers().size() < 5) {
						if (customerQueue.size() > 0) {
							Customer c = customerQueue.poll();
							s.addCustomer(c);
							totalCustomers--;
							System.out.println("Adding to "
									+ s.getStationName() + " client: "
									+ c.getId());
						} else {
							break;
						}
					}
				}
			}
		}
	}

	public synchronized int getCustomersInQueue() {
		return this.customerQueue.size();
	}

	public int getTotalCustomers() {
		return this.totalCustomers;
	}

	public void changeEmployee() {
		employeeQueue.add(employeeQueue.poll());
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < sellStationList.size(); i++) {
			s += (sellStationList.get(i).toString() + "\n");
		}
		return s;
	}

	//
	// public void show() {
	// for (int i = 0; i < sellStationList.size(); i++) {
	// System.out.println(sellStationList.get(i).toString() + "\n");
	// }
	// }

	public class EmployeeHandler extends Thread {
		@Override
		public void run() {
			super.run();
			do {
				for (SellStation s : sellStationList) {
					s.getActualEmployee().incrementTimeWork();
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} while (true);

		}

	}

}
