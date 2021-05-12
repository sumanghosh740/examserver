package com.exam.model;

public class JwtRequest {
	String username;
	String passwors;
	/**
	 * 
	 */
	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param username
	 * @param passwors
	 */
	public JwtRequest(String username, String passwors) {
		super();
		this.username = username;
		this.passwors = passwors;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswors() {
		return passwors;
	}
	public void setPasswors(String passwors) {
		this.passwors = passwors;
	}
	
	

}
