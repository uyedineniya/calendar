package com.rootticc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rootticc.model.entities.User;
import com.rootticc.model.forms.UserForm;
import com.rootticc.model.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

	private UserService userService;

	@RequestMapping("/save")
	public User saveUser(UserForm userForm) {
		if (userForm == null)
			return null;

		try {
			return userService.saveUser(userForm.formToEntity());

		} catch (Throwable t) {
			throw t;
		}
	}

	@RequestMapping("/list")
	public List<User> listUsers() {

		try {
			return userService.findAll();

		} catch (Throwable t) {
			throw t;
		}

	}

	@RequestMapping("/remove")
	public void loignUser(Integer userId) {

		try {
			userService.deleteUser(userId);
		} catch (Throwable t) {
			throw t;
		}

	}

}
