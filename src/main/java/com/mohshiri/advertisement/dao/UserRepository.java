package com.mohshiri.advertisement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohshiri.advertisement.model.Status;
import com.mohshiri.advertisement.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	boolean existsByEmail(String email);

	/**
	 * @param email
	 * @param password
	 * @return
	 */
	User findByEmailAndPassword(String email, String password);

	/**
	 * @param email
	 * @param s
	 * @return
	 */
	User findByEmailAndStatus(String email, Status s);

	/**
	 * @param email
	 * @param password
	 * @param s
	 */
	User findByEmailAndPasswordAndStatus(String email, String password, Status s);



}
