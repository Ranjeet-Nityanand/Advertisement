package com.mohshiri.advertisement.services;

import org.springframework.stereotype.Service;

import com.mohshiri.advertisement.model.User;

@Service
public interface UserServiceHandler {


	User saveUser(User u);

	boolean checkExist(String string);

	/**
	 * @param u
	 */
	User findByCredentials(User u);

	/**
	 * @param u
	 * @return
	 */
	User findByEmail(User u);

	/**
	 * @param u
	 * @return
	 */
	User finByEmailAndPasswordAndStatus(User u);


}
