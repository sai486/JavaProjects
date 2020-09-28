package com.Dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.controller.ConnectionClass;
import com.model.AllSongsPagenation;

public class Pagination_Dao {

	
	public static List<AllSongsPagenation> getRecords(int start,int total){  
        List<AllSongsPagenation> list=new ArrayList<AllSongsPagenation>();  
        try{  
        	Connection con = ConnectionClass.getConnection();   
            PreparedStatement ps=con.prepareStatement("select * from allsongspagination limit "+(start-1)+","+total);  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	AllSongsPagenation e=new AllSongsPagenation();  
             e.setArtist_name(rs.getString(1));
             e.setGenere_name(rs.getString(2));
             e.setTitle_name(rs.getString(3));
             e.setAlbum_name(rs.getString(4));
             e.setMusic_id(rs.getInt(5));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){System.out.println(e);}  
        return list;  
    }  
    
    public static int getCount(){
    	int a =0;
    	try {
    		Connection con = ConnectionClass.getConnection();  
    	 PreparedStatement ps=con.prepareStatement("select * from allsongspagination ");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                a++;  
            }
    
			  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
  
    	
    	return a;
    }

	
}
