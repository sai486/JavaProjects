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
			background-image: url("C:\\Users\\ks20111\\Desktop\\2.jpg");
			
			font-weight: 100;
			font-size: medium;
		}

	</style>
 	
</head>
<body >
<div >
    <nav class="navbar navbar-inverse">  
    	<div class="navbar-header">
    		<img src=""></img>
      		<a class="navbar-brand" href="#">MusicAlbum</a>
    	</div>
    	<ul class="nav navbar-nav">
      		<li class="active"><a href="#">Home</a></li>
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
          				<li><a href="Insertion_Atrist.jsp">Add Artist</a></li>
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
          				<li><a href="List_Details_Title.jsp">List Title</a></li>
        			</ul>
        			</li>
        			<li class="dropdown">
      			<a class="dropdown-toggle" data-toggle="dropdown" href="#">music<span class="caret"></span></a>
      				<ul class="dropdown-menu">
          				<li><a href="Insert_Music.jsp">Add Music</a></li>
          				<li><a href="List_Details_Music.jsp">List Music</a></li>
        			</ul>
        			</li>
    	</ul>  
	</nav>    
</div>

</body>
</html>