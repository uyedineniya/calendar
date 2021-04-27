package com.glitchedwise.model.forms;

import java.sql.Date;

import com.glitchedwise.model.entities.User;

public class UserForm {

	private Integer id;

	private String firstName;

	private String LastName;

	private String username;
	
	private String email;
	
	private String password;


	private Date createdIn;

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
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
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
		user.setLastName(LastName);
		user.setUser(username);
		user.setEmail(email);
		user.setPassword(password);
		
		return user;
	}
}
