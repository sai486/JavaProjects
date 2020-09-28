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

<% 
   int titlenumber = Integer.parseInt(request.getParameter("no"));
   Blob img = null;
   byte[] imgdata = null;
    try
    {
        PreparedStatement pst = con.prepareStatement("select music_id,album_name,title_name,artist_name,artistpic,profession,genere_name from musicmaster,albumtypemaster,titlemaster,genremaster,artistmaster where musicmaster.album_id = albumtypemaster.album_id and musicmaster.title_id = titlemaster.title_id and musicmaster.artist_id = artistmaster.artist_id and musicmaster.genre_id = genremaster.genre_id and musicmaster.music_id in (select music_id from musicmaster where artist_id = "+titlenumber+")");

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
 		
 		<span id="key">Musician Name :</sapan> <span id="title"><%=res.getString(4) %></span><br>
 		<span id="key">Profession : </sapan> <span id="title"><%=res.getString(6) %></span></a><br>
 		
 		<% InputStream in = res.getBinaryStream(5);
 	                FileOutputStream fos = new FileOutputStream("E:\\charan\\charan\\art.jpg");
 	                byte size[] = new byte[23745354];
 	                int bytes=0;
 	                while((bytes=in.read(size))!=-1){
 	                    fos.write(size,0,bytes);
 	                }%>
 	     <div id="photo">           
 	     	<img style="float: right" src = "E:\\charan\\charan\\art.jpg" alt= "wait the image in comming" height="180" width="150">
 		 </div>
 		
 		<%j++;}%>
 		<!--  <div style="width: 20px;height: 30px;" align="right">
 			<%
 			      
 	            //PreparedStatement ps = con.prepareStatement("select * from product where pid = ?");
 	            //ps.setInt(1, Integer.parseInt(request.getParameter("pid")));
 	           
 	           // ResultSet rs =  ps.executeQuery();
 	            //String name = null;
 	            //if(rs.next()){
 	               
 	               // name = rs.getString(1);
 	                
 	            
 	          
 	            
 			%>
 		
 		</div>-->
 		<br><br><br><br><br><br><br>
        <thead>
   			 <tr>
      			<th scope="col">Album Name</th>
      			<th scope="col">Movie Name</th>
      			<th scope="col">Track Name</th>
      			<th scope="col">Genre Name</th>
      			
     			
    		</tr>		
 		</thead>
 		<%if(res.first()) {  %>
 		<%int i = 1; 
        PreparedStatement pst1 = con.prepareStatement("select music_id,album_name,title_name,artist_name,artistpic,profession,genere_name from musicmaster,albumtypemaster,titlemaster,genremaster,artistmaster where musicmaster.album_id = albumtypemaster.album_id and musicmaster.title_id = titlemaster.title_id and musicmaster.artist_id = artistmaster.artist_id and musicmaster.genre_id = genremaster.genre_id and musicmaster.music_id in (select music_id from musicmaster where artist_id = "+titlenumber+")");

 		ResultSet rs = pst1.executeQuery();
 		%>
 		 <% while(rs.next()){
        	
        	
        	
            %>
            <tr>
            	<td><%=i %></td>
            	<td><%=rs.getString(2) %></td>
            	<td ><a href="PlaySong.jsp?no=<%=rs.getInt(1) %>"><%=rs.getString(3) %></a></td>
            	<td><%=res.getString(7) %></td></tr>
            	            
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