package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Ser_classes.*;

import com.interfaces.Ser_Interface;

/**
 * Servlet implementation class SingleServlet
 */
@WebServlet("/SingleServlet")
public class SingleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */ HashMap<String,Ser_Interface> map = null;
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<>();
		map.put("insert", new Insertionalbum());
		map.put("update", new Update_album());
		map.put("delete", new Delete_album());
		map.put("Art_insert", new Insertion_Artist());
		map.put("Art_update", new Update_Artist());
		map.put("Art_delete", new Delete_Artist());
		map.put("Gne_insert", new Insertion_Genre());
		map.put("Gne_update", new Update_Genre());
		map.put("Gne_delete", new Delete_Genre());
		map.put("Ti_delete", new Delete_Title());
		map.put("Ti_update", new Update_Title());
		map.put("Ti_insert", new Insertion_Title());
		
		map.put("M_update", new Update_Music());
		map.put("M_delete", new Delete_Music());
		map.put("M_insert", new Insert_Music() );
		map.put("logintouser", new UserLogin());
		map.put("registeruser", new UserAdd());
		map.put("logintoadmin", new AdminLogin());
		map.put("registeradmin", new AddAdmin());
		map.put("setpasswordforadmin", new SetAdminPassword());
		map.put("userlogout", new UserLogout());
		map.put("adminlogout", new AdminLogout());
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String aname = request.getParameter("action");
//		System.out.println(aname);
		Ser_Interface obj = map.get(aname);
		obj.perform(request, response);
		
	}



}
