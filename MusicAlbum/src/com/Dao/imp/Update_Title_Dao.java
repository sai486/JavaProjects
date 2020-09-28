package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.controller.ConnectionClass;
import com.interfaces.Title_interface;
import com.model.Titlemaster;

public class Update_Title_Dao implements Title_interface{

	@Override
	public List<Titlemaster> getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertDetails(Titlemaster atm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteData(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDetails(Titlemaster atm) {
		boolean b = false;
		 
		Connection con = ConnectionClass.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement("update titlemaster set title_name = ? where title_id = ? ");
			ps.setString(1, atm.getTitle_name());			
			ps.setInt(2, atm.getTitle_id());
			int res = ps.executeUpdate();
			if(res>0){
				
				b =true;
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	
		return b;
	}

}
