<%@ include file = 'header.jsp' %>
<%@page import = "java.util.*"%>

<body>
       <%ArrayList<String> userdetails = (ArrayList<String>) request.getAttribute("userdetails");%>
        <h2>User details</h2>     
        <form method='post' action='SaveCars?action=1'>
        <% 
                int count =0;
                %>
                <%while (count<userdetails.size()){%>
           <table>
                        <tr>
                            
                            <td>  

        <p><label for='productId'> email ID: </label>
       <td> <input name='prodId' id='prodId' value='<%out.print(userdetails.get(count+1)); %>' type='text'/></p></td>

            </td>
</tr>

         <tr>
                            
                            <td>    


        <p><label for='name'>Name:</label>
        <td><input name='name' id='name' value='<%out.print(userdetails.get(count)); %>' type='text'/></p></td>
            </td>
</tr>

       

         <tr>
                            
                            <td>    

     

        <p><label for='brandName'>Address:</label>
        <td><input name='brandName' id='brandName' value='<%out.print(userdetails.get(count+2)); %>' type='text'/></p></td>
            </td>
</tr>

         <tr>
                            
                            <td>    

        <p><label for='model'>Phone Number:</label>
        <td><input name='model' id='model' value='<%out.print(userdetails.get(count+3)); %>' type='text'/></p></td>
            </td>
</tr>

         <tr>
                            
                            <td>    

        <p><label for='price'>City:</label>
        <td><input name='price' id='price' value='<%out.print(userdetails.get(count+4)); %>' type='text'/></p></td>
            </td>
</tr>

         <tr>
                            
                            <td>    

        <p><label for='mileage'>State:</label>
        <td><input name='mileage' id='mileage' value='<%out.print(userdetails.get(count+5)); %>' type='text'/></p></td>
            </td>
</tr>

         <tr>
                            
                            <td>    

        <p><label for='productionYear'> ZipCode:</label>
        <td>
            <input name='productionYear' id='productionYear' value='<%out.print(userdetails.get(count+6)); %>' type='text' /></p>
        </td>
            </td>
</tr>

       
<% count = count +7;
    }%>
        

</table>
        </form>
        
         </body>

<%@ include file = 'footer.jsp' %>