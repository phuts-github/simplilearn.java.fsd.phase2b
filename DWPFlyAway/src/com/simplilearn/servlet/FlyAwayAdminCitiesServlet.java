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

import com.simplilearn.dao.CitiesDao;
import com.simplilearn.models.Cities;

/**
 * Servlet implementation class FlyAwayAdminCitiesServlet
 */
@WebServlet("/FlyAwayAdminCitiesServlet")
public class FlyAwayAdminCitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlyAwayAdminCitiesServlet() {
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
			String cityName = request.getParameter("cityName");
			String cityCountry = request.getParameter("cityCountry");
			String cityContinent = request.getParameter("cityContinent");

			// Check parameters are populated
			if (cityName.isEmpty() && cityCountry.isEmpty() && cityContinent.isEmpty()) {
				request.getRequestDispatcher("adminCities.jsp").include(request, response);
				out.print("<br><br> Error <br> Enter fields");
				out.print("<br> Try again if you like... <br>");
			} else {

				// Build entity
				Cities cities = new Cities();
				cities.setContinent(cityContinent);
				cities.setCountry(cityCountry);
				cities.setId(0);
				cities.setName(cityName);
				
				// Save entity	
				CitiesDao citiessDao = new CitiesDao();
				citiessDao.saveOrUpdateCities(cities);

				// Back to admin page
				request.getRequestDispatcher("adminCities.jsp").include(request, response);
			}
		}
	}
}
