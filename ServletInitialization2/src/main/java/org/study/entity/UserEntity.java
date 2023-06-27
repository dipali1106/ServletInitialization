package org.study.entity;


public class UserEntity {
	int users_id;
	String username;
	String email;
	
	
	public UserEntity( String username, String email) {
		this.username = username;
		this.email = email;
	}
	public UserEntity(int users_id, String username, String email) {
		this.users_id = users_id;
		this.username = username;
		this.email = email;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
