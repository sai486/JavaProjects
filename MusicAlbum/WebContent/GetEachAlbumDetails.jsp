<%@page import="com.controller.ConnectionClass"%>

<%
	
if(session.getAttribute("username") != null) 
	{
		

%>
<%@page import="java.sql.*,java.util.*,java.io.*"%>
<!DOCTYPE html>
<<html>

<head>

<style type="text/css">

#photo {

 position: absolute;
  top: 80px;
  right: 250px;
  width: 200px;
  height: 1000px;
  

}



</style>

</head>

</html>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>



<% 
Connection con = ConnectionClass.getConnection();
   int albumnumber = Integer.parseInt(request.getParameter("no"));
   
    try
    {
        PreparedStatement pst = con.prepareStatement("select music_id,album_name,albumpic,title_name,artist_name,genere_name from artistmaster,genremaster,titlemaster,musicmaster,albumtypemaster where musicmaster.album_id = albumtypemaster.album_id and musicmaster.title_id = titlemaster.title_id and musicmaster.artist_id = artistmaster.artist_id and musicmaster.genre_id = genremaster.genre_id and musicmaster.music_id in (select music_id from musicmaster where album_id = "+albumnumber+")");

        //pst.setString(1,title);
        ResultSet res = pst.executeQuery();
       // int number = res.getInt(1);
%>
<title>Albums</title>
<jsp:include page="./UserHome.jsp"></jsp:include>
<div class="container">
<table class="table table-hover">
<%int j = 0;%>
 		<%while (res.next() && j<1) {%>
 		
 		<span id="key">Album Name :</sapan> <span id="title"><%=res.getString(2) %></span><br>
 		<span id="key">Music Organiser :</sapan> <span id="title"><a href="musiciandetails.jsp?no=<%=res.getInt(1) %>"><%=res.getString(5) %></span></a><br>
 		<span id="key">Genre Type :</sapan> <span id="title"><%=res.getString(6) %></sapan><br>
 		<% InputStream in = res.getBinaryStream(3);
 	                FileOutputStream fos = new FileOutputStream("C:\\Users\\ks20111\\Desktop\\albumpic\\pic.jpg");
 	                byte size[] = new byte[23745354];
 	                int bytes=0;
 	                while((bytes=in.read(size))!=-1){
 	                    fos.write(size,0,bytes);
 	                }%>
 	     <div id="photo">           
 	     	<img style="float: right" src = "C:\\Users\\ks20111\\Desktop\\albumpic\\pic.jpg" alt = "wait image is coming" height="180" width="150">
 		 </div>
 		
 		<%j++;}%>
 		<!--  <div style="width: 20px;height: 30px;" align="right">
 			
 		
 		</div>-->
 		<br><br><br><br><br>
        <thead>
   			 <tr>
      			<th scope="col">Track No</th>
      			<th scope="col">Track Name</th>
      			
     			
    		</tr>		
 		</thead>
 		<!--  <%if(res.first()) {  %> -->
 		<%int i = 1;
 		
 		PreparedStatement pst1 = con.prepareStatement("select music_id,album_name,albumpic,title_name,artist_name,genere_name from artistmaster,genremaster,titlemaster,musicmaster,albumtypemaster where musicmaster.album_id = albumtypemaster.album_id and musicmaster.title_id = titlemaster.title_id and musicmaster.artist_id = artistmaster.artist_id and musicmaster.genre_id = genremaster.genre_id and musicmaster.music_id in (select music_id from musicmaster where album_id = "+albumnumber+")");

 		ResultSet rs = pst1.executeQuery();
 		
 		%>
 		 <% while(rs.next()){
        	
        	
        	
            %>
            <tr>
            	<td><%=i %></td>
            	<td ><a href="PlaySong.jsp?no=<%=rs.getInt(1) %>"><%=rs.getString(4) %></a></td></tr>
            	            
                     <% i++;}}%>
                 
                
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