<%
	
if(session.getAttribute("username") != null) 
	{
		

%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Album-Details</title>
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 	<link rel="stylesheet" type="text/css" href="SideNavBar.css">
 	
 	<style type="text/css">
	body{
	background-image: url("./mus.jpg");
	background-repeat: repeat-x;
	background-size: auto;
	}</style>
 	
 	
</head>


<body>
<%

	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
	

%>

<div class="container">
    <nav class="navbar navbar-inverse ">  
    	<div class="navbar-header">
      		<a class="navbar-brand" href="#">Ojas Music Album</a>
    	</div>
    	<ul class="nav navbar-nav">
      		<li class="active"><a href="#">Home</a></li>
      		<li class="dropdown">
        		<a class="dropdown-toggle" href="GetAllAlbums.jsp">Show Albums</a>
        	</li> 
        	<li class="dropdown">
        		<a class="dropdown-toggle" href="GetAllDirectors.jsp">Musicans</a>
        	</li>      	
        	<li class="dropdown">
        	<form action ="GetAllSongs.jsp" >
        	<input type = hidden name = page value =1>
        		<a class="dropdown-toggle"><input type = submit value ="All Songs"></a>
        		
        		</form>
        	</li>
        	
        	<li class="dropdown">
        		<a class="dropdown-toggle" href="GetAllSongs.jsp">Welcome :  <%=session.getAttribute("username").toString().toUpperCase() %></a>
        		<ul class="dropdown-menu">
          				
          				<li><a href="ShowPlayList.jsp">Show PlayList</a></li>
        			</ul>
        	</li> 
        	<li class="dropdown">
        		<form action="SingleServlet" method="post">
			 		<input type="hidden" name ="action" value="userlogout">
        			<input type="submit" value="Log-Out">
        		</form>
        	</li> 
    	</ul>  
	</nav>    
</div>

</body>

</html>
<%}
else {
	response.sendRedirect("./LoginForm.html");}%>