package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.controller.ConnectionClass;
import com.interfaces.Title_interface;
import com.model.Titlemaster;

public class Insert_Title_Dao implements Title_interface {

	@Override
	public List<Titlemaster> getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertDetails(Titlemaster atm) {
		boolean b = false;
		 
		Connection con = ConnectionClass.getConnection();
		try{
		PreparedStatement ps = con.prepareStatement("insert into titlemaster(title_name) values(?)");
		ps.setString(1, atm.getTitle_name());
		
		int rs = ps.executeUpdate();
		if(rs>0){
			b = true;
		}
				
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return b;
	}

	@Override
	public boolean deleteData(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDetails(Titlemaster atm) {
		// TODO Auto-generated method stub
		return false;
	}

}
