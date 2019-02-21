package ca.sheridan.service;

import java.util.ArrayList;

import ca.sheridan.dataaccess.SummaryDataAccess;
import ca.sheridan.dataaccess.SummaryDataAccessImpl;
import ca.sheridan.model.ReportItem;

public class ReportManagerImpl implements ReportManager{

	@Override
	public ArrayList<ReportItem> getReport() {
		SummaryDataAccess dataAccess = new SummaryDataAccessImpl();
		return dataAccess.getAllSummary();
	}
	

}
