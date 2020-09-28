<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.Dao.imp.Update_Atrist_Dao"%>
<%@page import="com.Dao.imp.Retrive_Artist_Dao"%>
<%@page import="com.interfaces.Artist_interface"%>
<%@page import="com.model.ArtistMaster"%>
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
<input type = "hidden" name = action value = Art_update>
<table border=2  cellpading =10px align = center>
<%
Connection con = ConnectionClass.getConnection();
ArtistMaster am = new ArtistMaster();
Artist_interface ai = new Update_Atrist_Dao();

int aname = Integer.parseInt(request.getParameter("aid"));
PreparedStatement ps = con.prepareStatement("select * from artistmaster where artist_id = ?");
ps.setInt(1,aname);
ResultSet rs = ps.executeQuery();
while(rs.next()){
%><tr><td>Artist_id</td><td><input type = text name = aid value =<%=rs.getInt(1) %> readonly></td></tr>
<tr><td>Artist_name</td><td><input type = text name = aname value =<%=rs.getString(2) %> ></td></tr>
<tr><td>Artist_profession</td><td><input type = text name = profession value =<%=rs.getString(3) %>></td></tr>
<tr><td colspan = 2 align = center><input type = submit value = submt></td>
<%} %>

</table>
</form>
</body>
</html>