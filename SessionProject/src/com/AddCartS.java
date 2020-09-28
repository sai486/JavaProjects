package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Product;

/**
 * Servlet implementation class AddCartS
 */
@WebServlet("/AddCartS")
public class AddCartS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
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
		HttpSession hs = request.getSession(true);
		List<Product> cart = (List<Product>) hs.getAttribute("mycart");
		System.out.println(cart);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","root");
			System.out.println(con);
			String product = request.getParameter("product");
			System.out.println(product);
			PreparedStatement ps = con.prepareStatement("select * from product where pname = ?");
			ps.setString(1, product );
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Product p = new Product();
				p.setPno(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setPrice(rs.getFloat(3));
				cart.add(p);
			}
			pw.println("<br><a href = 'SessionLisner.html'> add more to cart</a><br>");
			pw.println("<br><a href='ViewCart'>List items</a>");
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		
		
		
		
		
		
		
	}

}
