package com.simplilearn.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class Bookings {
	
	@Id
	private int Id;	
	private int UserId;
	private int FlightScheduleId;
	private String FlightDate;
	private String PassengerOne;
	private String PassengerTwo;
	private String PassengerThree;
	private String PassengerFour;
	private int PassengerCount;
	private int TransactionId;
	
	public Bookings() {}

	public Bookings(int id, int userId, int flightScheduleId, String flightDate, String passengerOne,
			String passengerTwo, String passengerThree, String passengerFour, int passengerCount, int transactionId) {
		super();
		Id = id;
		UserId = userId;
		FlightScheduleId = flightScheduleId;
		FlightDate = flightDate;
		PassengerOne = passengerOne;
		PassengerTwo = passengerTwo;
		PassengerThree = passengerThree;
		PassengerFour = passengerFour;
		PassengerCount = passengerCount;
		TransactionId = transactionId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getFlightScheduleId() {
		return FlightScheduleId;
	}

	public void setFlightScheduleId(int flightScheduleId) {
		FlightScheduleId = flightScheduleId;
	}

	public String getFlightDate() {
		return FlightDate;
	}

	public void setFlightDate(String flightDate) {
		FlightDate = flightDate;
	}

	public String getPassengerOne() {
		return PassengerOne;
	}

	public void setPassengerOne(String passengerOne) {
		PassengerOne = passengerOne;
	}

	public String getPassengerTwo() {
		return PassengerTwo;
	}

	public void setPassengerTwo(String passengerTwo) {
		PassengerTwo = passengerTwo;
	}

	public String getPassengerThree() {
		return PassengerThree;
	}

	public void setPassengerThree(String passengerThree) {
		PassengerThree = passengerThree;
	}

	public String getPassengerFour() {
		return PassengerFour;
	}

	public void setPassengerFour(String passengerFour) {
		PassengerFour = passengerFour;
	}

	public int getPassengerCount() {
		return PassengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		PassengerCount = passengerCount;
	}

	public int getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(int transactionId) {
		TransactionId = transactionId;
	}

	@Override
	public String toString() {
		return "Bookings [Id=" + Id + ", UserId=" + UserId + ", FlightScheduleId=" + FlightScheduleId + ", FlightDate="
				+ FlightDate + ", PassengerOne=" + PassengerOne + ", PassengerTwo=" + PassengerTwo + ", PassengerThree="
				+ PassengerThree + ", PassengerFour=" + PassengerFour + ", PassengerCount=" + PassengerCount
				+ ", TransactionId=" + TransactionId + "]";
	}


}
