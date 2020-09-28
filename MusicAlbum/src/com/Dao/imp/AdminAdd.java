package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.controller.ConnectionClass;
import com.interfaces.Admin_interface;
import com.model.Admin;

public class AdminAdd  implements Admin_interface{

	@Override
	public boolean loginCheck(String uname, String upass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAdmin(Admin am) {
		boolean b = false;
		Connection con = ConnectionClass.getConnection();
		try {
						
			PreparedStatement ps = con.prepareStatement("insert into adminlogin(aname,email) values(?,?)");
			System.out.println("prepared 1 statemet created");
			ps.setString(1, am.getAname());
			ps.setString(2, am.getEmail());
		
			
			int res =ps.executeUpdate();
			
			if(res>0) {
				b=true;
			}
		
	}catch (Exception e) {
		System.out.println(e);
	}
		return b;
	}

	@Override
	public boolean setPassword(String uname, String pass, String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
