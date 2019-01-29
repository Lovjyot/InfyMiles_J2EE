<%@ include file = 'header.jsp' %>
<%@ page import="java.util.*" %>

</div>
<%
ArrayList<String> inventory = (ArrayList<String>) session.getAttribute("inventory");
ArrayList<String> discount = (ArrayList<String>) session.getAttribute("discount");

if (request.getParameter("task")!=null){
if (request.getParameter("task").equals("availability")){
	%>
	</div>
	<div class="container-fluid"><center>
<table align="center" border="1px" style='border:1px solid orange'> 

<br/><br/><br/><br/><br/><br/><tr> Available Cars</tr>
		<tr>
		<th style='font-size:16px;border:1px solid orange'>Car ID</th>
		<th style='font-size:16px;border:1px solid orange'>Name</th>
		<th style='font-size:16px;border:1px solid orange'>Category</th>
		<th style='font-size:16px;border:1px solid orange'>Brand Name</th>
		<th style='font-size:16px;border:1px solid orange'>Car Model</th>
		<th style='font-size:16px;border:1px solid orange'>Car Mileage</th>
		<th style='font-size:16px;border:1px solid orange'>Car Production Year</th>
		<th style='font-size:16px;border:1px solid orange'>Car Color</th>				
		<th style='font-size:16px;border:1px solid orange'>Image Path</th>
		<th style='font-size:16px;border:1px solid orange'>Price</th>
		<th style='font-size:16px;border:1px solid orange'>Reservation Status</th>
		<th style='font-size:16px;border:1px solid orange'>location</th>
		</tr>
		<br/>
		<br/>
		<tr>
			<td>
				
			</td>
		</tr>
		<%int count = 0;
		
		while(count<inventory.size()){%>

			<tr>
				<td style='font-size:14px;border:1px solid orange'>
					<center><%out.print(inventory.get(count));%></center>
				</td>

			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(inventory.get(count+1));%></center>
			</td>	
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(inventory.get(count+2));%></center>
			</td>
			 
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(inventory.get(count+3));%></center>
			</td>
			
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(inventory.get(count+4));%></center>
			</td>
			<td style='font-size:14px;border:1px solid orange'>
			<center>	<%out.print(inventory.get(count+5));%></center>
			</td>
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(inventory.get(count+6));%></center>
			</td>
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(inventory.get(count+7));%></center>
			</td>

			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(inventory.get(count+8));%></center>
			</td>
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(inventory.get(count+9));%></center>
			</td>

			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(inventory.get(count+10));%></center>
			</td>
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(inventory.get(count+11));%></center>
			</td>
			
			</tr>
			<%count=count+12;
		}%>
		</table>
		</center>
		</div>
<%
			
}
else if (request.getParameter("task").equals("onsale")){%>
	
	</div>
	<div class="container-fluid"><center>
<table align="center" border="1px" style='border:1px solid orange'> 

<br/><br/><br/><br/><br/><br/><tr> Cars on sale</tr>
		<tr>
		<th style='font-size:16px;border:1px solid orange'>Car ID</th>
		<th style='font-size:16px;border:1px solid orange'>Name</th>
		<th style='font-size:16px;border:1px solid orange'>Category</th>
		<th style='font-size:16px;border:1px solid orange'>Brand Name</th>
		<th style='font-size:16px;border:1px solid orange'>Car Model</th>
		<th style='font-size:16px;border:1px solid orange'>Car Mileage</th>
		<th style='font-size:16px;border:1px solid orange'>Car Production Year</th>
		<th style='font-size:16px;border:1px solid orange'>Car Color</th>				
		<th style='font-size:16px;border:1px solid orange'>Image Path</th>
		<th style='font-size:16px;border:1px solid orange'>Price</th>
		<th style='font-size:16px;border:1px solid orange'>Reservation Status</th>
		<th style='font-size:16px;border:1px solid orange'>location</th>
		<th style='font-size:16px;border:1px solid orange'>Discount</th>
		</tr>
		<br/>
		<br/>
		<tr>
			<td>
				
			</td>
		</tr>
		<%int count = 0;
		while(count<discount.size()){%>

			<tr>
				<td style='font-size:14px;border:1px solid orange'>
					<center><%out.print(discount.get(count));%></center>
				</td>

			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(discount.get(count+1));%></center>
			</td>	
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(discount.get(count+2));%></center>
			</td>
			 
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(discount.get(count+3));%></center>
			</td>
			
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(discount.get(count+4));%></center>
			</td>
			<td style='font-size:14px;border:1px solid orange'>
			<center>	<%out.print(discount.get(count+5));%></center>
			</td>
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(discount.get(count+6));%></center>
			</td>
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(discount.get(count+7));%></center>
			</td>

			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(discount.get(count+8));%></center>
			</td>
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(discount.get(count+9));%></center>
			</td>

			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(discount.get(count+10));%></center>
			</td>
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(discount.get(count+11));%></center>
			</td>
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(discount.get(count+12));%></center>
			</td>
			</tr>
			<%count=count+13;
		}%>
		</table>
		</center>
		</div>
	
	
<%	
}
}else {%>

<div class="container" style="margin-top:150px">
<a href="inventory.jsp?task=availability" style="font-size:20px"> Available Cars </a><br/><br/>
<a href="inventory.jsp?task=onsale" style="font-size:20px"> Cars onsale </a><br/><br/>
<a href="ChartGeneration" style="font-size:20px"> Graphs </a>
	</div>
	
	
	
<%	
}

%>

