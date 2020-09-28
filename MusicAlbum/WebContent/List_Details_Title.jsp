<%@page import="java.util.List"%>
<%@page import="com.controller.ConnectionClass"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.Dao.imp.Retrive_Title_Dao"%>
<%@page import="com.interfaces.Title_interface"%>
<%@page import="com.model.Titlemaster"%>
<%
Connection con = ConnectionClass.getConnection();
Titlemaster tm = new Titlemaster();
Title_interface ti = new Retrive_Title_Dao();
List<Titlemaster> list = ti.getInfo();
%><html><head><jsp:include page="Template.jsp"></jsp:include><style type="text/css">



</style></head><body><div class="container">
		<h4 class="text-success">These are the Title present in the Music Album</h4>
		
        <table class="table table-hover color" bgcolor=navy>
        <thead>
   			 <tr>
      			<th scope="col">Title Id</th>
      			<th scope="col">Title Name</th>
      			
     			
    		</tr>		
 		</thead><%
for(Titlemaster a:list){
	%>
	<tr><td><%= a.getTitle_id() %></td><td><%= a.getTitle_name() %></td><td>
	<a href="SingleServlet?action=Ti_delete&aid=<%=a.getTitle_id() %>">Delete</a></td>
	<td><a href="Update_Title_values.jsp?aid=<%=a.getTitle_id() %>">update</a></td></tr>
<%}%></table></body></html>