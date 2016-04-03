package com.examplej2eeapp.services;

import javax.faces.event.AjaxBehaviorEvent;

import com.examplej2eeapp.domain.UserEntity;

public interface UserService {
	
	boolean createUser(UserEntity userEntity);
	
	boolean checkAvailable(AjaxBehaviorEvent event);
	
	UserEntity loadUserEntityByUsername(String userName);

}
 