package ca.sheridan.model;

import java.io.Serializable;

public class Customer implements Serializable{
	
	private String name;
	private String email;
	private Order order;
	
	public Customer(String name, String email){
		this.setName(name);
		this.setEmail(email);
	}
	
	/*
	 * getter and setter methods for parameters
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
