package com.Ser_classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.imp.Pagination_Dao;
import com.interfaces.Ser_Interface;
import com.model.AllSongsPagenation;


public class Allsongspagination implements Ser_Interface {

	

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 res.setContentType("text/html");  
	        PrintWriter out=res.getWriter();  
	        Scanner sc = new Scanner(System.in);
	        int x = Pagination_Dao.getCount();
	        int y=1;	     
	        int pageid=Integer.parseInt(req.getParameter("page"));  
	        int total=5;  
	        if(pageid==1){}  
	        else{  
	          pageid = pageid-1;  
	          pageid=pageid*total+1;  
	        }  
	        List<AllSongsPagenation> list=Pagination_Dao.getRecords(pageid,total);  
	  
	        out.print("<h1>Records from: "+pageid+"</h1>");  
	        out.print("<table border='1' cellpadding='4' width='60%'>");  
	        out.print("<tr><th>Id</th><th>Name</th><th>Salary</th>");  
	        int j=1;
	        for(AllSongsPagenation e:list){  
	            out.print("<tr><td>"+j+"</td><td>"+e.getTitle_name()+"</td><td>"+e.getAlbum_name()+"</td><td>"+e.getArtist_name()+"</td><td>"+e.getGenere_name()+"</td></tr>");  
	            
	        }  
	        out.print("</table>");  
	        out.print("<a href='Pagination?page="+(y++)+"'>First</a> ");
	        int i=1;
	        while(i<(x-10)){
	        	i+=5;
	        	
	        	out.print("<a href='Pagination?page="+y+"'>"+y+"</a> "); 
	        	y++;
	        	 
	        }
	        out.print("<a href='Pagination?page="+y+"'>LAST</a> ");
		
	}

}
