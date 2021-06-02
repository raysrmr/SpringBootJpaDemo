package com.rays.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rays.cts.model.User;
import com.rays.cts.repositories.UserRepository;

@Component
public class UserService implements UserDao {

	@Autowired
	UserRepository userRepository;
	@Override
	public void addUser(User user) {
		userRepository.save(user);		
	}

	@Override
	public List<User> getAll() {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	@Override
	public User getById(int id, String pass) {
		User user = userRepository.findOne(id,pass);
		return user;
	}
	
	

}
