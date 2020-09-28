package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.controller.ConnectionClass;
import com.interfaces.Genre_interface;
import com.model.Genremaster;

public class Update_Genre_Dao  implements Genre_interface{

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDetails(Genremaster atm) {
		boolean b = false;
		 
		Connection con = ConnectionClass.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement("update genremaster set genere_name = ? where genre_id = ? ");
			ps.setString(1, atm.getGenere_name());
			ps.setInt(2, atm.getGenre_id());
			
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
