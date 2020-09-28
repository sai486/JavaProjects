package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.controller.ConnectionClass;
import com.interfaces.Music_interface;
import com.model.MusicMaster;

public class Delete_Music_Dao implements Music_interface{

	@Override
	public List<MusicMaster> getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertDetails(MusicMaster atm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteData(int id) {
		boolean b = false;
//		System.out.println("hello");
		Connection con = ConnectionClass.getConnection();
		try{
//			System.out.println("hello");
			PreparedStatement ps = con.prepareStatement("delete from MusicMaster where music_id = ?");
			ps.setInt(1,id);
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
	public boolean updateDetails(MusicMaster atm) {
		// TODO Auto-generated method stub
		return false;
	}

}
