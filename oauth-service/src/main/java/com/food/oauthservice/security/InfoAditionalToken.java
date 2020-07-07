package com.food.oauthservice.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.food.oauthservice.dto.User;
import com.food.oauthservice.service.IUserService;

@Component
public class InfoAditionalToken implements TokenEnhancer {

	@Autowired
	private IUserService userService;

	/**
	 * Method responsible to put add information in my token
	 */
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		Map<String, Object> info = new HashMap<String, Object>();

		User user = userService.findByUsername(authentication.getName());
		info.put("name", user.getName());
		info.put("login", user.getUsername());
		info.put("email", user.getEmail());

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

		return accessToken;
	}

}
