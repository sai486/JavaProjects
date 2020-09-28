package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Model.Student;

public class StudentDao {
	
	public Connection CreateConnection(){
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MVC","root","root");
			
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return con;
	}
	public boolean addStudent(Student st){
		boolean b =false;
		Connection con = CreateConnection();
		try{
			PreparedStatement pst = con.prepareStatement(
					"insert into student(sname,spass,mobileno,cname) values (?,?,?,?)");
			pst.setString(1, st.getSname());
			pst.setString(2, st.getSpass());
			pst.setString(3, st.getMobilenumber());
			pst.setString(4, st.getCname());
		
			int res = pst.executeUpdate();
			if(res>0){
				b=true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return b;
	}
	
	public boolean valiedUser(String user,String password){
		boolean b =false;
		Connection con = CreateConnection();
		try{
			PreparedStatement pst = con.prepareStatement(
					"select * from student where sname = ? and spass = ?");
			pst.setString(1,user);
			pst.setString(2, password);

			ResultSet res = pst.executeQuery();
			if(res.next()){
				b=true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return b;
	}
	
	public List<Student> listStudent(){
		List <Student> list = new ArrayList<Student>();
		Connection con = CreateConnection();
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from student");
			while(rs.next()){
				Student s = new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				list.add(s);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}
	public boolean deleteStudent(String sname) {
		boolean b=false;
		Connection con = CreateConnection();
		try{
			PreparedStatement pst = con.prepareStatement("delete from student where sname = ?");
			pst.setString(1,sname);
			int res = pst.executeUpdate();
			if(res>0){
				b= true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return b;
	}

//	public int deleteStudent(String sname) {
//
//		Connection con = CreateConnection();
//		try{
//			PreparedStatement pst = con.prepareStatement("delete from student where sname = ?");
//			pst.setString(1,sname);
//			int res = pst.executeUpdate();
//			if(res>0){
//				return 1;
//			}
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		return 0;
//	}
}
