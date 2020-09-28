<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.Dao.imp.UpdateAlbumDao"%>
<%@page import="com.Ser_classes.*"%>
<%@page import="java.util.List"%>
<%@page import="com.Dao.imp.RetriveAlbumDao"%>
<%@page import="com.interfaces.Album_interface"%>
<%@page import="com.model.AlbumtypeMaster"%>
<%@page import="com.controller.ConnectionClass"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Template.jsp"></jsp:include>
</head>
<body>
<form action="SingleServlet">
<input type = "hidden" name = action value = update>
<table border=2  cellpading =10px align = center>
<%
Connection con = ConnectionClass.getConnection();
AlbumtypeMaster am = new AlbumtypeMaster();
Album_interface ai = new RetriveAlbumDao();
Album_interface a = new UpdateAlbumDao();
int aname = Integer.parseInt(request.getParameter("aid"));
PreparedStatement ps = con.prepareStatement("select * from albumtypemaster where album_id = ?");
ps.setInt(1,aname);
ResultSet rs = ps.executeQuery();
while(rs.next()){
%><tr><td>Album_id</td><td><input type = text name = aid value =<%=rs.getInt(1) %> readonly></td></tr>
<tr><td>Album_name</td><td><input type = text name = aname value =<%=rs.getString(2) %> ></td></tr>
<tr><td>Album_year</td><td><input type = text name = ayear value =<%=rs.getInt(3) %>></td></tr>
<tr><td colspan = 2 align = center><input type = submit value = submt></td>
<%} %>

</table>
</form>
</body>
</html>