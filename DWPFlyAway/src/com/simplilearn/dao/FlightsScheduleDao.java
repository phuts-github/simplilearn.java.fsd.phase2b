package com.simplilearn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.simplilearn.models.FlightsSchedule;

public class FlightsScheduleDao {

	public FlightsScheduleDao() {}

	FlightsSchedule flightsSchedule;

	SessionFactory sessionFactory = new Configuration().configure("com/simplilearn/hibernate/hibernate.cfg.xml")
			.buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();

	public Integer saveOrUpdateFlightsSchedule(FlightsSchedule flightsSchedule) {

		try {
			session.saveOrUpdate(flightsSchedule);
			transaction.commit();
			return flightsSchedule.getId();
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<FlightsSchedule> searchFlightsSchedule(String flyFrom, String flyTo) {

		String sql = String.format("Select * from FlightsSchedule where Source = '%s' and Destination = '%s';", flyFrom,
				flyTo);
		try {
			List<FlightsSchedule> flightsSchedule;
			flightsSchedule = session.createNativeQuery(sql).addEntity(FlightsSchedule.class).list();
			return flightsSchedule;
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public FlightsSchedule readFlightsScheduleById(Integer id) {

		String sql = String.format("Select * from FlightsSchedule where Id = '%s';", id);
		try {
			List<FlightsSchedule> flightsSchedule;
			flightsSchedule = session.createNativeQuery(sql).addEntity(FlightsSchedule.class).list();
			return flightsSchedule.get(0);
		} catch (RuntimeException e) {
			throw e;
		}
	}

}
