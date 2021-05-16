package com.exam.model;

public class JwtRequest {
	String username;
	String password;
	/**
	 * 
	 */
	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param username
	 * @param password
	 */
	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPasswors(String password) {
		this.password = password;
	}
	
	

}
