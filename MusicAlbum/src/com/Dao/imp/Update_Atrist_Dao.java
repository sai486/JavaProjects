package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.controller.ConnectionClass;
import com.interfaces.Artist_interface;
import com.model.ArtistMaster;

public class Update_Atrist_Dao implements Artist_interface{

	@Override
	public List<ArtistMaster> getInfo() {
		// TODO Auto-generated method stub
		return null;
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
		boolean b = false;
		 
		Connection con = ConnectionClass.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement("update artistmaster set Artist_name = ? , profession = ? where artist_id = ? ");
			ps.setString(1, atm.getArtist_name());
			ps.setString(2, atm.getProfession());
			ps.setInt(3, atm.getArtist_id());
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
