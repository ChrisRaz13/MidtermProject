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
		// TODO Auto-generated method stub
		return null;
	}
	
}