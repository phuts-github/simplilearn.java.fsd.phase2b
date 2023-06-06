package com.simplilearn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.simplilearn.models.Bookings;
import com.simplilearn.models.Cities;
import com.simplilearn.models.FlightsSchedule;

public class CitiesDao {

	public CitiesDao() {}

	Cities cities;

	SessionFactory sessionFactory = new Configuration().configure("com/simplilearn/hibernate/hibernate.cfg.xml")
			.buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();

	public Integer saveOrUpdateCities(Cities cities) {

		try {
			session.saveOrUpdate(cities);
			transaction.commit();
			return cities.getId();
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public List<Cities> readCitiesById(String id) {

		String sql = String.format("Select * from Cities where Id = '%s';", id);
		try {
			List<Cities> cities;
			cities = session.createNativeQuery(sql).addEntity(Cities.class).list();
			return cities;
		} catch (RuntimeException e) {
			throw e;
		}
	}

}
