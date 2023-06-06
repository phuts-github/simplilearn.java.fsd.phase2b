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
import com.simplilearn.models.Bookings;

/**
 * Servlet implementation class FlyAwayAdminBookingsServlet
 */
@WebServlet("/FlyAwayAdminBookingsServlet")
public class FlyAwayAdminBookingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlyAwayAdminBookingsServlet() {
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
			Integer bookingUserId = Integer.valueOf (request.getParameter("bookingUserId"));
			Integer bookingFlightScheduleId = Integer.valueOf (request.getParameter("bookingFlightScheduleId"));
			String bookingFlightDate = request.getParameter("bookingFlightDate");
			String bookingPassengerOne = request.getParameter("bookingPassengerOne");
			String bookingPassengerTwo = request.getParameter("bookingPassengerTwo");
			String bookingPassengerThree = request.getParameter("bookingPassengerThree");			
			String bookingPassengerFour = request.getParameter("bookingPassengerFour");
			Integer bookingPassengerCount = Integer.valueOf (request.getParameter("bookingPassengerCount"));
			Integer bookingTransactionId = Integer.valueOf (request.getParameter ("bookingTransactionId"));

			// Check parameters are populated
			if (bookingFlightScheduleId == null || bookingFlightDate.isEmpty() || bookingPassengerOne.isEmpty() || bookingPassengerCount == null || bookingTransactionId == null) {
				request.getRequestDispatcher("adminBookings.jsp").include(request, response);
				out.print("<br><br> Error <br> Enter fields");
				out.print("<br> Try again if you like... <br>");
			} else {

				// Build entity
				Bookings bookings = new Bookings();
				bookings.setFlightDate(bookingFlightDate);
				bookings.setFlightScheduleId(bookingFlightScheduleId);
				bookings.setId(0);
				bookings.setPassengerCount(bookingPassengerCount);
				bookings.setPassengerFour(bookingPassengerFour);
				bookings.setPassengerOne(bookingPassengerOne);
				bookings.setPassengerThree(bookingPassengerThree);
				bookings.setPassengerTwo(bookingPassengerTwo);
				bookings.setTransactionId(bookingTransactionId);
				bookings.setUserId(bookingUserId);
				
				// Save entity	
				BookingsDao bookingsDao = new BookingsDao();
				bookingsDao.saveOrUpdateBooking(bookings);

				// Back to admin page
				request.getRequestDispatcher("adminBookings.jsp").include(request, response);
			}
		}
	}
}
