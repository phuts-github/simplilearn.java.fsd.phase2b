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
import com.simplilearn.models.Bookings;
import com.simplilearn.models.FlightsSchedule;
import com.simplilearn.modules.BuildPages;

/**
 * Servlet implementation class FlyAwayBookingConfirmServlet
 */
@WebServlet("/FlyAwayBookingConfirmServlet")
public class FlyAwayBookingConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlyAwayBookingConfirmServlet() {
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
		
		Integer flightScheduleId = (Integer) session.getAttribute("flightScheduleId");
		Integer transactionId = 0;
		String flightDate = (String) session.getAttribute("flightDate");		
		String passengerOne = request.getParameter("passengerOneName");
		String passengerTwo = request.getParameter("passengerTwoName");
		String passengerThree = request.getParameter("passengerThreeName");
		String passengerFour = request.getParameter("passengerFourName");
		
		// check user parameters populated
		if (passengerOne.isEmpty() && passengerTwo.isEmpty() && passengerThree.isEmpty() && passengerFour.isEmpty()) {
			//dispatch - Bookings
	        request.getRequestDispatcher("booking.jsp").include(request, response);
			out.print("<br><br> Error <br> Enter at lease one passenger name");
			out.print("<br> Try again if you like... <br>");
		} else {
			
			String arrPassengerNames [] = new String[4];
			int passengerCount = 0;
			if (!passengerOne.isEmpty()) {
				arrPassengerNames[passengerCount] = passengerOne;
				passengerCount++;
			}
			if (!passengerTwo.isEmpty()) {
				arrPassengerNames[passengerCount] = passengerTwo;
				passengerCount++;
			}
			if (!passengerThree.isEmpty()) {
				arrPassengerNames[passengerCount] = passengerThree;
				passengerCount++;
			}
			if (!passengerFour.isEmpty()) {
				arrPassengerNames[passengerCount] = passengerFour;
				passengerCount++;
			}
			
			Bookings bookings = new Bookings();
			bookings.setFlightDate(flightDate);
			bookings.setFlightScheduleId(flightScheduleId);
			bookings.setUserId(userId);
			bookings.setPassengerCount(passengerCount);
			bookings.setPassengerOne  (arrPassengerNames[0]);
			bookings.setPassengerTwo  (arrPassengerNames[1]);
			bookings.setPassengerThree(arrPassengerNames[2]);
			bookings.setPassengerFour (arrPassengerNames[3]);
			bookings.setTransactionId(transactionId);
			bookings.setFlightDate(flightDate);
			bookings.setId(0);
			
			System.out.println(bookings.toString());
			 
			System.out.println(" Passenger count " + passengerCount);
			
			BookingsDao bookingsDao = new BookingsDao();
			// Delete existing bookings for this user that are pending payment
			bookingsDao.deleteBookingsByScheduleIdAndTransactionIdAndUserId (
					flightScheduleId,
					transactionId,
					userId
					);
			
			// Save Booking

//			Save new booking with passenger names	
			bookingsDao.saveOrUpdateBooking(bookings);
			session.setAttribute("bookingId", bookings.getId());

			
			// set default values to over price tickets in case things go wrong.
			int unitPrice = 1000;
			int totalPrice = 4000;
			int seatsAvailable = 0;
        	
			// get airline, price and seat details
        	FlightsScheduleDao flightScheduleDao = new FlightsScheduleDao();
        	FlightsSchedule flightsSchedule;
        	flightsSchedule = flightScheduleDao.readFlightsScheduleById(
        			bookings.getFlightScheduleId()
        		);
        	
        	FlightsSchedule flightsScheduleUpdate = null;
       		unitPrice = flightsSchedule.getPrice();
       		seatsAvailable = flightsSchedule.getSeatsAvailable();
       		flightsScheduleUpdate = flightsSchedule;
        	
	        BuildPages.buildAndPrintChosenFlight( request,  response,  flightsSchedule );
        	BuildPages.buildAndPaymentDetails( request,  response,  bookings,  flightsScheduleUpdate, passengerCount );
		
		}
	}

}
