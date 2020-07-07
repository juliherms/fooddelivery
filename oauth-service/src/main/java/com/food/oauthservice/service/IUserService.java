package com.food.oauthservice.service;

import com.food.oauthservice.dto.User;

public interface IUserService {

	public User findByUsername(String username);

}
