<%@include file ='header.jsp' %>
<%@page import = "java.util.*" %> 	

				</div>
				</div>
				</div>
				</div>
				
				<%
					ArrayList<String> carlist = (ArrayList<String>) session.getAttribute("carlist");
				//	session.setAttribute("carlist",carlist);
					String userName = (String)session.getAttribute("username");
					//ArrayList<String> searchcar = (ArrayList<String>) session.getAttribute("Carlist2");
					String ndate = request.getParameter("date");
					
					String location = request.getParameter("location");
					String datear[] = ndate.split("-");
					String startdate = datear[0];
					String sdate[] = startdate.split("/");
					Integer startday = Integer.parseInt(sdate[1]);
					String enddate = datear[1];
					String edate[] = enddate.split("/");
					Integer endday = Integer.parseInt(edate[1]);
					Integer no_of_days = endday - startday;
					
					//System.out.println("S+"+ searchcar+ startdate+ enddate);
					int i = 0;
				%>
				<div class="container" align="center" style="padding:50px; padding-top:120px; ">
				<h2>Booking Details</h2>
					<form method='post' action='BookingServlet'>
						<table><b>
							
							<tr>
								<td style="vertical-align: middle;padding:10px">Car:</td>
								<td><input class="login" type = "text" value= <%out.println(carlist.get(i+1));%> name="carName"></td>
							</tr>
							
							<tr>
									<td style="vertical-align: middle;padding:10px">User Name</td>
									<td><input class="login" type = "text" value =<% out.println(userName); %> name="userName"></td>
							</tr>

							<tr>
								<td style="vertical-align: middle;padding:10px">Type:</td>
								<td><input class="login" type = "text" value=<%out.println(carlist.get(i+2));%> name="carType"></td>
							</tr>

							<tr>
								<td style="vertical-align: middle;padding:10px">Price:</td>
								<td><input class="login" type = "text" value="<%out.println(Integer.parseInt(carlist.get(i+9))*no_of_days);%>" name="price"></td>
							</tr>
							<tr>
								<td style="vertical-align: middle;padding:10px">From:</td>
									<td><input class="login" type = "text" value="<%out.println(startdate);%>" name="From" required></td>
							</tr>
							<tr>
								<td style="vertical-align: middle;padding:10px">To:</td>
								<td><input class="login" type = "text" name="To" value="<%out.println(enddate);%>" required></td>
							</tr>
							<tr>
								<td style="vertical-align: middle;padding:10px">Location:</td>
								<td><input class="login" type = "text" value="<%out.println(location);%>" name="Location" required></td>
							</tr>
							<tr>
									<td style="vertical-align: middle;padding:10px">Licence No.</td>
									<td><input class="login" type = "text" name="licenceId"></td>
							</tr>

							<tr> 
								<td> <h4>Payment Details:</h4></td> 
							</tr>
							<tr>
								<td style="vertical-align: middle;padding:10px">Card Holder's Name</td>
								<td><input class="login" type = "text" name="cardholderName"></td>
							</tr>
							<tr>
								<td style="vertical-align: middle;padding:10px">Card Number</td>
								<td><input class="login" type = "text" name="cardNumber"></td>
							</tr>

							<tr>
								<td style="vertical-align: middle;padding:10px">Full Address</td>
								<td><input class="login" type = "text" name="Address"></td>
							</tr>
							<tr>
								<td style="vertical-align: middle;padding:10px">CVV</td>
								<td><input class="login" type = "password"  maxlength="3" name="CVV"></td>
							</tr>
							<tr>
                            	<td><center><input type="submit" style="padding:10px" value="submit" class="btn btn-gold"></center></td>
                        	</tr>
							
						</table>		
					</form>				
			</div>
			<!--==============================footer=================================-->
<%@ include file = 'footer.jsp' %>