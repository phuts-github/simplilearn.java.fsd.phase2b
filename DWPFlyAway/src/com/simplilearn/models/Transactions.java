package com.simplilearn.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transactions {
	
	@Id
	private int id;
	private int BookingId;
	private int FlightAmount;
	private int PassengerCount;
	private int TotalDue;
	private int TotalPaid;
	private String Date;
	
	public Transactions() {}

	public Transactions(int id, int bookingId, int flightAmount, int passengerCount, int totalDue, int totalPaid,
			String date) {
		super();
		this.id = id;
		BookingId = bookingId;
		FlightAmount = flightAmount;
		PassengerCount = passengerCount;
		TotalDue = totalDue;
		TotalPaid = totalPaid;
		Date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookingId() {
		return BookingId;
	}

	public void setBookingId(int bookingId) {
		BookingId = bookingId;
	}

	public int getFlightAmount() {
		return FlightAmount;
	}

	public void setFlightAmount(int flightAmount) {
		FlightAmount = flightAmount;
	}

	public int getPassengerCount() {
		return PassengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		PassengerCount = passengerCount;
	}

	public int getTotalDue() {
		return TotalDue;
	}

	public void setTotalDue(int totalDue) {
		TotalDue = totalDue;
	}

	public int getTotalPaid() {
		return TotalPaid;
	}

	public void setTotalPaid(int totalPaid) {
		TotalPaid = totalPaid;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", BookingId=" + BookingId + ", FlightAmount=" + FlightAmount
				+ ", PassengerCount=" + PassengerCount + ", TotalDue=" + TotalDue + ", TotalPaid=" + TotalPaid
				+ ", Date=" + Date + "]";
	}

	
}
