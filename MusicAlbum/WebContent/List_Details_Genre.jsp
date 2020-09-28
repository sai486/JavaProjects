<%@page import="java.util.List"%>
<%@page import="com.Dao.imp.Retrive_Genre_Dao"%>
<%@page import="com.interfaces.Genre_interface"%>
<%@page import="com.model.Genremaster"%>
<%@page import="com.controller.ConnectionClass"%>
<%@page import="java.sql.Connection"%>
<%
Connection con = ConnectionClass.getConnection();
Genremaster am = new Genremaster();
Genre_interface ai = new Retrive_Genre_Dao();
List<Genremaster> list = ai.getInfo();
%><html><head><jsp:include page="Template.jsp"></jsp:include>clude> <style type="text/css">



</style></head><body>
<div class="container">
		<h4 class="text-success">These are the Genres present in the Music Album</h4>
		
        <table class="table table-hover color" bgcolor=navy>
        <thead>
   			 <tr>
      			<th scope="col">Genre Id</th>
      			<th scope="col">Genre Name</th>
      			
     			
    		</tr>		
 		</thead><%
for(Genremaster a:list){
	%>
	<tr><td><%= a.getGenre_id() %></td><td><%= a.getGenere_name() %></td><td>
	<a href="SingleServlet?action=Gne_delete&aid=<%=a.getGenre_id() %>">Delete</a></td>
	<td><a href="Update_Genre_values.jsp?aid=<%=a.getGenre_id() %>">update</a></td></tr>
<%}%></table></body></html>