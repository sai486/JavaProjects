<%@page import="com.controller.ConnectionClass"%>
<%
	
if(session.getAttribute("username") != null) 
	{
		

%>
<%@page import = "java.sql.*,java.util.*"%>
<%!
Connection con = null;

TreeMap<Integer,String> moviename = new TreeMap<Integer,String>();

public void jspInit() {
	
	try {
		
		con = ConnectionClass.getConnection();	
	}
	
	catch (Exception e) {
		System.out.println(e);
	}	
}
%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<jsp:include page="Template.jsp"></jsp:include>
<% 
   
    try
    {
        PreparedStatement pst = con.prepareStatement("select album_id,album_name from albumtypemaster");
        
        ResultSet res = pst.executeQuery();
        while(res.next()) {
        	moviename.put(res.getInt(1), res.getString(2));
        }
       
    }catch(Exception e) {
    	System.out.println(e);
    }

%>

<body>
<div class="container">
      <div class="row">
      	<div class="col-md-2"></div>
      	<form action="GetTotalAlbumDetails.jsp" method="post">
			 			 
			 <!-- Drop Down For Albums -->
			 
			 <div class="col-md-2">
          			<div class="form-group">
  						<label for="sel1">Select Album:</label>
  						<select class="form-control" id="sel1" name="albumname">
    						<%Set set = moviename.entrySet();
    						Iterator itr1 = set.iterator();
    							while(itr1.hasNext()) {
    								Map.Entry l = (Map.Entry)itr1.next();%>
								<option value=<%=l.getKey() %>><%=l.getValue() %></option><%} %>
  						</select>
					</div>
        		</div>
        		<button type="submit" class="btn btn-success">Get Album</button>
        	</form>
        	</div>
        </div>

<%}
else {
	response.sendRedirect("./LoginForm.html");}%>