 package ca.sheridan.model;

import java.io.Serializable;

public class ReportItem implements Serializable{
	private String customerName;
	private String customerEmail;
	private double totalBeforeTax;
	private double totalAfterTax;
	
	public ReportItem() {
	}

	public ReportItem(String customerName, String customerEmail, double totalBeforeTax, double totalAfterTax) {
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.totalBeforeTax = totalBeforeTax;
		this.totalAfterTax = totalAfterTax;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public double getTotalBeforeTax() {
		return totalBeforeTax;
	}

	public void setTotalBeforeTax(double totalBeforeTax) {
		this.totalBeforeTax = totalBeforeTax;
	}

	public double getTotalAfterTax() {
		return totalAfterTax;
	}

	public void setTotalAfterTax(double totalAfterTax) {
		this.totalAfterTax = totalAfterTax;
	}

}
