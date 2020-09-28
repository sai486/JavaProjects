package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.controller.ConnectionClass;
import com.interfaces.Artist_interface;

import com.model.ArtistMaster;

public class Retrive_Artist_Dao  implements Artist_interface{

	@Override
	public List<ArtistMaster> getInfo() {
		List<ArtistMaster> list = new ArrayList<>(); 
		
		
		 
		Connection con = ConnectionClass.getConnection();
//		System.out.println("hello");
		try{
			
			PreparedStatement ps = con.prepareStatement("select * from artistmaster");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				ArtistMaster am = new ArtistMaster(rs.getInt(1),rs.getString(2),rs.getString(3));
				list.add(am);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
			
			return list;
	}

	@Override
	public boolean insertDetails(ArtistMaster atm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteData(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDetails(ArtistMaster atm) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
