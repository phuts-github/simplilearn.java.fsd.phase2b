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


/**
 * Servlet implementation class FlyAwayAdminFlightsSchedulesServlet
 */
@WebServlet("/FlyAwayAdminFlightsSchedulesServlet")
public class FlyAwayAdminFlightsSchedulesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlyAwayAdminFlightsSchedulesServlet() {
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
			String flightSource = request.getParameter("flightSource");
			String flightDestination = request.getParameter("flightDestination");
			String flightDate = request.getParameter("flightDate");
			String flightAirline = request.getParameter("flightAirline");			
			Integer flightPrice = Integer.valueOf (request.getParameter("flightPrice"));
			Integer flightSeatsTotal = Integer.valueOf (request.getParameter ("flightSeatsTotal"));
			Integer flightSeatsBooked = Integer.valueOf (request.getParameter ("flightSeatsBooked"));
			Integer flightSeatsAvailable = Integer.valueOf (request.getParameter ("flightSeatsAvailable"));

			// Check parameters are populated
			if (flightSource.isEmpty() || flightDestination.isEmpty() || flightDate.isEmpty() || flightAirline.isEmpty()
				|| flightPrice == null || flightSeatsTotal == null || flightSeatsBooked == null || flightSeatsAvailable == null 	) {
				request.getRequestDispatcher("adminFlightsSchedules.jsp").include(request, response);
				out.print("<br><br> Error <br> Enter fields");
				out.print("<br> Try again if you like... <br>");
			} else {

				// Build entity
				FlightsSchedule flightsSchedule = new FlightsSchedule();
				flightsSchedule.setAirline(flightAirline);
				flightsSchedule.setDate(flightDate);
				flightsSchedule.setDestination(flightDestination);
				flightsSchedule.setId(0);
				flightsSchedule.setPrice(flightPrice);
				flightsSchedule.setSeatsAvailable(flightSeatsAvailable);
				flightsSchedule.setSeatsBooked(flightSeatsBooked);
				flightsSchedule.setSeatsTotal(flightSeatsTotal);
				flightsSchedule.setSource(flightSource);
				
				// Save entity	
				FlightsScheduleDao flightsSchedulesDao = new FlightsScheduleDao();
				flightsSchedulesDao.saveOrUpdateFlightsSchedule(flightsSchedule);

				// Back to admin page
				request.getRequestDispatcher("adminFlightsSchedules.jsp").include(request, response);
			}
		}
	}
}
