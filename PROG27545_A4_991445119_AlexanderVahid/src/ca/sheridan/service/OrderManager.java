package ca.sheridan.service;

import ca.sheridan.model.Customer;
import ca.sheridan.model.Receipt;

public interface OrderManager {
	public Receipt constructReceipt(Customer customer);
	public void saveOrder(Customer customer, Receipt receipt);
	
}
