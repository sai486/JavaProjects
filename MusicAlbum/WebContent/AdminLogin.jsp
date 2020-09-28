<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Log-In</title>
</head>
<body>    
    <div class="container">
        <div class="row">            
                <div class="container">
                        <div class="jumbotron jumbotron-fluid" style="background-image: url(./3.jpg); background-size: 100%;"> 
                             <h1 class="display-4" style="color: aliceblue;">
                                 Ojas Music Album
                                </h1>
                             <p class="lead">
                                 
                            </p>
                        </div>
                </div>
            </div>
             <div class="col-lg-6">
                <div class="loginbox">
                    <h1>Admin Login</h1><br>

                    <form action="SingleServlet" method="post">
			 		<input type="hidden" name ="action" value="logintoadmin">
                    <div class="form-group row">
                        <label for="inputEmail" class="col-sm-2 col-form-label">User Name</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmail" placeholder="User Name" name="aname" required="required">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="apass" required="required">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10 offset-sm-2">
                            <label class="form-check-label"><input type="checkbox"> Remember me</label>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10 offset-sm-2">
                            <button type="submit" class="btn btn-primary">Sign in</button>
                        </div>
                    </div>
                </form>
                New Admin For Setting your password <a href="SetPassword.jsp">Click Here</a>
                </div>
             </div>