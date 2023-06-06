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
import com.simplilearn.models.Users;

/**
 * Servlet implementation class FlyAwayAdminUsersServlet
 */
@WebServlet("/FlyAwayAdminUsersServlet")
public class FlyAwayAdminUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlyAwayAdminUsersServlet() {
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
			String userEmail = request.getParameter("userEmail");
			String userName = request.getParameter("userName");
			String userContact = request.getParameter("userContact");
			String userPass = request.getParameter("userPass");
			String userTypeAdmin = request.getParameter("userTypeAdmin");

			// Check parameters are populated
			if (userEmail.isEmpty() && userName.isEmpty() && userContact.isEmpty() && 
					userPass.isEmpty() || userTypeAdmin.isEmpty()) {
				request.getRequestDispatcher("adminUsers.jsp").include(request, response);
				out.print("<br><br> Error <br> Enter fields");
				out.print("<br> Try again if you like... <br>");
			} else {

				// Build entity
				Users user = new Users();
				user.setContact(userContact);
				user.setEmail(userEmail);
				user.setId(0);
				user.setName(userName);
				user.setPass(userPass);
				user.setType(userTypeAdmin);

				// Save entity	
				UserDao userDao = new UserDao();
				userDao.saveOrUpdateUsers(user);

				// Back to admin page
				request.getRequestDispatcher("adminUsers.jsp").include(request, response);
			}
		}
	}
}
