package com.gmail.merkat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Classe que representa un supermercat
 * 
 * @author Adria i Gerard
 * @since 31-01-2014
 */
public class Merkat {

	private List<SellStation> sellStationList; // LLista de caixes del supermercat
	private List<Employee> employeeList;  // LLista dels empleats del mercat
	private Queue<Employee> employeeQueue; // Cua dels empelats del mercat
	private int totalCustomers = Utils.maxNCustomers;  // Clients que poden entrar actualment al supermercat fins que tanquin
	public Queue<Customer> customerQueue; // Cua de clients esperant a ser assignats a una caixa

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
/**
 *  Retorna el total de clients
 * @return int
 */
	public int getTotalCustomers() {
		return this.totalCustomers;
	}
/**
 * Posa el primer treballador al final de la cua
 * Simulació del canvi de torn
 */
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
/**
 * Thread que va comprovant si un empleat ha superat el temps de feina del seu torn
 * @author Adria i Gerard
 * @since 31-01-2014
 *
 */
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
