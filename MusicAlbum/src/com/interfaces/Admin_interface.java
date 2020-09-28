package com.interfaces;

import com.model.Admin;

public interface Admin_interface {
	public boolean loginCheck(String uname,String upass);
	public boolean addAdmin(Admin am);
	public boolean setPassword(String uname,String pass,String email);

}
