package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.controller.ConnectionClass;
import com.interfaces.Admin_interface;
import com.model.Admin;

public class AdminLoginCheck implements Admin_interface {

	@Override
	public boolean loginCheck(String uname, String upass) {
		boolean b = false;
		Connection con = ConnectionClass.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("select * from adminlogin where aname = ? and apass = ?");
			pst.setString(1, uname);
			pst.setString(2, upass);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				b = true;
				
			}
					
		}catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}

	@Override
	public boolean addAdmin(Admin am) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setPassword(String uname, String pass, String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
