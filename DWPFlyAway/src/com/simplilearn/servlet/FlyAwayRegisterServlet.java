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
 * Servlet implementation class FlyAwayRegisterServlet
 */
@WebServlet("/FlyAwayRegisterServlet")
public class FlyAwayRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlyAwayRegisterServlet() {
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
			System.out.println(attribute + " : " + request.getSession().getAttribute(attribute));
		}

		// Get user parameters
		String pEmail = request.getParameter("email");
		String pName = request.getParameter("name");
		String pContact = request.getParameter("contact");
		String pPass = request.getParameter("pass");
		int pId = 0;
		String pType = "";
		String pCode = request.getParameter("code");

		// check user parameters populated
		if (pEmail.isEmpty() || pName.isEmpty() || pContact.isEmpty() || pPass.isEmpty()) {
			request.getRequestDispatcher("register.jsp").include(request, response);
			out.print("<br><br> Error <br> Enter all Register fields");
			out.print("<br> Try again if you like... <br>");
		} else {

			// Get user name
			UserDao usersDao = new UserDao();
			Integer userId = usersDao.readUserByEmail(pEmail);

			if (!userId.equals(0)) {
				request.getRequestDispatcher("register.jsp").include(request, response);
				out.print("<br><br> Error <br> Email already exist");
				out.print("<br> Try again if you like... <br>");
			} else {

				int intRegisterResults = usersDao.registerUser(pId, pEmail, pName, pContact, pType, pPass);
				if (intRegisterResults == 1) {

					userId = usersDao.readUserByEmail(pEmail);
					session.setAttribute("userId", userId);

					if (pCode == null || pCode.isEmpty()) {
						request.getRequestDispatcher("home.jsp").include(request, response);
					} else {
						session.setAttribute("code", pCode);
						
						System.out.println("Registered, ready for bookings");
						// dispatch - Bookings
						request.getRequestDispatcher("booking.jsp").include(request, response);
					}
				} else {
					System.out.println("not registered - intRegisterResults " + intRegisterResults);
					// dispatch register
					request.getRequestDispatcher("register.jsp").include(request, response);
					out.print("<br><br> Error <br> Problems registering");
					out.print("<br> Try again if you like... <br>");

				}
			}
		}
	}

}
