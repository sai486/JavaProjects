package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.controller.ConnectionClass;
import com.interfaces.User_interface;
import com.model.User;

public class AddUser implements User_interface{

	@Override
	public boolean addUser(User um) {
		boolean b = false;
		Connection con = ConnectionClass.getConnection();
		try {
						
			PreparedStatement pst1 = con.prepareStatement("insert into userlogin(uname,password,email) values(?,?,?)");
			System.out.println("prepared 1 statemet created");
			pst1.setString(1, um.getUname());
			pst1.setString(2, um.getPassword());
			pst1.setString(3, um.getEmail());
			
			int res =pst1.executeUpdate();
			
			if(res>0) {
				b=true;
			}
		
		}catch (Exception e) {
		System.out.println(e);
		}
		return b;
	}

	@Override
	public boolean loginCheck(String uname, String upass) {
		// TODO Auto-generated method stub
		return false;
	}

}
