package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;


import com.controller.ConnectionClass;
import com.interfaces.Album_interface;
import com.model.AlbumtypeMaster;

public class RetriveAlbumDao implements Album_interface{

	@Override
	public List<AlbumtypeMaster> getInfo() {
	List<AlbumtypeMaster> list = new ArrayList<>(); 
		
		
	 
	Connection con = ConnectionClass.getConnection();
	
	try{
		PreparedStatement ps = con.prepareStatement("select * from albumtypemaster");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			
			AlbumtypeMaster am = new AlbumtypeMaster(rs.getInt(1),rs.getString(2),rs.getInt(3));
			list.add(am);
			
		}
	}catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
		
		return list;
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
		// TODO Auto-generated method stub
		return false;
	}

}
