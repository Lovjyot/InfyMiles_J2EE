<%@ include file = 'header.jsp' %>
<%@ page import="java.util.*" %>

</div>
<%
ArrayList<String> rentedcars = (ArrayList<String>) session.getAttribute("rentedcars");
ArrayList<String> dailytrans = (ArrayList<String>) session.getAttribute("dailytrans");

if (request.getParameter("task")!=null){
if (request.getParameter("task").equals("availability")){
	%>
	</div>
	<div class="container-fluid"><center>
<table align="center" border="1px" style='border:1px solid orange'> 
<br/><br/><br/><br/><br/><br/><tr> Total Revenue by Rented Cars</tr>

		<tr>
		
		<th style='font-size:16px;border:1px solid orange'>Car ID</th>
		<th style='font-size:16px;border:1px solid orange'>orderDate</th>
		<th style='font-size:16px;border:1px solid orange'>Amount</th>
		</tr>
		<br/>
		<br/>
		<tr>
			<td>
				
			</td>
		</tr>
		<%int count = 0;
		
		while(count<rentedcars.size()){%>

			<tr>
				<td style='font-size:14px;border:1px solid orange'>
					<center><%out.print(rentedcars.get(count));%></center>
				</td>

			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(rentedcars.get(count+1));%></center>
			</td>	
			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(rentedcars.get(count+2));%></center>
			</td>
			 
			
			</tr>
			<%count=count+3;
		}%>
		</table>
		</center>
		</div>
		</center>
<%
			
}
else if (request.getParameter("task").equals("daily")){%>
	
	</div>
	<div class="container-fluid"><center>
<table align="center" border="1px" style='border:1px solid orange'> 
		
<br/><br/><br/><br/><br/><br/><tr> Total Daily Transactions</tr>
		<tr>
		<th style='font-size:16px;border:1px solid orange'>OrderDate</th>
		<th style='font-size:16px;border:1px solid orange'>Total Transactions</th>
		</tr>
		<br/>
		<br/>
		<tr>
			<td>
				
			</td>
		</tr>
		<%int count = 0;
		while(count<dailytrans.size()){%>

			<tr>
				<td style='font-size:14px;border:1px solid orange'>
					<center><%out.print(dailytrans.get(count));%></center>
				</td>

			<td style='font-size:14px;border:1px solid orange'>
				<center><%out.print(dailytrans.get(count+1));%></center>
			</td>	
		
			</tr>
			<%count=count+2;
		}%>
		</table>
		</center>
		</div>
	
	
<%	
}
}else {%>

<div class="container" style="margin-top:150px">
<a href="salesreport.jsp?task=availability" style="font-size:20px"> Total Revenue by Rented Cars </a><br/><br/>
<a href="salesreport.jsp?task=daily" style="font-size:20px"> Total Daily Transaction </a><br/><br/>
<a href="ChartGeneration" style="font-size:20px"> Graphs </a>
	</div>
	
	
	
<%	
}

%>

