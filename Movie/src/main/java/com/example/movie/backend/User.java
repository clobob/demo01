package com.example.movie.backend;

import java.util.List;

public class User {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj instanceof User) {
			if(((User)obj).getUsername().equals(this.getUsername()) && ((User)obj).getPassword().equals(this.getPassword())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 登录方法，登录成功返回true，失败返回false
	 * @param user
	 * @return boolean 
	 */
	public static boolean login(User user) {
		for(User u:users) {
			if(u.equals(user)) {
				return true;
			}
		}
		return false;
	}
	
	public static List<User> users = JsonAdapter.getUserFromJson("Users.json");
}
