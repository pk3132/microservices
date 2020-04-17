package com.appsdevloperblog.photoapp.api.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
	@NotNull(message = "firstName can not be null")
	@Size(min=3, message = "FirstName can not be less than 3 characters")
	private String firstName;
	
	@NotNull(message = "LastName can not be null")
	@Size(min=3, message = "Last Name can not be less than 3 characters")
	private String lastName;
	
	
	@NotNull(message = "Password can not be null")
	@Size(min=5, max=8, message = "Password must be between 5 to 8 character")
	private String password;
	
	@NotNull(message = "Email can not be null")
	@Email
	private String email;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
