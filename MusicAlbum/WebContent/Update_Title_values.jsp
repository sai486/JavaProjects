<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.controller.ConnectionClass"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.Dao.imp.Update_Title_Dao"%>
<%@page import="com.interfaces.Title_interface"%>
<%@page import="com.model.Titlemaster"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Template.jsp"></jsp:include>e>
</head>
<body>
<form action="SingleServlet">
<input type = "hidden" name = action value = Ti_update>
<table border=2 cellpadding =10px align = center >
<%
Connection con = ConnectionClass.getConnection();
Titlemaster tm = new Titlemaster();
Title_interface ti = new Update_Title_Dao();

int aname = Integer.parseInt(request.getParameter("aid"));
PreparedStatement ps = con.prepareStatement("select * from titlemaster where title_id = ?");
ps.setInt(1,aname);
ResultSet rs = ps.executeQuery();
while(rs.next()){
%><tr><td>Title_id</td><td><input type = text name = aid value =<%=rs.getInt(1) %> readonly></td></tr>
<tr><td>Title_name</td><td><input type = text name = aname value =<%=rs.getString(2) %> ></td></tr>

<tr><td colspan = 2 align = center><input type = submit value = submt></td>
<%} %>

</table>
</form>
</body>
</html>