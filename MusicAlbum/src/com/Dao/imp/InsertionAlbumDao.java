package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.Ser_classes.Insertionalbum;
import com.controller.ConnectionClass;
import com.interfaces.Album_interface;
import com.model.AlbumtypeMaster;

public class InsertionAlbumDao implements Album_interface{

	@Override
	public List<AlbumtypeMaster> getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertDetails(AlbumtypeMaster atm) {
		boolean b = false;
		 
		Connection con = ConnectionClass.getConnection();
		try{
		PreparedStatement ps = con.prepareStatement("insert into albumtypemaster(album_name,year,albumpic) values(?,?,?)");
		ps.setString(1, atm.getAlbum_name());
		ps.setInt(2, atm.getYear());
		ps.setBinaryStream(3, Insertionalbum.fos, Insertionalbum.size);
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
	public boolean updateDetails(AlbumtypeMaster atm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteData(int a) {
		// TODO Auto-generated method stub
		return false;
	}

}
