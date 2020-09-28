<%@page import="java.util.*"%>
<%@page import="com.model.AlbumtypeMaster"%>
<%@page import="com.Dao.imp.RetriveAlbumDao"%>
<%@page import="com.interfaces.Album_interface"%>
<%@page import="com.controller.ConnectionClass"%>
<%@page import="java.sql.*"%>
<%
Connection con = ConnectionClass.getConnection();
AlbumtypeMaster am = new AlbumtypeMaster();
Album_interface ai = new RetriveAlbumDao();
List<AlbumtypeMaster> list = ai.getInfo();
%><html><head><jsp:include page="Template.jsp"></jsp:include> <style type="text/css">



</style></head><body ><div class="container">
		<h4 class="text">These are the total albums present in your App</h4>
		
        <table class="table table-hover color" bgcolor=navy>
        <thead>
   			 <tr>
      			<th scope="col">Album No</th>
      			<th scope="col">Album Name</th>
      			<th scope="col">Recorded Year</th>
     			
    		</tr>		
 		</thead><%
for(AlbumtypeMaster a:list){
	%>
	<tr><td><%= a.getAlbum_id() %></td><td><%= a.getAlbum_name() %></td><td><%= a.getYear() %></td><td>
	<a href="SingleServlet?action=delete&aid=<%=a.getAlbum_id() %>">Delete</a></td>
	<td><a href="Update_Album_values.jsp?aid=<%=a.getAlbum_id() %>">update</a></td></tr>
<%}%></table></div></body></html>
