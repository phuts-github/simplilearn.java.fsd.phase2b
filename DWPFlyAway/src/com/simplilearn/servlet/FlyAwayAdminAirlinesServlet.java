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

import com.simplilearn.dao.AirlinesDao;
import com.simplilearn.models.Airlines;

/**
 * Servlet implementation class FlyAwayAdminAirlinesServlet
 */
@WebServlet("/FlyAwayAdminAirlinesServlet")
public class FlyAwayAdminAirlinesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlyAwayAdminAirlinesServlet() {
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
			String airlineName = request.getParameter("airlineName");
			String airlineCity = request.getParameter("airlineCity");
			String airlineCountry = request.getParameter("airlineCountry");
			String airlineRoute = request.getParameter("airlineRoute");

			// Check parameters are populated
			if (airlineName.isEmpty() || airlineCity.isEmpty() || airlineCountry.isEmpty() || airlineRoute.isEmpty()) {
				request.getRequestDispatcher("adminAirlines.jsp").include(request, response);
				out.print("<br><br> Error <br> Enter fields");
				out.print("<br> Try again if you like... <br>");
			} else {

				// Build entity
				Airlines airlines = new Airlines();
				airlines.setCity(airlineCity);
				airlines.setCountry(airlineCountry);
				airlines.setId(0);
				airlines.setName(airlineName);
				airlines.setRoute(airlineRoute);
				
				// Save entity	
				AirlinesDao airlinesDao = new AirlinesDao();
				airlinesDao.saveOrUpdateAirlines(airlines);

				// Back to admin page
				request.getRequestDispatcher("adminAirlines.jsp").include(request, response);
			}
		}
	}
}
