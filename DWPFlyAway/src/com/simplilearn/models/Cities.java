package com.simplilearn.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class Cities {
	
	@Id
	private int id;
	private String Name;
	private String Country;
	private String Continent;
	
	public Cities() {}

	public Cities(int id, String name, String country, String continent) {
		super();
		this.id = id;
		Name = name;
		Country = country;
		Continent = continent;
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

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getContinent() {
		return Continent;
	}

	public void setContinent(String continent) {
		Continent = continent;
	}

	@Override
	public String toString() {
		return "Cities [id=" + id + ", Name=" + Name + ", Country=" + Country + ", Continent=" + Continent + "]";
	}

	
}
