package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.StudentDao;
import com.Model.Student;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		StudentDao sDao = new StudentDao();
		List<Student> list = sDao.listStudent();
		pw.println("<form action =DeleteStudent method =Post>");
		pw.println("<h1 >select the student name to delete the record from db<h1>");
		pw.println("<select name =sname>");
		for(Student l:list){
			pw.println("<option>"+l.getSname()+"</option>");
			
			}
		pw.println("<input type = submit ></select>");
		pw.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String sname = request.getParameter("sname");
		StudentDao sDao = new StudentDao();
		if(sDao.deleteStudent(sname)){
			pw.println("deleted success");
		}
		else{
			pw.println(" not deleted");
		}
		
//		int res = sDao.deleteStudent(sname);
//		if(res>0){
//			pw.println("deleted success");
//		}
//		else{
//			pw.println(" not deleted");
//		}
		
	}

}
