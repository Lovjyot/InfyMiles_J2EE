<%@ include file ='header.jsp' %>
	
				<script type="text/javascript" src="js/javascripts.jsp"></script> 
				<div class="container" align="center" style="padding:50px">
					<form method='post' action='ValidRegistration'>
					<table><b>
						<br/><br/>
						<tr>
							
							<td><select id='role' name='role'>
								<option value='customer'>Customer</option>
								<option value='storeManager'>Store Manager</option>
							
							</select></td>
						</tr>
						<tr>
							<td>
								<input class="login" type="text"required name="name" onkeypress="return onlyAlphabets()" placeholder="Name" maxlength="30"/> 
							</td>
						</tr>
						<tr>
							<td>
								<input class="login" type="text"required name="emailId" id="emailId" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="abc@xyz.com" placeholder="EmailId" maxlength="50" />
							
							<div id="status"></div>
							
 								<script type="text/javascript" src="js/chk_user.js"></script> 
								</td>
						</tr>
						<tr>
							<td>
								<input class="login" type="password"required name="password" placeholder="Password" maxlength="20"/> 
							</td>
						</tr>

						<tr>
							<td>
								<input type="text"required class="login"  onkeypress="return onlyNumbers()"  pattern=".{10,}" title="XXXXXXXXXX - Phone must be 10 Digit"  name="phoneNumber" placeholder="Phone Number" maxlength="10"/> 
							</td>
						</tr>
						<tr>
							<td>
								<input class="login" type="text"required onkeypress="return AlphaNumericSp()" name="address" placeholder="Address" maxlength="50"/> 
							</td>
						</tr>
						<tr>
							<td>
								<input class="login" type="text"required onkeypress="return onlyAlphabets()" name="city" placeholder="City" maxlength="20"/> 
							</td>
						</tr>
						<tr>
							<td>
								<input class="login" type="text"required onkeypress="return onlyAlphabets()" name="state" placeholder="State" maxlength="20"/> 
							</td>
						</tr>
						<tr>
							<td>
								<input class="login" type="text"required onkeypress="return onlyNumbers()" name="zipcode" placeholder="Zipcode" maxlength="5"/> 
							</td>
						</tr>
										
						<tr>
							<td><input type="submit" style="padding:10px" value="SignUp" class="btn btn-gold">
								
							</td>
						</tr>
						
					</form> 
				</table> 
				
			</div>
			
<%@include file ='footer.jsp' %>
