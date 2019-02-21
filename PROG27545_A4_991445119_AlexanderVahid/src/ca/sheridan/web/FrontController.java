package ca.sheridan.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.sheridan.model.Customer;
import ca.sheridan.model.Order;
import ca.sheridan.model.Receipt;
import ca.sheridan.model.ReportItem;
import ca.sheridan.service.OrderManager;
import ca.sheridan.service.OrderManagerImpl;
import ca.sheridan.service.ReportManager;
import ca.sheridan.service.ReportManagerImpl;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String run = request.getParameter("run");

		switch (run) {
		case "START MY ORDER":
			startOrder(request, response);
			break;
		
		case "Place My Order":
			saveOrder(request, response);
			break;
			
		case "Report":
			reportOrder(request, response);
			break;

		default:
			break;
		}
	}

	private void startOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get parameters from home page and create customer object with them
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Customer cust = new Customer(name, email);
		
		//create new Http session and set the customer attribute
		HttpSession session = request.getSession();
		session.setAttribute("customer", cust);
		
		//set attribute customer in request dispatcher and forward it to cutomerInfo.jsp
		RequestDispatcher rd = request.getRequestDispatcher("customerInfo.jsp");
		request.setAttribute("customer", cust);
		rd.forward(request, response);
		
	}
	
	private void saveOrder(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		//get parameters from customerInfo page and create new order object with them
		String size = request.getParameter("size");
		String pizza = request.getParameter("pizzatype");
		Order orderItem = new Order(size, pizza);

		//retrieve the customer and set its order by creating new Http session
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		customer.setOrder(orderItem);

		//create order manager object and use it to construct receipt then pass it to the receipt object
		OrderManager orderManager = new OrderManagerImpl();
		Receipt receipt = orderManager.constructReceipt(customer);

		//save the order
		orderManager.saveOrder(customer, receipt);

		RequestDispatcher rd = request.getRequestDispatcher("receipt.jsp");
		request.setAttribute("customer", customer);
		request.setAttribute("receipt", receipt);
		rd.forward(request, response);
	}
	
	private void reportOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ReportManager reportManager = new ReportManagerImpl();
		ArrayList<ReportItem> report = reportManager.getReport();
		RequestDispatcher rd = request.getRequestDispatcher("report.jsp");
		request.setAttribute("report", report);
		rd.forward(request, response);
		
	}

}
