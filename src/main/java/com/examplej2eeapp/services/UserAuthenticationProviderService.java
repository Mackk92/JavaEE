package com.examplej2eeapp.services;

import com.examplej2eeapp.domain.UserEntity;

public interface UserAuthenticationProviderService {

	
	
	boolean processUserAuthentication (UserEntity user);
}
