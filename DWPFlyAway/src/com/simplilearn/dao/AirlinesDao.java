package com.simplilearn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.simplilearn.models.Airlines;

public class AirlinesDao {

	public AirlinesDao() {}

	Airlines airlines;

	SessionFactory sessionFactory = new Configuration().configure("com/simplilearn/hibernate/hibernate.cfg.xml")
			.buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();

	public Integer saveOrUpdateAirlines(Airlines airlines) {

		try {
			session.saveOrUpdate(airlines);
			transaction.commit();
			return airlines.getId();
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public List<Airlines> readAirlinesById(String id) {

		String sql = String.format("Select * from Airlines where Id = '%s';", id);
		try {
			List<Airlines> airlines;
			airlines = session.createNativeQuery(sql).addEntity(Airlines.class).list();
			return airlines;
		} catch (RuntimeException e) {
			throw e;
		}
	}

}
