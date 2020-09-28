package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.controller.ConnectionClass;
import com.interfaces.Album_interface;
import com.model.AlbumtypeMaster;

public class UpdateAlbumDao  implements Album_interface{

	@Override
	public List<AlbumtypeMaster> getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertDetails(AlbumtypeMaster atm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteData(int aid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDetails(AlbumtypeMaster atm) {
		boolean b = false;
		 
		Connection con = ConnectionClass.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement("update AlbumtypeMaster set album_name = ? , year = ? where album_id = ? ");
			ps.setString(1, atm.getAlbum_name());
			ps.setInt(2, atm.getYear());
			ps.setInt(3, atm.getAlbum_id());
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
