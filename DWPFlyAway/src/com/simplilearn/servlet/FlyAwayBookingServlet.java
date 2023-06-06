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

import com.simplilearn.dao.FlightsScheduleDao;
import com.simplilearn.models.FlightsSchedule;
import com.simplilearn.modules.BuildPages;

/**
 * Servlet implementation class FlyAwayBookingServlet
 */
@WebServlet("/FlyAwayBookingServlet")
public class FlyAwayBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlyAwayBookingServlet() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		System.out.println();
		System.out.println("<br>FlyAwayBookingServlet 1");

		HttpSession session = request.getSession();

		System.out.println("session variables");		
		Enumeration<String> attributes = request.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
		    String attribute = (String) attributes.nextElement();
		    System.out.println(attribute+" : "+request.getSession().getAttribute(attribute));
		}
		
		// Get flight schedule code and save it in session

		System.out.println("request.getParameter(code) " + request.getParameter("code"));
		System.out.println("session.getAttribute(flightScheduleCode) " + session.getAttribute("flightScheduleCode"));
		
		String flightScheduleCode = request.getParameter("code");

		if (flightScheduleCode == null) {
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
		else {
			Integer flightScheduleId = Integer.parseUnsignedInt((String) flightScheduleCode);
			session.setAttribute("flightScheduleId", flightScheduleId);
	
			// Get user name
			
			int userId = 0;
			if (session.getAttribute("userId") == null) {
				userId = 0;
			}
			else {
				userId = (Integer) session.getAttribute("userId");
			}
			
			if (userId==0) {
				// Force login
				request.getRequestDispatcher("login.jsp").include(request, response);
			} else {
	
				// Save user name
				// Schedule code

				session.setAttribute("userType", "null");
		        
	        	FlightsScheduleDao flightScheduleDao = new FlightsScheduleDao();
	        	
	        	FlightsSchedule flightsSchedule;
	        	flightsSchedule = flightScheduleDao.readFlightsScheduleById(flightScheduleId);
	        	
	        	if (!flightsSchedule.equals(null)) {

					//dispatch - Bookings
			        request.getRequestDispatcher("booking.jsp").include(request, response);
			        
			        BuildPages.buildAndPrintChosenFlight( request,  response,  flightsSchedule );
			        
	        	}  
	        	else {
					//dispatch - Bookings
			        request.getRequestDispatcher("booking.jsp").include(request, response);
	        		out.print("<br><br>  No flight details found"); 
	        	}

			}	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
