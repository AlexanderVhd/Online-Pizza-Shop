package ca.sheridan.model;

import java.io.Serializable;

public class Receipt implements Serializable{

	private double priceAfterTax;
	private double pizzaPrice;
	
	public Receipt(double totalAfterTax, double pizzaPrice) {
		super();
		this.setPriceAfterTax(totalAfterTax);
		this.setPizzaPrice(pizzaPrice);
	}

	//getter and setter methods
	public double getPriceAfterTax() {
		return priceAfterTax;
	}

	public void setPriceAfterTax(double priceAfterTax) {
		this.priceAfterTax = priceAfterTax;
	}

	public double getPizzaPrice() {
		return pizzaPrice;
	}

	public void setPizzaPrice(double pizzaPrice) {
		this.pizzaPrice = pizzaPrice;
	}
}
