<%@page import="java.sql.CallableStatement"%>
<%@page import="java.util.*"%>
<%
	
if(session.getAttribute("username") != null) 
	{
		

%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.controller.ConnectionClass"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
    <%!
    Connection con = null;
    TreeMap<Integer,String> album = new TreeMap<Integer,String>();
    TreeMap<Integer,String> title = new TreeMap<Integer,String>();
    TreeMap<Integer,String> artist = new TreeMap<Integer,String>();
    TreeMap<Integer,String> genre = new TreeMap<Integer,String>();
    
    
    public void jspInit() {
    	
    	try {
    		
    		
    		con = ConnectionClass.getConnection();    	  		
    		
    		CallableStatement cs = con.prepareCall("{call allnames2()}");
    		
    		ResultSet rs1 = cs.executeQuery();
    		
    		/*This is for Album Map*/
    		
    		while(rs1.next()) {
    			album.put(rs1.getInt(1), rs1.getString(2));
    		}
    		rs1.close();
    		
    		
    		/*This is for Title Map*/
    		
    		
    		boolean isResultSet = cs.getMoreResults();
    		if (!isResultSet) {
    	        System.out.println("there is no  ResultSet.");
    	        return;
    	      }	
    		rs1 = cs.getResultSet();
    		while(rs1.next()) {
    			title.put(rs1.getInt(1), rs1.getString(2));
    		}
    		rs1.close();
    		
    		/*This is for artist Map*/
    		
    		isResultSet = cs.getMoreResults();
    				
    		if (!isResultSet) {
    	        System.out.println("The next result is not a ResultSet.");
    	        return;
    	      }	
    		rs1 = cs.getResultSet();
    		while(rs1.next()) {
    			artist.put(rs1.getInt(1), rs1.getString(2));
    		}
    		rs1.close();
    		
    		/*This is for genre Map*/
    		
    		isResultSet = cs.getMoreResults();
    				
    		if (!isResultSet) {
    	        System.out.println("The next result is not a ResultSet.");
    	        return;
    	      }	
    		rs1 = cs.getResultSet();
    		while(rs1.next()) {
    			genre.put(rs1.getInt(1), rs1.getString(2));
    		}
    		rs1.close();
    		
    	}
    	
    	catch (Exception e) {
    		System.out.println(e);
    	}	
    	
    
    	
    }
    
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Template.jsp"></jsp:include>
</head>
<body>
<div class="container">
      <div class="row">
      	<div class="col-md-2"></div>
      	<form action="SingleServlet" method="post">
			 <input type="hidden" name ="action" value="M_insert">
			 
			 
			 <!-- Drop Down For Albums -->
			 
			 <div class="col-md-2">
          			<div class="form-group">
  						<label for="sel1">Select Album:</label>
  						<select class="form-control" id="sel1" name="album">
    						<%Set set = album.entrySet();
    						Iterator itr1 = set.iterator();
    							while(itr1.hasNext()) {
    								Map.Entry l = (Map.Entry)itr1.next();%>
								<option value=<%=l.getKey() %>><%=l.getValue() %></option><%} %>
  						</select>
					</div>
        		</div>	 	
        		
        		
        		<!-- Drop Down For Titles -->

       			<div class="col-md-2">
          			<div class="form-group">
  						<label for="sel1">Select Title:</label>
  						<select class="form-control" name="title">
  						<%Set set1 = title.entrySet();
  						Iterator itr2 = set1.iterator();
    							while(itr2.hasNext()) {
    							Map.Entry l1 = (Map.Entry)itr2.next();%>
								<option value=<%=l1.getKey() %>><%=l1.getValue() %></option><%} %>
    						
  						</select>
					</div>
        		</div>
        		
        		
        		<!-- Drop Down for Artist -->
        		
        		<div class="col-md-2">
          			<div class="form-group">
  						<label for="sel1">Select Artist:</label>
  						<select class="form-control" name="artist">
  						<%Set set2 = artist.entrySet();
  						Iterator itr3 = set2.iterator();
    							while(itr3.hasNext()) {
    							Map.Entry l2 = (Map.Entry)itr3.next();%>
								<option value=<%=l2.getKey() %>><%=l2.getValue() %></option><%} %>
    						
  						</select>
					</div>
        		</div>
        		
        		
        		<!-- Drop Down for Genre -->
        		
        		<div class="col-md-2">
          			<div class="form-group">
  						<label for="sel1">Select Genre:</label>
  						<select class="form-control" name="genre">
  						<%Set set3 = genre.entrySet();
  						Iterator itr4 = set3.iterator();
    							while(itr4.hasNext()) {
    							Map.Entry l3 = (Map.Entry)itr4.next();%>
								<option value=<%=l3.getKey() %>><%=l3.getValue() %></option><%} %>
    						
  						</select>
					</div>
        		</div>
        		
        		
        		
        		<br><button type="submit" class="btn btn-success">Add Music</button>
        		  		
        </form>        
    </div>
</div>
</body>
</html>
<%}
else {
	response.sendRedirect("./LoginForm.html");}%>