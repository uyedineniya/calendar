package com.glitchedwise.model.services;

import java.util.List;

import com.glitchedwise.model.entities.User;

public interface UserService {

	User saveUser(User user);

	List<User> findAll();

	void deleteUser(Integer userId);
}
