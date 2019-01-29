<%@ include file = 'header.jsp' %>
<%@ page import="java.util.*" %>

</div>
</div>
</div>
<div class='container-fluid'>
<center>
 <table align="center" style='margin-top:100px'> 
		<col width="50"><col width="50"><col width="50"><col width="50"><col width="50"><col width="50"><col width="50"><col width="50"><col width="50">
		<tr>
		<th style='font-size:12px'>Car ID</th>
		<th style='font-size:12px'>Category</th>
		<th style='font-size:12px'>Name</th>
		<th style='font-size:12px'>Brand Name</th>
		<th style='font-size:12px'>Car Model</th>
		<th style='font-size:12px'>Car Mileage</th>
		<th style='font-size:12px'>Car Production Year</th>
		<th style='font-size:12px'>Car Color</th>				
		<th style='font-size:12px'>Image Path</th>
		<th style='font-size:12px'>Price</th>
		<th style='font-size:12px'>Reservation Status</th>
		<th style='font-size:12px'>location</th>
		</tr>
		<br/>
		<br/>
		<tr>
			<td>
				
			</td>
		</tr>

		<% if(request.getAttribute("wholeList")==null){ 
			out.println("Null aa rha h");
			response.sendRedirect("ChangeCarServlet");

		}
		ArrayList<String> list = (ArrayList<String>) request.getAttribute("wholeList");
		int count = 0;
		while(count<list.size()){
		%>
		<form action="ChangeCarServlet?task=update&prodId=<%out.print(list.get(count));%>" method="post"> 
			<tr>
				<td>
					<input type="text"required  style='width:100px;font-size:15px' value='<%out.print(list.get(count));%>' placeholder="Product ID" name="prodId" maxlength="19">
				</td>

			<td>
				<input type="text"required style='width:100px;font-size:15px' value='<%out.print(list.get(count+1));%>'  placeholder="Car Name" name="name" maxlength="19">
			</td>	
			<td>
				<input type="text"required style='width:100px;font-size:15px' value='<%out.print(list.get(count+2));%>'  placeholder="Car Category" name="prodCategory" maxlength="19">
			</td>
			 
			<td>
				<input type="text"required style='width:100px;font-size:15px' value='<%out.print(list.get(count+3));%>'  placeholder="Car Brand Name" name="brandName" maxlength="19">
			</td>
			
			<td>
				<input type="text"required style='width:100px;font-size:15px' value='<%out.print(list.get(count+4));%>'  placeholder="Car Model"  name="model" maxlength="49">
			</td>
			<td>
				<input type="text"required style='width:100px;font-size:15px' value='<%out.print(list.get(count+5));%>'  placeholder="Car Mileage"  name="mileage" maxlength="49">
			</td>
			<td>
				<input type="text"required style='width:100px;font-size:15px' value='<%out.print(list.get(count+6));%>'  placeholder="Car Production Year" name="productionYear" maxlength="19">
			</td>
			<td>
				<input type="text"required style='width:100px;font-size:15px' value='<%out.print(list.get(count+7));%>'  placeholder="Car Color"  name="color" maxlength="50" >
			</td>

			<td>
				<input type="text"required style='width:100px;font-size:15px' value='<%out.print(list.get(count+8));%>'  placeholder="Image" name="imagePath"  maxlength="32">
			</td>
			<td>
				<input id="username"required style='width:100px;font-size:15px' value='<%out.print(list.get(count+9));%>'  placeholder="Car Price" type="text" name="price" maxlength="10">
			</td>

			<td>
				<input type="text"required style='width:100px;font-size:15px' value='<%out.print(list.get(count+10));%> '  placeholder="Reservation Status"  name="reservationStatus" maxlength="50" >
			</td>
			<td>
				<input type="text"required style='width:100px;font-size:15px' value='<%out.print(list.get(count+11));%> '  placeholder="Location"  name="location" maxlength="50" >
			</td>
			
			<td>
				<input type="submit" id="submit" class="btn btn-primary" style="font-size:12px;height:20%;border:1px solid black" value="Update"> 
			</td>
			<td>
				<input type="button" id="submit" class="btn btn-primary" value="Delete" onclick="window.location.href='ChangeCarServlet?task=delete&prodId=<%out.print(list.get(count));%>'" > 
			</td></tr>
			</form>
			<%count=count+12;
		}%>
		</table>
		</center>
		</div>
		
