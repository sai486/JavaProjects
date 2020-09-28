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
        System.out.println("Connected successfully " + con);
        
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}
       
%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
<head>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">

	$('#makeeditable').SetEditable();

</script>


</head>
<jsp:include page="Template.jsp"></jsp:include>
<% 
   
    try
    {
        PreparedStatement pst = con.prepareStatement("select * from albumtypemaster");
       
        ResultSet res = pst.executeQuery();
      
%>
<div class="container">
		<h4 class="text-success">These are the total albums present in your App</h4>
		
        <table class="table table-hover">
        <thead>
   			 <tr>
      			<th scope="col">Album No</th>
      			<th scope="col">Album Name</th>
      			<th scope="col">Recorded Year</th>
     			
    		</tr>		
 		</thead>
 		
 
        <% while(res.next()){
        	int num = res.getInt(1);
        	
        	
            %>
            <tr><td><%=res.getInt(1) %></td><td><%=res.getString(2) %></td><td><%=res.getInt(3) %></td>
            <td> <a href="SingleServlet?action=delete&aid=<%=res.getInt(1)%>" type="submit"><button type="submit" class="btn btn-danger">delete</button></a></td>
             <td><a href="Update_Album_values.jsp?aid=<%=res.getInt(1)%>"><button type="submit" class="btn btn-warning">Edit</button></a></td> </tr>
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