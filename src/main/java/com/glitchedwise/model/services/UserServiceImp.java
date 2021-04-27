package com.glitchedwise.model.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.glitchedwise.model.entities.User;
import com.glitchedwise.model.forms.UserForm;
import com.glitchedwise.model.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService{

	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		
		if(user == null)
			return null;
		
		try {
			return userRepository.save(user);
		}catch(Throwable t) {
			throw t;
		}
	}

	@Override
	public List<User> findAll() {
		
		try {
					
			return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
			
		}catch(Throwable t) {
			throw t;
		}
	}

	@Override
	public void deleteUser(Integer userId) {
		
		try {
			
			userRepository.deleteById(userId);
			
		}catch(Throwable t) {
			throw t;
		}
	}

}
