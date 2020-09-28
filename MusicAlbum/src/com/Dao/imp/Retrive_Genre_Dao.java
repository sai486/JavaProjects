package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.controller.ConnectionClass;
import com.interfaces.Genre_interface;

import com.model.Genremaster;

public class Retrive_Genre_Dao  implements Genre_interface{

	@Override
	public List<Genremaster> getInfo() {
		List<Genremaster> list = new ArrayList<>(); 
		
		
		 
		Connection con = ConnectionClass.getConnection();
//		System.out.println("hello");
		try{
			
			PreparedStatement ps = con.prepareStatement("select * from genremaster");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				Genremaster gm = new Genremaster(rs.getInt(1), rs.getString(2));
				list.add(gm);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
			
			return list;
	}

	@Override
	public boolean insertDetails(Genremaster atm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteData(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDetails(Genremaster atm) {
		// TODO Auto-generated method stub
		return false;
	}

}
