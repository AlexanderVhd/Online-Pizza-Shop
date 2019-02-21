package ca.sheridan.dataaccess;

import java.util.ArrayList;

import ca.sheridan.model.Customer;
import ca.sheridan.model.Receipt;
import ca.sheridan.model.ReportItem;

public interface SummaryDataAccess {
	public void insertSummary(Customer customer, Receipt totalAftertax);
	public ArrayList<ReportItem> getAllSummary();

}
