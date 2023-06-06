package com.simplilearn.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airlines")
public class Airlines {
					
	@Id
	private int id;
	private String Name;
	private String Route;
	private String City;
	private String Country;
	
	public Airlines() {}

	public Airlines(int id, String name, String route, String city, String country) {
		super();
		this.id = id;
		Name = name;
		Route = route;
		City = city;
		Country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRoute() {
		return Route;
	}

	public void setRoute(String route) {
		Route = route;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	@Override
	public String toString() {
		return "Airlines [id=" + id + ", Name=" + Name + ", Route=" + Route + ", City=" + City + ", Country=" + Country
				+ "]";
	}
}
