package ca.sheridan.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ca.sheridan.model.Customer;
import ca.sheridan.model.Receipt;
import ca.sheridan.model.ReportItem;

public class SummaryDataAccessImpl implements SummaryDataAccess{
	private DriverManagerDataSource ds = null;

	public SummaryDataAccessImpl() {

		ds = new DriverManagerDataSource();
	}

	public void insertSummary(Customer customer, Receipt receipt) {
		
		//create query and input into prepared statement
		String saveStm = "INSERT INTO summaryPizza (customer_name, customer_email, totalBeforeTax, totalAfterTax) VALUES (?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ds.getConnection();
			pstm = conn.prepareStatement(saveStm);
			pstm.setString(1, customer.getName());
			pstm.setString(2, customer.getEmail());
			pstm.setDouble(3, receipt.getPizzaPrice());
			pstm.setDouble(4, receipt.getPriceAfterTax());
			pstm.executeUpdate();
		} catch (SQLException e) {
			logSqlException(e, "Error trying to add a new summary record");
			throw new RuntimeException("Error trying to insert  a summary information to the summary table");
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				logSqlException(e, "Error Trying to close statemenst or connection");
				throw new RuntimeException(
						"Error trying to close a database resource after inserting the summary information");
			}
		}

	}
	@Override
	public ArrayList<ReportItem> getAllSummary() {
		String selectStm = "SELECT * FROM summaryPizza";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		ArrayList<ReportItem> summaryList = new ArrayList<>();
		

		try {
			conn = ds.getConnection();
			pstm = conn.prepareStatement(selectStm);
			res = pstm.executeQuery();
			while (res.next()) {
				ReportItem reportItem = new ReportItem(res.getString("customer_name"), res.getString("customer_email"),
						res.getDouble("totalBeforeTax"), res.getDouble("totalAfterTax"));
				summaryList.add(reportItem);
			}
			
		} catch (SQLException e) {
			logSqlException(e, "Error trying to retrieve summary records");
			throw new RuntimeException("Error retrieve summary information");
		} finally {
			try {
				if (res != null)
					pstm.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				logSqlException(e, "Error Trying to close statement or connection");
				throw new RuntimeException(
						"Error trying to close a database resource after retrieving the summary information");
			}
		}
		return summaryList;
	}

	
	private void logSqlException(SQLException e, String msg) {
		//logs the exceptions
		System.out.println("Error Message: " + e.getMessage() + " SQL State: " + e.getSQLState() + " ErrorCode: "
				+ e.getErrorCode());
		if (msg != null)
			System.out.println("Additional information: " + msg);

		e.printStackTrace();
	}


}
