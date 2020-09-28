<%
	
if(session.getAttribute("username") != null) 
	{
		

%>
<%@page import="java.sql.*,java.util.*" %>
<!DOCTYPE html>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
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


<% 
   int artistdetails = Integer.parseInt(request.getParameter("no"));
    try
    {
        PreparedStatement pst = con.prepareStatement("select * from artistmaster where artist_id = (select artist_id from musicmaster where music_id = "+artistdetails+");");
        //pst.setString(1,title);
        ResultSet res = pst.executeQuery();
       // int number = res.getInt(1);
%>
<title>Albums</title>
<jsp:include page="./UserHome.jsp"></jsp:include>
<div class="container">
<table class="table table-hover">
        
 		
 		
 		
 		 <% while(res.next()){
        	
        	
        	
            %>
            <tr>
            	
            	The Artist Name is : <td><%=res.getString(2) %></td>
            	His Profession is <td><%=res.getString(3) %></td>
            	            
                     <% }%>
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