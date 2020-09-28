package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.controller.ConnectionClass;
import com.interfaces.Genre_interface;
import com.model.Genremaster;

public class Delete_Genre_Dao implements Genre_interface {

	@Override
	public List<Genremaster> getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertDetails(Genremaster atm) {
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
			PreparedStatement ps = con.prepareStatement("delete from genremaster where genre_id = ?");
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
	public boolean updateDetails(Genremaster atm) {
		// TODO Auto-generated method stub
		return false;
	}

}
