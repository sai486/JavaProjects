package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.controller.ConnectionClass;
import com.interfaces.Music_interface;
import com.model.MusicMaster;

public class Update_Music_Dao implements Music_interface{

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDetails(MusicMaster atm) {
		boolean b = false;
		 
		Connection con = ConnectionClass.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement("update MusicMaster set album_id = ? ,title_id = ?,artist_id =?,genre_id=? where music_id = ?  ");
			ps.setInt(1, atm.getAlbum_id());
			ps.setInt(2, atm.getTitle_id());
			ps.setInt(3, atm.getArtist_id());
			ps.setInt(4, atm.getGenre_id());
			ps.setInt(5, atm.getMusic_id());
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
