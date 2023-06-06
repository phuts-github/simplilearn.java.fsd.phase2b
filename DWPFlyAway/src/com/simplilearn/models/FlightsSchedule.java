package com.simplilearn.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flightsschedule")
public class FlightsSchedule {
	
	@Id
	private int id;
	private String Source;
	private String Destination;
	private String Date;
	private String Airline;
	private int Price;
	private int SeatsTotal;
	private int SeatsBooked;
	private int SeatsAvailable;
	
	public FlightsSchedule() {}

	public FlightsSchedule(int id, String source, String destination, String date, String airline, int price,
			int seatsTotal, int seatsBooked, int seatsAvailable) {
		super();
		this.id = id;
		Source = source;
		Destination = destination;
		Date = date;
		Airline = airline;
		Price = price;
		SeatsTotal = seatsTotal;
		SeatsBooked = seatsBooked;
		SeatsAvailable = seatsAvailable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getAirline() {
		return Airline;
	}

	public void setAirline(String airline) {
		Airline = airline;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getSeatsTotal() {
		return SeatsTotal;
	}

	public void setSeatsTotal(int seatsTotal) {
		SeatsTotal = seatsTotal;
	}

	public int getSeatsBooked() {
		return SeatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		SeatsBooked = seatsBooked;
	}

	public int getSeatsAvailable() {
		return SeatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		SeatsAvailable = seatsAvailable;
	}

	@Override
	public String toString() {
		return "FlightsSchedule [id=" + id + ", Source=" + Source + ", Destination=" + Destination + ", Date=" + Date
				+ ", Airline=" + Airline + ", Price=" + Price + ", SeatsTotal=" + SeatsTotal + ", SeatsBooked="
				+ SeatsBooked + ", SeatsAvailable=" + SeatsAvailable + "]";
	}
}
