<%@include file ='header.jsp' %>
<%@page import = "java.util.*"%>
<%@page import = "java.text.*"%>
<%@page import = "java.io.*,java.util.*, javax.servlet.*" %>


                </div>
                </div>
                </div>
                </div>
				<div class="container" align="center" style="padding:50px">
                <h2>Write Review</h2>

                <%
                ArrayList<String> carlist = (ArrayList<String>) session.getAttribute("carlist");
                //session.setAttribute("carlist",carlist);
                
                int i=0;
                %>
                <%
                Date date = new Date();
                SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd");
                %>


                <form method = "post" action="WriteReviewsServlet">
                    <table><b>
                        <tr>
							<td style="vertical-align: middle;padding:10px">Car Type</td>
                            <td>
                                <input class="login" type = "text" name="carName" readonly value= <%out.println(carlist.get(i+2));%>  >
                            </td>
                        </tr> 
						<tr>
							<td style="vertical-align: middle;padding:10px">Car Name</td>
                            <td><input class="login" type = "text" name="carName" value= <%out.println(carlist.get(i+1));%>></td>
                        </tr> 
                        
                        <tr>
							<td style="vertical-align: middle;padding:10px">Price</td>
                            <td><input class="login" type = "text" name="price" value= <%out.println(carlist.get(i+9));%> ></td>
                        </tr> 
                        
                        <tr>
							<td style="vertical-align: middle;padding:10px">Car ID</td>
                            <td><input class="login" type = "text" name="carID" value= <%out.println(carlist.get(i+0));%> ></td>
                        </tr> 

                        <tr>
							<td style="vertical-align: middle;padding:10px">User Name</td>
                            <td><input class="login" type = "text" name="userName" value = <% out.println(username); %>></td>
                        </tr>
                        
                        <tr>
							<td style="vertical-align: middle;padding:10px">User Age</td>
                            <td><input class="login" type = "text" name="userAge"></td>
                        </tr> 
                        
                        <tr>
							<td style="vertical-align: middle;padding:10px">User Gender</td>
                            <td><select class="login"  id='userGender' name='userGender'>
								    <option value='Male'>Male</option>
								    <option value='Female'>Female</option>
							    </select>
                            </td>
                        </tr> 

                        <tr>
							<td style="vertical-align: middle;padding:10px">User Occupation</td>
                            <td><input class="login" type = "text" name="userOccupation"></td>
                        </tr> 

                        <tr>
							<td style="vertical-align: middle;padding:10px">Manufacturer</td>
                            <td><input class="login" type = "text" name="manufacturer" value= <%out.println(carlist.get(i+3));%> ></td>
                        </tr> 
                        
                        <tr>
                            <br/>
							<td style="vertical-align: middle;padding:10px">Rating</td>
                            <td><select class="login" id='rating' name='rating'>
								    <option value='5'>5</option>
								    <option value='4'>4</option>
                                    <option value='3'>3</option>
								    <option value='2'>2</option>
                                    <option value='1'>1</option>
                                </select>
                            </td>
                        </tr> 
                        
                        <tr>
							<td style="vertical-align: middle;padding:10px">Review Date</td>
                            <td><input class="login" type = "date" name="reviewDate" value = <% out.println(ft.format(date)); %>></td>
                        </tr> 
                        
                        <tr>
							<td style="vertical-align: middle;padding:10px">Comments</td>
                            <td><input class="login" type = "textarea" name="comments"></td>
                        </tr> 
                        
                        <tr>
                            <td><center><input type="submit" style="padding:10px" value="submit" class="btn btn-gold"></center></td>
                        </tr>

                    </table>
                </form>
                    
                </div>
                <!--==============================footer=================================-->
    <%@ include file = 'footer.jsp' %>
