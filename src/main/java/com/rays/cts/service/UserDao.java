package com.rays.cts.service;
import java.util.List;

import com.rays.cts.model.User;

public interface UserDao {

	public void addUser(User user);
	public List<User> getAll();
	public User getById(int id,String pass);
}
