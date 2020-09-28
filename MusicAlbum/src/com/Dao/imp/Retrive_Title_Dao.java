package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.controller.ConnectionClass;
import com.interfaces.Title_interface;

import com.model.Titlemaster;

public class Retrive_Title_Dao implements Title_interface {

	@Override
	public List<Titlemaster> getInfo() {
		List<Titlemaster> list = new ArrayList<>(); 
		
		
		 
		Connection con = ConnectionClass.getConnection();
//		System.out.println("hello");
		try{
			
			PreparedStatement ps = con.prepareStatement("select * from titlemaster");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				Titlemaster tm = new Titlemaster(rs.getInt(1), rs.getString(2));
				list.add(tm);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
			
			return list;
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
		// TODO Auto-generated method stub
		return false;
	}

}
