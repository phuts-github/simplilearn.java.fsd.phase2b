package com.simplilearn.modules;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.models.Bookings;
import com.simplilearn.models.FlightsSchedule;

public class BuildPages {

	
	public static void buildAndPrintChosenFlight (HttpServletRequest request, HttpServletResponse response, 
			FlightsSchedule flightsSchedule) throws IOException {
		
		PrintWriter out = response.getWriter();
		
        out.print("<br>");
        out.print("<br><h3>Your chosen flight details :</h3>");
        out.print("Flight date " + flightsSchedule.getDate() +
        	", From " + flightsSchedule.getSource() +
        	", To " + flightsSchedule.getDestination() +
        	", Unit Price $" + flightsSchedule.getPrice() +
        	", Available Seats " + flightsSchedule.getSeatsAvailable()
        );
		
	}
	
	public static void buildAndPaymentDetails(HttpServletRequest request, HttpServletResponse response, Bookings bookings,
			FlightsSchedule flightsSchedule, int passengerCount) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		int unitPrice = 1000;
		int totalPrice = 4000;
		int seatsAvailable = 0;
//		FlightsSchedule flightsSchedule		

		unitPrice = flightsSchedule.getPrice();
		seatsAvailable = flightsSchedule.getSeatsAvailable();
		flightsSchedule.setSeatsBooked(flightsSchedule.getSeatsBooked() + passengerCount);
		flightsSchedule.setSeatsAvailable(flightsSchedule.getSeatsAvailable() - passengerCount);

		totalPrice = unitPrice * passengerCount;
		
		// Store trans details 
		session.setAttribute ("transBookingId",bookings.getId());
		session.setAttribute ("transDate",new Date());	
		session.setAttribute ("transFlightAmount",unitPrice);	
		session.setAttribute ("transPassengerCount",passengerCount);	
		session.setAttribute ("transTotalDue",totalPrice);	

		// build transaction screen
		// display booking detail and price
		// show pay
		// show input for payment

        out.print("<br>");
        out.print("<h4>Passenger list:</h4>");
		out.print("<form action='flyawaybookingpaymentservlet' method='post'>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th>");
		out.print("Count #");
		out.print("</th>");
		out.print("<th>");
		out.print("Passenger Name");
		out.print("</th>");
		out.print("<th>");
		out.print("Unit Price");
		out.print("</th>");
		out.print("</tr>");
		for (int i = 0; i < passengerCount; i++) {
			out.print("<tr>");
			out.print("<td>");
			out.print((i + 1) + "/" + passengerCount);
			out.print("</td>");
			out.print("<td>");
			if (i + 1 == 1)
				out.print(bookings.getPassengerOne());
			if (i + 1 == 2)
				out.print(bookings.getPassengerTwo());
			if (i + 1 == 3)
				out.print(bookings.getPassengerThree());
			if (i + 1 == 4)
				out.print(bookings.getPassengerFour());
			out.print("</td>");
			out.print("<td>");
			out.print(unitPrice);
			out.print("</td>");
			out.print("</tr>");
		}
		out.print("<tr>");
		out.print("<td/>");
		out.print("<td>");
		out.print("Total Euro Price: ");
		out.print("</td>");
		out.print("<td>");
		out.print(totalPrice);
		out.print("</td>");
		out.print("</tr>");
		out.print("</table>");
        out.print("<br>");
        out.print("<h3>Payment Details:</h3>");
		out.print(
				"Paymet Type: <select name='cardType'><option></option><option value='Master'>Master Card</option><option value='Revolut'>Revolut</option><option value='Visa'>Visa</option></select><br>");
		out.print(" Card No: <input type='number' name='cardNo' pattern='^[0-9]*$'/><br>");
		out.print(" Expiry Date: <input type='number' name='expireDate'/><br>");
		out.print(" Three Digit No: <input type='number' name='threeDigitNo'/><br>");
		out.print("<br><input type='submit' value='Pay' /> ");
		out.print("</form>");

	}
}
