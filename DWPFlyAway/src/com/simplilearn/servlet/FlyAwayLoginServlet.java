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

import com.simplilearn.dao.UserDao;

/**
 * Servlet implementation class FlyAwayLoginServlet
 */
@WebServlet("/FlyAwayLoginServlet")
public class FlyAwayLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlyAwayLoginServlet() {
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
		
		String pEmail = request.getParameter("email");
		String pPass = request.getParameter("pass");

		session.setAttribute("email", null);
		session.setAttribute("pass", null);

		// check user parameters populated
		if (pEmail.isEmpty() || pPass.isEmpty()) {
			request.getRequestDispatcher("login.jsp").include(request, response);
			out.print("<br><br> Error <br> Enter all Login fields");
			out.print("<br> Try again if you like... <br>");
		} else {

			// Get user name
			UserDao usersDao = new UserDao();
			int userId = usersDao.readUserByEmailAndPass(pEmail, pPass);
    	   
    	    if (userId==0) {
    			request.getRequestDispatcher("login.jsp").include(request, response);
    			out.print("<br><br> Error <br> User not found");
    			out.print("<br> Try again if you like... <br>");
    	    } 
    	    else {
    	    	System.out.println("User found " + userId);
				// save validated user parameters
	    		session.setAttribute("userId", userId);
	    		
	    		if (session.getAttribute("code") == null) {
	    			request.getRequestDispatcher("home.jsp").include(request, response);
	    		}
	    		else {
				//dispatch - Bookings	   
	    		request.getRequestDispatcher("booking.jsp").include(request, response);
	    		}
    	    }
		}
	}
}
