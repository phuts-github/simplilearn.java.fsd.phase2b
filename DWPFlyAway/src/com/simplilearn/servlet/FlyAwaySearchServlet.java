package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.dao.FlightsScheduleDao;
import com.simplilearn.models.FlightsSchedule;


/**
 * Servlet implementation class FlyAwaySearchServlet
 */
@WebServlet("/FlyAwaySearchServlet")
public class FlyAwaySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlyAwaySearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        HttpSession session = request.getSession();
   
		System.out.println("session variables");		
		Enumeration<String> attributes = request.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
		    String attribute = (String) attributes.nextElement();
		    System.out.println(attribute+" : "+request.getSession().getAttribute(attribute));
		}
        
        String flyFrom = request.getParameter("flyFrom");
        String flyTo = request.getParameter("flyTo");
        String flyWhen = request.getParameter("flyWhen");
        
        if (flyFrom.equals(null) || flyFrom.isEmpty() ||
        		flyTo.equals(null) || flyTo.isEmpty()) {
        	request.getRequestDispatcher("home.jsp").include(request, response);
        	out.print("<br><br> Error <br> Flight Source and Destination required");
        	out.print("<br> Try again if you like... <br>");
        }
        else if (flyFrom.contentEquals(flyTo)) {
        	request.getRequestDispatcher("home.jsp").include(request, response);
        	out.print("<br><br> Error <br> Flight Source and Destination must be different");
        	out.print("<br> Try again if you like... <br>");
        }
        else {
        	
        	FlightsScheduleDao flightScheduleDao = new FlightsScheduleDao();
        	
        	List<FlightsSchedule> flightsSchedule;
        	flightsSchedule = flightScheduleDao.searchFlightsSchedule(flyFrom,flyTo);
        	
        	if (flightsSchedule.size() > 0) {
        		
        		request.getRequestDispatcher("home.jsp").include(request, response);
        		
        		out.print("<form>"); 
	    		out.print("<h3>Review schedule and click on the Book link to select flight</h3>");
	    		out.print("<table>");
	    		out.print("<th>Action</th>");
	    		out.print("<th>Source</th>");
	    		out.print("<th>Destination</th>");
	    		out.print("<th>Date</th>");
	    		out.print("<th>Airline</th>");
	    		out.print("<th>Price</th>");
	    		out.print("<th>SeatsAvailable</th>");
	    		
	    		for(int i=0;i<flightsSchedule.size();i++) {
	    			//Search returned schedule. Build response with link to Bookings
	    			out.print("<tr>");
	        		out.print("<td><a href='/FlyAway/flyawaybookingservlet?code=" + flightsSchedule.get(i).getId()+"'>Book this one </a></td>");	        		
	        		out.print("<td>" + flightsSchedule.get(i).getSource() + "</td>");
	        		out.print("<td>" + flightsSchedule.get(i).getDestination() + "</td>");
	        		out.print("<td>" + flightsSchedule.get(i).getDate() + "</td>");
	        		out.print("<td>" + flightsSchedule.get(i).getAirline() + "</td>");
	        		out.print("<td>" + flightsSchedule.get(i).getPrice() + "</td>");
					out.print("<td>" + flightsSchedule.get(i).getSeatsAvailable() + "</td>");
					out.print("</tr>");
					
	        	}
	    		out.print("</table>");
	    	    out.print("</form>");
        	}
        	else {
            	request.getRequestDispatcher("home.jsp").include(request, response);
            	out.print("<br>");
            	out.print("<br> No flight schedule found");
            	out.print("<br> Try again if you like... <br>");
        	}
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
