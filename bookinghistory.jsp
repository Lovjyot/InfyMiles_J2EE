<%@include file ='header.jsp' %>
<%@page import = "java.util.*" %> 	
<%@page import = "java.sql.*" %> 	

				</div>
				</div>
				</div>
				</div>
				<div class="container" align="center" style="padding:50px; padding-top:120px; ">
				<table style="border:solid 1px black;margin-top:100px">
		<col width="100" style="border:solid 1px black">
<col width="100" style="border:solid 1px black"><col width="200" style="border:solid 1px black"><col width="200" style="border:solid 1px black"><col width="100" style="border:solid 1px black"><col width="100" style="border:solid 1px black"><col width="100" style="border:solid 1px black"><col width="100" style="border:solid 1px black"><col width="100" style="border:solid 1px black">  
  <tr>
  <th style="border:solid 1px black"><center>OrderID</center></th>
    <th style="border:solid 1px black"><center>OrderDate</center></th>
    <th style="border:solid 1px black"><center>Start Date</center></th>
	<th style="border:solid 1px black"><center>End Date</center></th>
	<th style="border:solid 1px black"><center>Amount</center></th>
	<th style="border:solid 1px black"><center>Card Number</center></th>
	<th style="border:solid 1px black"><center>Address</center></th>
	<th style="border:solid 1px black"><center>LicenseId</center></th>
	<th style="border:solid 1px black"><center></center></th>
  </tr>
				<%
				Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			PreparedStatement pst = conn.prepareStatement("select * from orders where lower(username)=?");
			ResultSet rst;
			String uname = (String) session.getAttribute("username");
			pst.setString(1,uname.toLowerCase());
			rst = pst.executeQuery();
			while(rst.next()){%>
			<tr><td><center><%out.println(rst.getString("orderid"));%><center></td>
			<td><center><%out.println(rst.getString("orderdate"));%><center></td>
			<td><center><%out.println(rst.getString("startdate"));%><center></td>
			<td><center><%out.println(rst.getString("enddate"));%><center></td>
			<td><center><%out.println(rst.getString("amount"));%><center></td>
			<td><center><%out.println(rst.getString("cardnumber"));%><center></td>
			<td><center><%out.println(rst.getString("address"));%><center></td>
			<td><center><%out.println(rst.getString("LicenseId"));%><center></td>
			<%if (rst.getString("status").equals("cancelled")){%>
			<td><center><%out.println("Cancelled");%> <center></td>
			<%} else{%>
			<%//if (!(rst.getString("status").equals("cancelled")))%>
			<td><center><a href="CancelOrderServlet?orderid=<%out.println(rst.getString("orderid"));%>" style="text-decoration:none"> Cancel</a></center></td>
			<%}%>
			
			</tr>
			<%}		
				%>
				</table>
				</div>
			