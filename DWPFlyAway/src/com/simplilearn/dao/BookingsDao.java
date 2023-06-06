package com.simplilearn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.simplilearn.models.Bookings;
import com.simplilearn.models.Users;

public class BookingsDao {
	public BookingsDao() {
	}

	SessionFactory sessionFactory = new Configuration().configure("com/simplilearn/hibernate/hibernate.cfg.xml")
			.buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();

	public Integer saveOrUpdateBooking(Bookings bookings) {
		try {
			session.saveOrUpdate(bookings);
			transaction.commit();
			return bookings.getId();
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public Bookings readBookingById(int id) {

		String sql = String.format("Select * from Bookings where Id = '%s'", id);
		try {
			List<Bookings> listBookings;
			listBookings = session.createNativeQuery(sql).addEntity(Bookings.class).list();
			return listBookings.get(0);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public Integer deleteBookingsByScheduleIdAndTransactionIdAndUserId(Integer flightScheduleId, Integer transactionId,
			Integer userId) {
		String sql = String.format(
				"Delete from Bookings where flightScheduleId = '%s' and transactionId = '%s' and userId = '%s';",
				flightScheduleId, transactionId, userId);
		try {
			int intDeleteResults = session.createNativeQuery(sql).addEntity(Bookings.class).executeUpdate();
			return intDeleteResults;
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
