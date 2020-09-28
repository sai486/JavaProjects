package com.model;

public class User {

	private int unumber;
	private String uname;
	private String password;
	private String email;
	
	public int getUnumber() {
		return unumber;
	}
	public void setUnumber(int unumber) {
		this.unumber = unumber;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User() {
		
	}
	
	public User(int unumber, String uname, String password, String email) {
		super();
		this.unumber = unumber;
		this.uname = uname;
		this.password = password;
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserModel [unumber=" + unumber + ", uname=" + uname + ", password=" + password + ", email=" + email
				+ "]";
	}
	
}
