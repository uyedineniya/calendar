package com.rootticc.model.forms;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import com.rootticc.model.entities.User;

public class UserForm {

	private Integer id;

	private String firstName;

	private String lastName;

	private String username;
	
	private String email;
	
	private String password;
	
	private Date createdIn;
	
	
	public Map<String, Object> buildFilter(){
		
		Map<String, Object> filter = new HashMap<>();
		
		if(id != null) {
			filter.put("id", id);
		}
		
		if(firstName != null && !firstName.trim().isEmpty()) {
			filter.put("firstName", firstName);
		}
		
		if(lastName != null && !lastName.trim().isEmpty()) {
			filter.put("lastName", lastName);
		}
		
		if(username != null && !username.trim().isEmpty()) {
			filter.put("username", username);
		}
		
		if(email != null && !email.trim().isEmpty()) {
			filter.put("email", email);
		}
		
		if(createdIn != null) {
			filter.put("createdIn", createdIn);
		}
		
		return filter;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreatedIn() {
		return createdIn;
	}

	public void setCreatedIn(Date createdIn) {
		this.createdIn = createdIn;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User formToEntity() {
		User user = new User();

		user.setCreatedIn(createdIn);
		user.setFirstName(firstName);
		user.setId(id);
		user.setLastName(lastName);
		user.setUser(username);
		user.setEmail(email);
		user.setPassword(password);
		
		return user;
	}
}
