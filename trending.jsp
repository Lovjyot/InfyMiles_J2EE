<%@ include file = 'header.jsp' %>
<%@ page import="java.util.*" %>

</div>
</div>
</div>
</div>
</div>
</div>

<%
if (request.getParameter("check")==null)
	response.sendRedirect("MostLikedServlet");
else {
ArrayList<String> mostliked = (ArrayList<String>) session.getAttribute("mostliked");
ArrayList<String> mostsoldlocation = (ArrayList<String>) session.getAttribute("mostsoldlocation");
ArrayList<String> mostbought = (ArrayList<String>) session.getAttribute("mostbought");
%>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12" style="margin-top:150px">
				<div class="line" style="font-size:25px"><span><b>Most Liked Cars</b></span></div>
				
				<% 
				int i=0;
				%>
				
				<%while (i<mostliked.size()){%>
				<div class="col-sm-3" style="outline: 1px solid orange;">
				<a href="CarDetailServlet?carid=<%out.println(mostliked.get(i));%>" style="text-decoration:none"><img src="data/images/<%out.println(mostliked.get(i+8));%>" style="padding:10px" >
				<div  style="float:left;margin-left:15px;padding-bottom:10px"><p style="font-weight:bold;font-family:Goudy Old Style;text-transform: uppercase;font-size:15px;color:black" ><font style="float:right"><%out.println(mostliked.get(i+1));%></font></p>	</div>
				<div style="float:right;margin-right:15px"><p style="font-size:20px;color:black">
							<b>$<%out.println(mostliked.get(i+9));%></b><font style="font-family:Goudy Old Style;font-size:15px">/day</font></p></div>
				
				</a>
				</div>
				<%i=i+12;}%>	
							
			
			</div>
			
			<div class="col-sm-12" style="margin-top:50px">
				<div class="line" style="font-size:25px"><span><b>Most Sold Cars By Location</b></span></div>
				
				<% 
				int j=0;
				%>
				
				<%while (j<mostsoldlocation.size()){%>
				<div class="col-sm-3" style="outline: 1px solid orange;">
				<a href="CarDetailServlet?carid=<%out.println(mostsoldlocation.get(j));%>" style="text-decoration:none"><img src="data/images/<%out.println(mostsoldlocation.get(j+8));%>" style="padding:10px" >
				<div  style="float:left;margin-left:15px;padding-bottom:10px"><p style="font-weight:bold;font-family:Goudy Old Style;text-transform: uppercase;font-size:15px;color:black" ><font style="float:right"><%out.println(mostsoldlocation.get(j+1));%></font></p></div>
				<div style="float:right;margin-right:15px"><p style="font-size:20px;color:black">
							<b>$<%out.println(mostsoldlocation.get(j+9));%></b>
							
							<font style="font-family:Goudy Old Style;font-size:15px">/day</font></p>
							
							</div>
							<br/><br/>
							<p><div style="float:left;margin-right:15px"><b  style="font-size:13px;color:black"><%out.println(mostbought.get(j+11));%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp </b></p></div>
					
				</a>
				</div>
				<%j=j+12;}%>	
							
			
			</div>
			
			<div class="col-sm-12" style="margin-top:50px">
				<div class="line" style="font-size:25px"><span><b>Most Sold Cars</b></span></div>
				
				<% 
				j=0;
				%>
				
				<%while (j<mostbought.size()){%>
				<div class="col-sm-3" style="outline: 1px solid orange;">
				<a href="CarDetailServlet?carid=<%out.println(mostbought.get(j));%>" style="text-decoration:none"><img src="data/images/<%out.println(mostbought.get(j+8));%>" style="padding:10px" >
				<center><div  style="float:left;margin-left:15px;padding-bottom:10px"><p style="font-weight:bold;font-family:Goudy Old Style;text-transform: uppercase;font-size:15px;color:black" ><font style="float:right"><%out.println(mostbought.get(j+1));%></font></p></div>
				<div style="float:right;margin-right:15px"><p style="font-size:20px;color:black">
							<b>$<%out.println(mostbought.get(j+9));%></b>
						
							<font style="font-family:Goudy Old Style;font-size:15px">/day</font></p></div>
					<center>
				</a>
				</div>
				<%j=j+12;}%>	
							
			
			</div>
			
			
			
			</div>
			</div>
			
<%}%>
<%@ include file = 'footer.jsp' %>