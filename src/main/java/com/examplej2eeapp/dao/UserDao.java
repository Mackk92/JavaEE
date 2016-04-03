package com.examplej2eeapp.dao;

import com.examplej2eeapp.commons.dao.GenericDao;
import com.examplej2eeapp.domain.UserEntity;


public interface UserDao extends GenericDao<UserEntity, Long> {


	boolean checkAvailable(String userName);

	UserEntity loadUserByUserName(String userName);
}
