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
<title>Insert title here</title>
</head>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>


<body>

<jsp:include page="Template.jsp"></jsp:include>
	<div class="container">
		<form action="SingleServlet" method="post">
			 <input type="hidden" name ="action" value="registeradmin">
 				 <div class="form-group col-xs-4">  
    				<label for="formGroupExampleInput">Enter Admin Name</label>
    				<input type="text" class="form-control" id="formGroupExampleInput" placeholder="Admin Name" name="adminname">
  				</div>
  				<div class="form-group col-xs-4">
    				<label for="formGroupExampleInput2">Enter his email</label>
    				<input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Admin Email" name="adminemail">
 				 </div><br>
  				<div class="form-group col-xs-4">
  					<button class="btn btn-primary" type="submit">Add Album</button>
  				</div>
  				
		</form>
	</div>
</body>
</html>
<%}
else {
	response.sendRedirect("./LoginForm.html");}%>