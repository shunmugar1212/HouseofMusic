package com.niit.back.dao;

import java.util.List;

import com.niit.back.domain.User;

public interface UserDAO {

	public void save(User user);

	public boolean update(User user);

	public boolean validate(String id, String password);

	public List<User> list();

	public User get(String id);
	
	public User getByEmailId(String email);

}
