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

<head>
<title>Artist-Details</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">

	$('#makeeditable').SetEditable();

</script>

</head>
<jsp:include page="Template.jsp"></jsp:include>
<% 
   String title = request.getParameter("title");
    try
    {
        PreparedStatement pst = con.prepareStatement("select * from titlemaster");
        //pst.setString(1,title);
        ResultSet res = pst.executeQuery();
       // int number = res.getInt(1);
%>
<div class="container">
		<h4 class="text-success">These are the Titles present in the Music Album</h4>
		
        <table class="table table-hover">
        <thead>
   			 <tr>
      			<th scope="col">Title Id</th>
      			<th scope="col">Title Name</th>
      			
     			
    		</tr>		
 		</thead>
 		
 
        <% while(res.next()){
        	int num = res.getInt(1);
        	
        	
            %>
            <tr><td><%=res.getInt(1) %></td><td><%=res.getString(2) %></td>
            <td> <a href="MainController?action=titletypemasterdelete&no=<%=res.getInt(1)%>" type="submit"><button type="submit" class="btn btn-danger">delete</button></a></td>
             <td><a href="TitleTypeMasterupdateTitle.jsp?no=<%=res.getInt(1)%>"><button type="submit" class="btn btn-warning">Edit</button></a></td> </tr>
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