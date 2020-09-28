<%@page import="com.Dao.imp.Pagination_Dao"%>
<%@page import="com.controller.ConnectionClass"%>
<%@page import="com.model.AllSongsPagenation"%>

<%@page import="java.io.PrintWriter"%>

 
<%
	
if(session.getAttribute("username") != null) 
	{
		

%>
<%@page import="java.sql.*,java.util.*" %>
<!DOCTYPE html>
<%!
Connection con = ConnectionClass.getConnection();
%>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">

	$('#makeeditable').SetEditable();

</script>

</head>
<jsp:include page="UserHome.jsp"></jsp:include>

<% 
   //String title = request.getParameter("title");
    try
    {
        PreparedStatement pst = con.prepareStatement("select * from allsongspagination");
        //pst.setString(1,title);
        ResultSet res = pst.executeQuery();
       // int number = res.getInt(1);
%>
<div class="container">
		<h4 class="text-success">These are the total songs present in your App</h4>
		
        <table class="table table-hover">
        <thead>
   			 <tr>
   			 	<th scope="col">Track No</th>
      			<th scope="col">Track Name</th>
      			<th scope="col">Movie Name</th>
      			<th scope="col">Music Director</th>
      			<th scope="col">Genre</th>
      			<th scope="col">PlaySong</th>
     			
    		</tr>		
 		</thead>
 		
 
       <%
       response.setContentType("text/html");  
       PrintWriter pw=response.getWriter();  
       Scanner sc = new Scanner(System.in);
       int x = Pagination_Dao.getCount();
       int y=1,z=1;	     
       int pageid=Integer.parseInt(request.getParameter("page")); 
       int pageid2 =pageid;
       int total=5;  
       
       if(pageid==1){}  
       else{  
         pageid = pageid-1;  
         pageid=pageid*total+1;  
       }  
       List<AllSongsPagenation> list=Pagination_Dao.getRecords(pageid,total);  
 
     //  pw.print("<h1>Records from: "+pageid+"</h1>");  
    //   pw.print("<table border='1' cellpadding='4' width='60%'>");  
     //  pw.print("<tr><th>Id</th><th>Name</th><th>Salary</th>");  
       int j=pageid;
      /*  if(x%5 >0){
    	   y++;
       } */
       for(AllSongsPagenation e:list){ 
       	%>
           <tr><td><%= j %></td><td><%= e.getTitle_name() %></td><td><%= e.getAlbum_name() %></td><td><%= e.getArtist_name() %></td><td><%= e.getGenere_name() %></td>
           
           <td><audio controls>
 			 <source src="C:\Users\ks20111\Desktop\song\<%=j%>.mp3" type="audio/mpeg">
  			<%System.out.println(j); %>
  
			</audio></td>
           </tr>  
          <%  j++;%>
     <% } %>
       
      </table>  
       <a href='GetAllSongs.jsp?page=<%= z%>'><input type =button value = first></a> 
    <%  int i=1;
       while(i<(x-5)){
       	i+=5;%>
       	
       	<!--  <a href='GetAllSongs.jsp?page=<%= y%>'><%= y%></a>--> 
       	<% y++;
       	 
       }%>
       
       <%if(pageid > 1) { %>
       <a href = 'GetAllSongs.jsp?page=<%= (pageid2)-1%>'><input type =button value = previous></a>
      
       <%} %>
       
       
       
       <%if(pageid < x-1) { %>
       <a href = 'GetAllSongs.jsp?page=<%= (pageid2)+1%>'><input type =button value = next></a>
      
       <%} %>
       
      <a href='GetAllSongs.jsp?page=<%= y %>'><input type =button value = last></a> 
       
   
        </table>
   
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