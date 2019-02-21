package ca.sheridan.model;

import java.io.Serializable;

public class Order implements Serializable{
	
	private String size;
	private String pizza;
	
	public Order(String size, String pizza){
		this.setSize(size);
		this.setPizza(pizza);
	}

	//getter and setter methods for parameters 
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPizza() {
		return pizza;
	}

	public void setPizza(String pizza) {
		this.pizza = pizza;
	}
	

}
