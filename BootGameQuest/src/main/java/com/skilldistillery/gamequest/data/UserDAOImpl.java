package com.skilldistillery.gamequest.data;

import org.springframework.stereotype.Service;

import com.skilldistillery.gamequest.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User authenticateUser(String username, String password) {
		try {
			String query= "SELECT u FROM User u WHERE u.username= :username AND u.password= :password";
			User u = em.createQuery(query, User.class)
					.setParameter("username", username)
					.setParameter("password", password)
					.getSingleResult();
			return u;
		}catch (Exception e) {
			return null;
		}

	}
	
}
