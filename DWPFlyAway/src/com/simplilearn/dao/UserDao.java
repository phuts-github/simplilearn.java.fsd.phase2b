package com.simplilearn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.simplilearn.models.Airlines;
import com.simplilearn.models.Users;

public class UserDao {
	public UserDao() {
		System.out.println("RegisterDao");
	}

	SessionFactory sessionFactory = new Configuration().configure("com/simplilearn/hibernate/hibernate.cfg.xml")
			.buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();

	public Integer registerUser(int pId, String pEmail, String pName, String pContact, String pType, String pPass) {

		Users user = new Users(pId, pPass, pName, pEmail, pContact, pType);
		try {
			session.save(user);
			transaction.commit();
			return 1;
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public Integer saveOrUpdateUsers(Users user) {

		try {
			session.saveOrUpdate(user);
			transaction.commit();
			return user.getId();
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Users> readUserById(int id) {

		String sql = String.format("Select * from Users where Id = '%s'", id);
		try {
			List<Users> listUserSearchResult;
			listUserSearchResult = session.createNativeQuery(sql).addEntity(Users.class).list();
			return listUserSearchResult;
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public Integer readUserByEmailAndPass(String pEmail, String pPass) {

		String sql = String.format("Select * from Users where Email = '%s' and Pass = '%s';", pEmail, pPass);
		try {
			List<Users> listUserSearchResult;
			listUserSearchResult = session.createNativeQuery(sql).addEntity(Users.class).list();
			int returnUserId = 0;
			if (!listUserSearchResult.isEmpty()) {
				for (Users users : listUserSearchResult) {
					returnUserId = listUserSearchResult.get(0).getId();
				}
			}
			return returnUserId;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Integer readUserByEmailAndPassAndPassAdmin(String pEmail, String pPass, String pPassAdmin) {

		String sql = String.format("Select * from Users where Email = '%s' and Pass = '%s' and Type = '%s';", pEmail, pPass, pPassAdmin);
		try {
			List<Users> listUserSearchResult;
			listUserSearchResult = session.createNativeQuery(sql).addEntity(Users.class).list();
			int returnUserId = 0;
			if (!listUserSearchResult.isEmpty()) {
				for (Users users : listUserSearchResult) {
					returnUserId = listUserSearchResult.get(0).getId();
				}
			}
			return returnUserId;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Integer readUserByEmail(String pEmail) {

		String sql = String.format("Select *" + " from Users" + " where Email = '%s';", pEmail);
		try {
			List<Users> listUserSearchResult;
			listUserSearchResult = session.createNativeQuery(sql).addEntity(Users.class).list();
			int returnUserId = 0;
			if (!listUserSearchResult.isEmpty()) {
				for (Users users : listUserSearchResult) {
					returnUserId = listUserSearchResult.get(0).getId();
				}
			}
			return returnUserId;
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
