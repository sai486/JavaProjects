package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.controller.ConnectionClass;
import com.interfaces.User_interface;
import com.model.User;

public class UserLoginCheck  implements User_interface{

	public static int id;
	 public static String dbname;
	@Override
	public boolean addUser(User um) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loginCheck(String uname, String upass) {
		boolean b = false;
		Connection con = ConnectionClass.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("select * from userlogin where uname = ? and password = ?");
			pst.setString(1, uname);
			pst.setString(2, upass);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt(1);
				dbname = rs.getString(2);
				b = true;
				
			}
			
					
		}catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}

}
