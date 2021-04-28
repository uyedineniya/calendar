package com.rootticc.model.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.rootticc.model.entities.User;
import com.rootticc.model.repositories.UserRepository;

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
	public void deleteUser(Integer userId) {
		
		try {
			
			userRepository.deleteById(userId);
			
		}catch(Throwable t) {
			throw t;
		}
	}

	@Override
	public List<User> listUsers(Map<String, Object> filter) {
		try {
			
			return null;
			
		}catch(Throwable t) {
			throw t;
		}
		
	}

}
