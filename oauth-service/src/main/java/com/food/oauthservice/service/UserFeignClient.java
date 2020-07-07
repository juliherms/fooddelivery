package com.food.oauthservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.food.oauthservice.dto.User;

/**
 * This class responsible to call users services via load balance
 * 
 * @author j.a.vasconcelos
 *
 */
@FeignClient(name = "user-service")
public interface UserFeignClient {

	/**
	 * Method responsible to call user-service and find User by username
	 * @param usernama
	 * @return
	 */
	@GetMapping("/findUsername")
	public User findByUsername(@RequestParam String username);

}
