<%@include file ='header.jsp' %>


	<li>
 
        <ul>
<!-- 
            <li><a href="SmartPhoneServlet?type=phone&brandName=Samsung">Samsung</a></li>
            <li><a href="SmartPhoneServlet?type=phone&brandName=Apple">Apple</a></li>
            <li><a href="SmartPhoneServlet?type=phone&brandName=LG">LG</a></li>
            <li><a href="SmartPhoneServlet?type=phone&brandName=Sony">Sony</a></li>
            <li><a href="SmartPhoneServlet?type=phone&br">Accessories</a></li>   -->
        <li> <a href="AddProducts.jsp" class="list-group-item">Add Products</a></li>
        <li><a href="ChangeCarServlet" class="list-group-item">Update and Delete Products</a></li>
		<li><a href="InventoryServlet" class="list-group-item">Inventory</a></li>
		<li><a href="SalesReportServlet" class="list-group-item">Sales Report</a></li>
        <li><a href="ChartGeneration" class="list-group-item">Graphs </a></li>
        	<!-- 	<ol>
        			<li><a href="ChartGeneration" class="list-group-item">Sales Chart</li>
        			<li><a href="ChartGeneration" class="list-group-item">Inventory Charts</li>
        		</ol>
        </li> -->
        </ul>
    </li>


<%@ include file = 'footer.jsp' %>