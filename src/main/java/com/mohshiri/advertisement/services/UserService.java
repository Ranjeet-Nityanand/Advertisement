package com.mohshiri.advertisement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohshiri.advertisement.dao.UserRepository;
import com.mohshiri.advertisement.model.Status;
import com.mohshiri.advertisement.model.User;

@Service
public class UserService implements UserServiceHandler{
	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User u) {
		try {
		return userRepository.save(u);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean checkExist(String email) {
		try {
		boolean b=userRepository.existsByEmail(email);
		return b;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public User findByCredentials(User u) {
		try {
			return userRepository.findByEmailAndPassword(u.getEmail(),u.getPassword());
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User findByEmail(User u) {
		Status s=new Status();
		try {
			s.setId(1);
			return userRepository.findByEmailAndStatus(u.getEmail(),s);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User finByEmailAndPasswordAndStatus(User u) {
		Status s=new Status();
		try {
			s.setId(1);
			return userRepository.findByEmailAndPasswordAndStatus(u.getEmail(),u.getPassword(),s);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

}
