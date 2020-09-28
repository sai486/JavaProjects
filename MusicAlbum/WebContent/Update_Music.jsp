<%@page import="com.controller.ConnectionClass"%>
<%
	
if(session.getAttribute("username") != null) 
	{
		

%>
<%@page import="java.sql.*,java.util.*" %>

<!DOCTYPE html>

<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<%!
TreeMap<Integer,String> album = new TreeMap<Integer,String>();
TreeMap<Integer,String> title = new TreeMap<Integer,String>();
TreeMap<Integer,String> artist = new TreeMap<Integer,String>();
TreeMap<Integer,String> genre = new TreeMap<Integer,String>();

        Connection con = null;
        public void jspInit()
        {
            try
            {
                con = ConnectionClass.getConnection();
                
                CallableStatement calst1 = con.prepareCall("{call allnames2()}");
        		
        		ResultSet rs2 = calst1.executeQuery();
        		
        		/*This is for Album Map*/
        		
        		while(rs2.next()) {
        			album.put(rs2.getInt(1), rs2.getString(2));
        		}
        		rs2.close();
        		
        		
        		/*This is for Title Map*/
        		
        		
        		boolean isResultSet = calst1.getMoreResults();
        		if (!isResultSet) {
        	        System.out.println("The next result is not a ResultSet.");
        	        return;
        	      }	
        		rs2 = calst1.getResultSet();
        		while(rs2.next()) {
        			title.put(rs2.getInt(1), rs2.getString(2));
        		}
        		rs2.close();
        		
        		/*This is for artist Map*/
        		
        		isResultSet = calst1.getMoreResults();
        				
        		if (!isResultSet) {
        	        System.out.println("The next result is not a ResultSet.");
        	        return;
        	      }	
        		rs2 = calst1.getResultSet();
        		while(rs2.next()) {
        			artist.put(rs2.getInt(1), rs2.getString(2));
        		}
        		rs2.close();
        		
        		/*This is for genre Map*/
        		
        		isResultSet = calst1.getMoreResults();
        				
        		if (!isResultSet) {
        	        System.out.println("The next result is not a ResultSet.");
        	        return;
        	      }	
        		rs2 = calst1.getResultSet();
        		while(rs2.next()) {
        			genre.put(rs2.getInt(1), rs2.getString(2));
        		}
        		rs2.close();
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
%>
<%! %>
<jsp:include page="Template.jsp"></jsp:include>

<body>
<%int number = Integer.parseInt(request.getParameter("no")); 

try {
	
	PreparedStatement pst = con.prepareStatement("select music_id,album_name,title_name,artist_name,genere_name from albumtypemaster,titlemaster,artistmaster,genremaster,musicmaster where music_id = "+number+" and musicmaster.album_id = albumtypemaster.album_id and musicmaster.title_id=titlemaster.title_id and musicmaster.artist_id=artistmaster.artist_id and musicmaster.genre_id=genremaster.genre_id;");
	ResultSet res = pst.executeQuery();
	
	%>
	<div class="container">
	 <h3 class="text-center">Here You can Update the Data if any thing is gone wrong</h3><br>
		<form action="MSingleServlet" method="post">
		  <input type="hidden" name ="action" value="M_update">
		  
			<table class="table table-hover">
        		<thead>
   					 <tr>
      				<!--  	<th scope="col">Previous Data</th>-->
      					<th scope="col">You can Update here</th>     			
    				</tr>		
 				</thead>
 					<%while (res.next()) { %>
 					<tr scope="row">
 				<!--	<input type="hidden" name="musicid" value=<%=res.getInt(1) %>>
 						<td class ="p-3 mb-2 bg-danger text-white">
 						Album Name :- <%=res.getString(2) %><br>
 						Title Name :- <%=res.getString(3) %><br>
 						Artist Name :- <%=res.getString(4) %><br>
 						Genere Name :- <%=res.getString(5) %></td>
 						<td>
 							 Drop Down For Albums -->
			 
			 <div class="col-md-2">
          			<div class="form-group">
  						<label for="sel1">Select Album:</label>
  						<select class="form-control" id="sel1" name="album">
    						<%Set set = album.entrySet();
    						Iterator itr1 = set.iterator();
    							while(itr1.hasNext()) {
    								Map.Entry l = (Map.Entry)itr1.next();%>
								<option value=<%=l.getKey() %>><%=l.getValue() %></option><%} %>
  						</select>
					</div>
        		</div>	 	
        		
        		
        		<!-- Drop Down For Titles -->

       			<div class="col-md-2">
          			<div class="form-group">
  						<label for="sel1">Select Title:</label>
  						<select class="form-control" name="title">
  						<%Set set1 = title.entrySet();
  						Iterator itr2 = set1.iterator();
    							while(itr2.hasNext()) {
    							Map.Entry l1 = (Map.Entry)itr2.next();%>
								<option value=<%=l1.getKey() %>><%=l1.getValue() %></option><%} %>
    						
  						</select>
					</div>
        		</div>
        		
        		
        		<!-- Drop Down for Artist -->
        		
        		<div class="col-md-2">
          			<div class="form-group">
  						<label for="sel1">Select Artist:</label>
  						<select class="form-control" name="artist">
  						<%Set set2 = artist.entrySet();
  						Iterator itr3 = set2.iterator();
    							while(itr3.hasNext()) {
    							Map.Entry l2 = (Map.Entry)itr3.next();%>
								<option value=<%=l2.getKey() %>><%=l2.getValue() %></option><%} %>
    						
  						</select>
					</div>
        		</div>
        		
        		
        		<!-- Drop Down for Genre -->
        		
        		<div class="col-md-2">
          			<div class="form-group">
  						<label for="sel1">Select Genre:</label>
  						<select class="form-control" name="genre">
  						<%Set set3 = genre.entrySet();
  						Iterator itr4 = set3.iterator();
    							while(itr4.hasNext()) {
    							Map.Entry l3 = (Map.Entry)itr4.next();%>
								<option value=<%=l3.getKey() %>><%=l3.getValue() %></option><%} %>
    						
  						</select>
					</div>
        		</div>
        		
        		
        		
        		
    					</td>
  				
 					</tr>
 					
 					<tr>
 						<td></td>
 						<td><button class="btn btn-success" type="submit">Update Details</button></td>
 					</tr>
 			</table>
 		 </form>
 	</div>
 			<%} %>
 		
 		
 		
					
			
<%	
}catch(Exception e) {
	e.printStackTrace();
}

	

%>
	
</body>
</html>
<%}
else {
	response.sendRedirect("./LoginForm.html");}%>