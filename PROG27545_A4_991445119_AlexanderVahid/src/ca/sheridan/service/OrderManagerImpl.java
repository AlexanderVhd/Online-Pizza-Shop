package ca.sheridan.service;

import ca.sheridan.dataaccess.SummaryDataAccess;
import ca.sheridan.dataaccess.SummaryDataAccessImpl;
import ca.sheridan.model.Customer;
import ca.sheridan.model.Order;
import ca.sheridan.model.Receipt;

public class OrderManagerImpl implements OrderManager{
	
	private final double SMALL_CHEESE_PRICE = 10.0;
	private final double SMALL_PEP_PRICE = 15.0;
	private final double SMALL_VEG_PRICE = 12.0;
	private final double LARGE_CHEESE_PRICE = 20.0;
	private final double LARGE_PEP_PRICE = 30.0;
	private final double LARGE_VEG_PRICE = 24.0;

	private final double TAX_RATE = 0.13;
	
	private double calculatePizzaPrice(Order order){
		double pizzaPrice = 0;

		switch (order.getSize()) {
		case "SMALL":
			pizzaPrice = calculateSmallPrice(order);
			break;

		case "LARGE":
			pizzaPrice = calculateLargePrice(order);
			break;

		default:
			break;
		}
		
		return pizzaPrice;
		
	}


	private double calculateLargePrice(Order order) {
		double price = 0;
		
		switch (order.getPizza()){
		case "CHEESE":
			price = this.LARGE_CHEESE_PRICE;
			break;
		
		case "PEPERONI":
			price = this.LARGE_PEP_PRICE;
			break;
			
		case "VEG":
			price = this.LARGE_VEG_PRICE;
			break;
			
		default:
			break;
		}
		
		return price;
	}


	private double calculateSmallPrice(Order order) {
		double price = 0;
		
		switch (order.getPizza()){
		case "CHEESE":
			price = this.SMALL_CHEESE_PRICE;
			break;
		
		case "PEPORONI":
			price = this.SMALL_PEP_PRICE;
			break;
			
		case "VEG":
			price = this.SMALL_VEG_PRICE;
			break;
			
		default:
			break;
		}
		
		return price;
	}


	@Override
	public Receipt constructReceipt(Customer customer) {
		double pizzaPrice = this.calculatePizzaPrice(customer.getOrder());
		double totalAfterTax = pizzaPrice + pizzaPrice * this.TAX_RATE;

		Receipt receipt = new Receipt(totalAfterTax, pizzaPrice);

		return receipt;
	}
	
	public void saveOrder (Customer customer, Receipt receipt)	{
		
		SummaryDataAccess summaryDataAccess = new SummaryDataAccessImpl();
		summaryDataAccess.insertSummary(customer, receipt);
	}

}
