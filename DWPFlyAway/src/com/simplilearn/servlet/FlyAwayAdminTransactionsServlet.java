package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.dao.TransactionsDao;
import com.simplilearn.models.Transactions;

/**
 * Servlet implementation class FlyAwayAdminTransactionsServlet
 */
@WebServlet("/FlyAwayAdminTransactionsServlet")
public class FlyAwayAdminTransactionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlyAwayAdminTransactionsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		Enumeration<String> attributes = request.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
			String attribute = (String) attributes.nextElement();
			System.out.println(attribute + " : " + request.getSession().getAttribute(attribute));
		}

		Integer userId = (Integer) session.getAttribute("userId");
		String userType = (String) session.getAttribute("userType");

		if (userId == null || userType == null || !(userType.equals("admin"))) {
			request.getRequestDispatcher("loginadmin.jsp").include(request, response);
			out.print("<br><br> Error <br> Enter all Login fields");
			out.print("<br> Try again if you like... <br>");
		} else {

			// Get input parameters parameters
			Integer transBookingId = Integer.valueOf (request.getParameter ("transBookingId"));
			Integer transFlightAmount = Integer.valueOf (request.getParameter ("transFlightAmount"));
			Integer transPassengerCount = Integer.valueOf (request.getParameter ("transPassengerCount"));
			Integer transTotalDue = Integer.valueOf (request.getParameter ("transTotalDue"));
			Integer transTotalPaid = Integer.valueOf (request.getParameter ("transTotalPaid"));
			String transDate = request.getParameter("transDate");

			// Check parameters are populated
			if (transBookingId == null || transFlightAmount == null || transPassengerCount == null ||
					transTotalDue == null || transTotalPaid == null || transDate.isEmpty()) {
				request.getRequestDispatcher("adminTransactions.jsp").include(request, response);
				out.print("<br><br> Error <br> Enter fields");
				out.print("<br> Try again if you like... <br>");
			} else {

				// Build entity
				Transactions transactions = new Transactions();
				transactions.setBookingId(transBookingId);
				transactions.setDate(transDate);
				transactions.setFlightAmount(transFlightAmount);
				transactions.setId(0);
				transactions.setPassengerCount(transPassengerCount);
				transactions.setTotalDue(transTotalDue);
				transactions.setTotalPaid(transTotalPaid);
				
				// Save entity	
				TransactionsDao transactionsDao = new TransactionsDao();
				transactionsDao.saveOrUpdateTransactions(transactions);

				// Back to admin page
				request.getRequestDispatcher("adminTransactions.jsp").include(request, response);
			}
		}
	}
}
