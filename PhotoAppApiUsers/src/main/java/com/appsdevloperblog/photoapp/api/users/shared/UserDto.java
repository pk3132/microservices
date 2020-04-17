package com.appsdevloperblog.photoapp.api.users.shared;

import java.io.Serializable;

public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6610612210601600036L;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String userId;
	private String encryptedPassword;

	public String getUserId() {
		return userId;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

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
