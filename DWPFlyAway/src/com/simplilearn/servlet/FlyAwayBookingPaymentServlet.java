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

import com.simplilearn.dao.BookingsDao;
import com.simplilearn.dao.FlightsScheduleDao;
import com.simplilearn.dao.TransactionsDao;
import com.simplilearn.models.Bookings;
import com.simplilearn.models.FlightsSchedule;
import com.simplilearn.models.Transactions;
import com.simplilearn.modules.BuildPages;

/**
 * Servlet implementation class FlyAwayBookingPaymentServlet
 */
@WebServlet("/FlyAwayBookingPaymentServlet")
public class FlyAwayBookingPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlyAwayBookingPaymentServlet() {
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
		//doGet(request, response);

	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        
		System.out.println("session variables");		
		Enumeration<String> attributes = request.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
		    String attribute = (String) attributes.nextElement();
		    System.out.println(attribute+" : "+request.getSession().getAttribute(attribute));
		}
        
		// Get user parameters
		Integer userId = (Integer) session.getAttribute("userId");
		Integer bookingId = (Integer) session.getAttribute ("bookingId");		
		
		int passengerCount = 0;
		
		String cardType = request.getParameter("cardType");
		String cardNo = request.getParameter("cardNo");
		String expireDate = request.getParameter("expireDate");
		String threeDigitNo = request.getParameter("threeDigitNo");
		
		// check user parameters populated
		BookingsDao bookingDao = new BookingsDao();
		Bookings bookings = null;		
		if (cardType.isEmpty() || cardNo.isEmpty() || expireDate.isEmpty() || threeDigitNo.isEmpty()) {			

			bookings = bookingDao.readBookingById(bookingId);
			passengerCount = bookings.getPassengerCount();
			
			//dispatch - build jsp with pay details 

			// get airline, price and seat details
        	FlightsScheduleDao flightScheduleDao = new FlightsScheduleDao();
        	FlightsSchedule flightsSchedule;
        	flightsSchedule = flightScheduleDao.readFlightsScheduleById(
        			bookings.getFlightScheduleId()
        		);
        	
        	FlightsSchedule flightsScheduleUpdate = null;
       		int unitPrice = flightsSchedule.getPrice();
       		int seatsAvailable = flightsSchedule.getSeatsAvailable();
       		flightsScheduleUpdate = flightsSchedule;
	
	        BuildPages.buildAndPrintChosenFlight( request,  response,  flightsSchedule );
        	BuildPages.buildAndPaymentDetails( request,  response,  bookings,  flightsScheduleUpdate, passengerCount );
			
			out.print("<br> Error <br> Enter all payment details");
			out.print("<br> Try again if you like... <br>");
		} else {
			
			// Get details from session
			Integer transBookingId = (Integer) session.getAttribute ("transBookingId");
			String transDate = session.getAttribute ("transDate").toString();	
			Integer transFlightAmount = (Integer) session.getAttribute ("transFlightAmount");	
			Integer transPassengerCount = (Integer) session.getAttribute ("transPassengerCount");	
			Integer transTotalDue = (Integer) session.getAttribute ("transTotalDue");	
			
			// Build entity
			Transactions transaction = new Transactions();
			transaction.setBookingId(transBookingId);
			transaction.setDate(transDate);
			transaction.setFlightAmount(transFlightAmount);
			transaction.setPassengerCount(transPassengerCount);
			transaction.setTotalDue(transTotalDue);
			transaction.setTotalPaid(transTotalDue);
			
			// Save new transaction with payment details
			TransactionsDao transactionsDao = new TransactionsDao();
			transactionsDao.saveOrUpdateTransactions(transaction);
			
			// Update bookings with transaction id
			bookings = bookingDao.readBookingById(bookingId);
			bookings.setTransactionId(transaction.getId());
			bookingDao.saveOrUpdateBooking(bookings);
			
			out.print("<br><h3>Ticket purchase transaction completed. Ticket details will follow after being reviewed.</h3>");
			out.print("<br><h3>You have been logged-off.</h3>");
			session.invalidate();
		}
	}

}
