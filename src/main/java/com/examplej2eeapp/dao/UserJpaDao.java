package com.examplej2eeapp.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.util.Assert;

import com.examplej2eeapp.commons.dao.GenericJpaDao;
import com.examplej2eeapp.domain.UserEntity;


public class UserJpaDao extends GenericJpaDao<UserEntity, Long> implements UserDao {

	public UserJpaDao() {
		super(UserEntity.class);
	}
													

	public boolean checkAvailable(String userName) {
		Assert.notNull(userName);
		
		Query query = getEntityManager()
			.createQuery("select count(*) from " + getPersistentClass().getSimpleName() 
					+ " u where u.userName = :userName").setParameter("userName", userName);
		
		Long count = (Long) query.getSingleResult();
		
		return count < 1;
	}


	public UserEntity loadUserByUserName(String userName) {
		Assert.notNull(userName);
		
		UserEntity user = null;
		
		Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
				+ " u where u.userName = :userName").setParameter("userName", userName);
		
		try {
			user = (UserEntity) query.getSingleResult();
		} catch(NoResultException e) {
			//do nothing
		}
		
		return user;
	}

}