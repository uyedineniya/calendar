package com.rootticc.model.services;

import java.util.List;
import java.util.Map;

import com.rootticc.model.entities.User;
import com.rootticc.model.forms.UserForm;

public interface UserService {

	User saveUser(User user);

	List<User> listUsers(Map<String, Object> filter);

	void deleteUser(Integer userId);
}
