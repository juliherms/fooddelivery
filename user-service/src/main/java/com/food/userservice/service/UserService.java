package com.food.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.userservice.model.User;
import com.food.userservice.repository.UserRepository;

/**
 * This class responsive to provide user service
 * 
 * @author j.a.vasconcelos
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	/**
	 * Return all users in the database
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) repo.findAll();
	}

	/**
	 * Return user by id
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public User findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	/**
	 * Save user
	 * 
	 * @param p
	 * @return
	 */
	@Transactional
	public User save(User u) {
		return repo.save(u);
	}

	/**
	 * Remove user
	 * 
	 * @param id
	 */
	@Transactional
	public void remove(Long id) {
		repo.deleteById(id);
	}

}
