package com.simplilearn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.simplilearn.models.Transactions;

public class TransactionsDao {

	public TransactionsDao() {}

	Transactions transactions;

	SessionFactory sessionFactory = new Configuration().configure("com/simplilearn/hibernate/hibernate.cfg.xml")
			.buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();

	public Integer saveOrUpdateTransactions(Transactions transactions) {

		try {
			session.saveOrUpdate(transactions);
			transaction.commit();
			return transactions.getId();
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Transactions> searchTransactions(int id) {

		String sql = String.format("Select * from Transactions where id = '%s';", id);
		try {
			List<Transactions> transactions;
			transactions = session.createNativeQuery(sql).addEntity(Transactions.class).list();
			return transactions;
		} catch (RuntimeException e) {
			throw e;
		}
	}

}
