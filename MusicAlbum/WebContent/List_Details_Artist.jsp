<%@page import="java.util.List"%>
<%@page import="com.Dao.imp.Retrive_Artist_Dao"%>
<%@page import="com.interfaces.Artist_interface"%>
<%@page import="com.model.ArtistMaster"%>
<%@page import="com.controller.ConnectionClass"%>
<%@page import="java.sql.Connection"%>
<%
Connection con = ConnectionClass.getConnection();
ArtistMaster am = new ArtistMaster();
Artist_interface ai = new Retrive_Artist_Dao();
List<ArtistMaster> list = ai.getInfo();
%><html><head><jsp:include page="Template.jsp"></jsp:include> <style type="text/css">



</style></head><body>
<div class="container">
		<h4 class="text">These people are Artists from different Professions</h4>
		
        <table class="table table-hover color" bgcolor=navy>
        <thead>
   			 <tr>
      			<th scope="col">Artist Id</th>
      			<th scope="col">Artist Name</th>
      			<th scope="col">Profession</th>
     			
    		</tr>		
 		</thead><%
for(ArtistMaster a:list){
	%>
	<tr><td><%= a.getArtist_id() %></td><td><%= a.getArtist_name() %></td><td><%= a.getProfession() %></td><td>
	<a href="SingleServlet?action=Art_delete&aid=<%=a.getArtist_id() %>">Delete</a></td>
	<td><a href="Update_Album_values.jsp?aid=<%=a.getArtist_id() %>">update</a></td></tr>
<%}%></table></body></html>