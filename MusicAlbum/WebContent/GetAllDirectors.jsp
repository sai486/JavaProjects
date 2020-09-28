<%
	
if(session.getAttribute("username") != null) 
	{
		

%>
<%@page import="java.sql.*,java.util.*" %>
<!DOCTYPE html>


<%!
        Connection con = null;
        public void jspInit()
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicalbum","root","root");
                System.out.println("Connected successfully " + con);
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
<% 
   String title = request.getParameter("title");
    try
    {
        PreparedStatement pst = con.prepareStatement("select * from artistmaster");
        //pst.setString(1,title);
        ResultSet res = pst.executeQuery();
       // int number = res.getInt(1);
%>


<title>Albums</title>
<jsp:include page="./UserHome.jsp"></jsp:include>
<div class="container">
<table class="table table-hover">
        <thead>
   			 <tr>
      			<th scope="col">Musician Number</th>
      			<th scope="col">Music Director Name</th>
      			
     			
    		</tr>		
 		</thead>
 		
 		
 		<%int i = 1; %>
 		 <% while(res.next()){
        	
        	
        	
            %>
            <tr>
            	<td><%=i %></td>
            	
            	<td><a href="GetEachArtistDetails.jsp?no=<%=res.getInt(1) %>"><%=res.getString(2) %></a></td>
            	           
                     <% i++;}%>
        </table>
   </form>
</div>
    <% }
    catch(Exception e)
    {
        System.out.println(e);
    }
%>
<%}
else {
	response.sendRedirect("./LoginForm.html");}%>