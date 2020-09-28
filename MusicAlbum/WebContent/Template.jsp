<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	
if(session.getAttribute("username") != null) 
	{
		

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Album-Details</title>
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 	
 	<style type="text/css">
	body{
	background-image: url("./mus.jpg") ;
	
	
	}</style>
</head>


<body >

<div class="container">
    <nav class="navbar navbar-inverse bg-primary">  
    	<div class="navbar-header">
      		<a class="navbar-brand" href="#">Ojas Music Album</a>
    	</div>
    	<ul class="nav navbar-nav">
      		<li class="active"><a href="TEMHOME.jsp">Home</a></li>
      		<li class="dropdown">
        		<a class="dropdown-toggle" data-toggle="dropdown" href="#">Album<span class="caret"></span></a>
        			<ul class="dropdown-menu">
          				<li><a href="Insert_Album.jsp">Add Album</a></li>
          				<li><a href="List_Details_Album.jsp">List Albums</a></li>
        			</ul>
      		</li>      
      		<li class="dropdown">
      			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Artist<span class="caret"></span></a>
      				<ul class="dropdown-menu">
          				<li><a href="Insertion_Artist.jsp">Add Artist</a></li>
          				<li><a href="List_Details_Artist.jsp">List Artist</a></li>
        			</ul>      		
      		</li>
      		<li class="dropdown">
      			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Genre<span class="caret"></span></a>
      				<ul class="dropdown-menu">
          				<li><a href="Insert_Genre.jsp">Add genre</a></li>
          				<li><a href="List_Details_Genre.jsp">List genre</a></li>
        			</ul>      		
      		</li>
      		<li class="dropdown">
      			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Title<span class="caret"></span></a>
      				<ul class="dropdown-menu">
          				<li><a href="Insert_Title.jsp">Add Title</a></li>
          				<li><a href="List_Details_Title.jsp">List Titles</a></li>
        			</ul>      		
      		</li>
      		<li class="dropdown">
      			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Music<span class="caret"></span></a>
      				<ul class="dropdown-menu">
          				<li><a href="Insert_Music.jsp">Add Music</a></li>
          				<li><a href="List_Details_Music.jsp">List Music</a></li>
        			</ul>      		
      		</li>
      		<li class="dropdown">
      			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin<span class="caret"></span></a>
      				<ul class="dropdown-menu">
          				<li><a href="AddAdmin.jsp">Add New Admin</a></li>
          				
        			</ul>      		
      		</li>
      		
      		<li class="dropdown">
      			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Welcome <%=session.getAttribute("username").toString().toUpperCase() %> <span class="caret"></span></a>
      				<ul class="dropdown-menu">
          				<li class="dropdown">
      						<form action="SingleServlet" method="post">
			 					<input type="hidden" name ="action" value="adminlogout">
        						<input type="submit" value="Log-Out">
        					</form>   		
      					</li>          				
        			</ul>
       		</li>
      		
      		
      		
    	</ul>  
	</nav>    
</div>

</body>

</html>
<%}
else {
	response.sendRedirect("./LoginForm.html");}%>