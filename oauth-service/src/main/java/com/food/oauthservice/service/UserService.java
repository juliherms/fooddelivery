package com.food.oauthservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.food.oauthservice.dto.User;

/**
 * This class responsible to provide authenticate in the system
 * @author j.a.vasconcelos
 *
 */
@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserFeignClient client;

	private Logger log = LoggerFactory.getLogger(UserService.class);

	/**
	 * Check user
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = client.findByUsername(username);

		if (user == null) {
			log.error("user not found (" + username + ")");
			throw new UsernameNotFoundException("user not found (" + username + ")");
		}

		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.peek(authority -> log.info("Role: " + authority.getAuthority())).collect(Collectors.toList());

		log.info("User authenticated: " + username);

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.getEnabled(), true, true, true, authorities);
	}

}
