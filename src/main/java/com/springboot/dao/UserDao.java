package com.springboot.dao;

import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.model.User;

@Transactional
@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		return user;

	}

	public boolean createUser(Map<String, String> userData) {

		Session session = this.sessionFactory.getCurrentSession();
		User user = new User();
		user.setId(Integer.parseInt(userData.get("vendorId")));
		user.setName(userData.get("vendorName"));
		try {
			session.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
