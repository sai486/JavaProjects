package com.model;

public class Admin {

	private String aname;
	private String apass;
	private String email;
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApass() {
		return apass;
	}
	public void setApass(String apass) {
		this.apass = apass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Admin() {
		
	}
	public Admin(String aname, String apass, String email) {
		super();
		this.aname = aname;
		this.apass = apass;
		this.email = email;
	}
	@Override
	public String toString() {
		return "AdminModel [aname=" + aname + ", apass=" + apass + ", email=" + email + "]";
	}
}
