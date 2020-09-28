package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieExample
 */
@WebServlet("/CookieExample")
public class CookieExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    static int i=1;
    static int j=1;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		String shirt = request.getParameter("shirt");
		String book = request.getParameter("book");
		Cookie c1 = new Cookie("shirt"+i,shirt);
		Cookie c2 = new Cookie("book"+j,book);
		response.addCookie(c1);
		response.addCookie(c2);
		i++;
		j++;
		pw.println("<h1>Iteam in the shopping cart are </h1>");
		pw.println("<h3>"+c1.getName()+" : "+shirt+"</h3>");
		pw.println("<h3>"+c2.getName()+" : "+book+"</h3>");
		
		Cookie cc[] = request.getCookies();
		if(cc != null){
			for(int i =0;i<cc.length;i++){
				pw.println("<h3>"+cc[i].getName()+" : "+cc[i].getValue());
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/CookieDemo.jsp");
		rd.include(request, response);
		pw.close();
		
		
		
		
		
		
	}

}
