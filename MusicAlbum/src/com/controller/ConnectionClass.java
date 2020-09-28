package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	static Connection con;
	 static ConnectionClass cc = null;
	 private ConnectionClass(){
		 
	 }
	 public static ConnectionClass getObj(){
		 if(cc == null){
			 synchronized (ConnectionClass.class){
				 cc = new ConnectionClass();
			 }
			 
		 }
		 return cc;
	 }
	 public static Connection getConnection(){
		 try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicalbum","root","root");
				System.out.println();
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
	
		 
			return con; 
	 }

}
