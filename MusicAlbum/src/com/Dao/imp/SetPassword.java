package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.controller.ConnectionClass;
import com.interfaces.Admin_interface;
import com.model.Admin;

public class SetPassword implements Admin_interface{

	@Override
	public boolean loginCheck(String uname, String upass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAdmin(Admin am) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setPassword(String uname, String pass, String email) {

		boolean b = false;
		Connection con = ConnectionClass.getConnection();
		try {
						
			PreparedStatement pst1 = con.prepareStatement("update adminlogin set apass = '"+pass+"' where aname = '"+uname+"'"+" and email = "+"'"+email+"'");
					
			int res =pst1.executeUpdate();
			
			if(res>0) {
				b=true;
			}
		
		}catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}

}
