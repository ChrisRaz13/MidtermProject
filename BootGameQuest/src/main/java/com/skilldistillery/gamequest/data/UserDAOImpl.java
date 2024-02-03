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
			String query = "SELECT u FROM User u WHERE u.username= :username AND u.password= :password";
			User u = em.createQuery(query, User.class).setParameter("username", username)
					.setParameter("password", password).getSingleResult();
			return u;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int addUser(User user) {
		em.persist(user);
		em.flush();
		return user.getId();
	}

	@Override
	public User findUserById(int id) {
		return em.find(User.class, id);
	}

	@Override
	public User deactivateUserById(int id) {
		User user = em.find(User.class, id);
		if (user == null) {
			return null;
		}
		em.remove(user);
		em.flush();
		return user;
	}

	@Override
	public void updateUserById(int id, User u) {
		User user = em.find(User.class, id);
		user.setPassword(u.getPassword());
		user.setUsername(u.getUsername());
		user.setProfilePicture(u.getProfilePicture());
	}

	@Override
	public User findUserByUsername(String username) {
		try {
			String query = "SELECT u FROM User u WHERE u.username= :username";
			User u = em.createQuery(query, User.class).setParameter("username", username)
					.getSingleResult();
			return u;
		} catch (Exception e) {
			return null;
		}		
	}

}
