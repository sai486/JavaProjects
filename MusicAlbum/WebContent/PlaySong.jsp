<%@page import="com.controller.ConnectionClass"%>
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
              con = ConnectionClass.getConnection();
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<% 
   int titleno = Integer.parseInt(request.getParameter("no"));
    try
    {
        PreparedStatement pst = con.prepareStatement("select * from titlemaster where title_id = (select title_id from musicmaster where music_id = "+titleno+")");
        //pst.setString(1,title);
        ResultSet res = pst.executeQuery();
       // int number = res.getInt(1);
%>
<title>Albums</title>
<jsp:include page="UserHome.jsp"></jsp:include>
<div class="container">
<table class="table table-hover">
        
 		
 		
 		
 		 <% while(res.next()){
        	
        	
        	
            %>
            <tr>
            	<% System.out.println(res.getString(1));%>
            	The Song Playing is : <td><%=res.getString(2) %></td>
            	            
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