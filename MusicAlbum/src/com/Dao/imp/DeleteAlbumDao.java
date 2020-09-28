package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.controller.ConnectionClass;
import com.interfaces.Album_interface;
import com.model.AlbumtypeMaster;

public class DeleteAlbumDao implements Album_interface {

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
		boolean b = false;
//		System.out.println("hello");
		Connection con = ConnectionClass.getConnection();
		try{
//			System.out.println("hello");
			PreparedStatement ps = con.prepareStatement("delete from AlbumtypeMaster where album_id = ?");
			ps.setInt(1,aid);
			int rs = ps.executeUpdate();
//			System.out.println(".....**");
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

}
