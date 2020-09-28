<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.List"%>
<%@page import="com.Dao.imp.Retrive_music_Dao"%>
<%@page import="com.interfaces.Music_interface"%>
<%@page import="com.model.MusicMaster"%>
<%@page import="com.controller.ConnectionClass"%>
<%@page import="java.sql.Connection"%>
<%
Connection con = ConnectionClass.getConnection();
MusicMaster am = new MusicMaster();
Music_interface ai = new Retrive_music_Dao();
List<MusicMaster> list = ai.getInfo();
%><html><heaD><jsp:include page="Template.jsp"></jsp:include> <style type="text/css">



</style></heaD><body><% 
   String title = request.getParameter("title");
    try
    {
        PreparedStatement pst = con.prepareStatement("select music_id,album_name,title_name,artist_name,genere_name from albumtypemaster,titlemaster,artistmaster,genremaster,musicmaster where musicmaster.album_id = albumtypemaster.Album_id and musicmaster.title_id=titlemaster.title_id and musicmaster.artist_id=artistmaster.artist_id and musicmaster.genre_id=genremaster.genre_id;");
        //pst.setString(1,title);
        ResultSet res = pst.executeQuery();
       // int number = res.getInt(1);
%>
<div class="container">
		<h4 class="text-success">These are the Songs Present in your application</h4>
		
        <table class="table table-hover">
        <thead>
   			 <tr>
      			<th scope="col">Song No</th>
      			<th scope="col">Album Name</th>
      			<th scope="col">Title Name</th>
      			<th scope="col">Artist Name</th>
      			<th scope="col">Genere Name</th>
      			
     			
    		</tr>		
 		</thead>
 		
 
        <% while(res.next()){
        	int num = res.getInt(1);
        	
        	
            %>
            <tr><td><%=res.getInt(1) %></td><td><%=res.getString(2) %></td><td><%=res.getString(3) %></td><td><%=res.getString(4) %></td><td><%=res.getString(5) %></td>
            <td> <a href="SingleServlet?action=M_delete&aid=<%=res.getInt(1)%>" type="submit"><button type="submit" class="btn btn-danger">delete</button></a></td>
             <td><a href="Update_Music.jsp?aid=<%=res.getInt(1)%>"><button type="submit" class="btn btn-warning">Edit</button></a></td> </tr>
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