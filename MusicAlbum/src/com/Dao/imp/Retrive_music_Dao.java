package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.controller.ConnectionClass;
import com.interfaces.Music_interface;
import com.model.MusicMaster;


public class Retrive_music_Dao implements Music_interface{

	@Override
	public List<MusicMaster> getInfo() {
		List<MusicMaster> list = new ArrayList<>(); 
		
		
		 
		Connection con = ConnectionClass.getConnection();
//		System.out.println("hello");
		try{
			
			PreparedStatement ps = con.prepareStatement("select * from MusicMaster");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				MusicMaster tm = new MusicMaster(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
				list.add(tm);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
			
			return list;
	}

	@Override
	public boolean insertDetails(MusicMaster atm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteData(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDetails(MusicMaster atm) {
		// TODO Auto-generated method stub
		return false;
	}

}
