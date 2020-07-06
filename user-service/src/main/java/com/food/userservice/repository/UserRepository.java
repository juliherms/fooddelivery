package com.food.userservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.food.userservice.model.User;

/**
 * This class represents user repository
 * @author j.a.vasconcelos
 *
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	/**
	 * Find user by username and email
	 * @param username
	 * @param email
	 * @return
	 */
	public User findByUsernameAndEmail(String username, String email);

	/**
	 * Find user by username
	 * @param username
	 * @return
	 */
	@Query("select u from User u where u.username =?1")
	public User getByUsername(String username);
}
