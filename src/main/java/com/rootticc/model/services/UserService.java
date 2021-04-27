package com.rootticc.model.services;

import java.util.List;

import com.rootticc.model.entities.User;

public interface UserService {

	User saveUser(User user);

	List<User> findAll();

	void deleteUser(Integer userId);
}
