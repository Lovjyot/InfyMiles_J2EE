<%@ include file = 'header.jsp' %>

<body>
       
        <h2>Enter Cars details</h2>     
        <form method='post' action='SaveCars?action=1'>

           <table>
                        <tr>
                            
                            <td>  

        <p><label for='productId'> Cars ID: </label>

       <td> <input name='prodId' id='prodId' value='' type='text'/></p></td>


            </td>
</tr>

         <tr>
                            
                            <td>    


        <p><label for='name'>Name:</label>
        <td><input name='name' id='name' value='' type='text'/></p></td>
            </td>
</tr>

         <tr>
                            
                            <td>    

        
        <p>Cars Category
        <td><select id='prodCategory' name='prodCategory'>
        <option value='sedan'>Sedan</option> 
        <option value='hetchback'>Hetchback</option> 
        <option value='van'>Van</option> 
        <option value='suv'>SUV</option>
        <option value='crossover'>Crossover</option>    
        <option value='coupe'>Coupe</option>
        <option value='convertible'>Convertible </option>
        </select></td></p>
            </td>
</tr>

         <tr>
                            
                            <td>    

     

        <p><label for='brandName'>Brand Name:</label>
        <td><input name='brandName' id='brandName' value='' type='text'/></p></td>
            </td>
</tr>

         <tr>
                            
                            <td>    

        <p><label for='model'>Model:</label>
        <td><input name='model' id='model' value='' type='text'/></p></td>
            </td>
</tr>

         <tr>
                            
                            <td>    

        <p><label for='price'>Price:</label>
        <td><input name='price' id='price' value='' type='text'/></p></td>
            </td>
</tr>

         <tr>
                            
                            <td>    

        <p><label for='mileage'>Mileage:</label>
        <td><input name='mileage' id='mileage' value='' type='text'/></p></td>
            </td>
</tr>

         <tr>
                            
                            <td>    

        <p><label for='productionYear'> ProductionYear:</label>
        <td><input name='productionYear' id='productionYear' value='' type='text' /></p></td>
            </td>
</tr>

         <tr>
                            
                            <td>    

        <p><label for='color'>Color:</label>
        <td><input name='color' id='color' value='' type='text' /></p></td>
            </td>
</tr>

         <tr>
                            
                            <td>    

        <p><label for='imagePath'>Image:</label>
        <td><input name='imagePath' id='imagePath' value='' type='text' /></p></td>
            </td>
</tr>

         <tr>
                            
                            <td>    

        <p><label for='location'>Location:</label>
        <td><input name='location' id='location' value='' type='text' /></p></td>
            </td>
</tr>

         <tr>
                            
                            <td>    

        <p><label for='reservationStatus'>ReservationStatus:</label>
        <td><input name='reservationStatus' id='reservationStatus' value='' type='text' /></p></td>
            </td>
</tr>

         <tr>
                            
                            <td>    
        <input type='submit' value='Add'/>
    </td>
</tr>

</table>
        </form>
        
         </body>

<%@ include file = 'footer.jsp' %>