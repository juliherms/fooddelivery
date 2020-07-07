package com.food.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.food.userservice.model.User;
import com.food.userservice.service.UserService;

/**
 * This class responsible to provider user end point
 * 
 * @author j.a.vasconcelos
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService service;

	/**
	 * Method responsible to list users
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public List<User> list() {
		return service.findAll();
	}
	
	/**
	 * Method responsible to get user by username
	 * @param username
	 * @return
	 */
	@GetMapping("/findUsername")
	public User findByUsername(@RequestParam String username) {
		return service.findByUsername(username);
	}

	/**
	 * Responsible to view user by id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/view/{id}")
	public User details(@PathVariable Long id) {

		return service.findById(id);
	}

	/**
	 * Method responsible to create user
	 * 
	 * @param product
	 * @return
	 */
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User product) {
		return service.save(product);
	}

}