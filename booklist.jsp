<%@ include file ='header.jsp' %>
<%@page import = "java.util.*"%>

<%ArrayList<String> carlist = (ArrayList<String>) request.getAttribute("Carlist");%>
	<div style="margin-top:-40px">
	<div align="center" class="jumbotron" style="padding:10px" id="get-start">
<form action="CarListservlet" method="Post">
 <input id="mapinput" type="text"required placeholder="Enter Location Zip" value="<%if(request.getParameter("location")!=null) out.println(request.getParameter("location"));%>" name="location" class="lot" style="font-size:20px;width:500px;height:50px">
          <script type="text/javascript">
  function initAutocomplete() {
    autocomplete = new google.maps.places.Autocomplete(
        /** @type {!HTMLInputElement} */(document.getElementById('mapinput')),options);
  }

  var options = {
  types: ['(regions)'],
  componentRestrictions: {country:'us'}	
};
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDg0JApm5ORuNN_4ypS8fx9gFGGMqJqpgI&libraries=places&callback=initAutocomplete"
         async defer></script>
		 
		 
 <input type="text"required name="date" id="date" value="<%if (request.getParameter("date")!=null){out.println(request.getParameter("date"));}%>" style="font-size:20px;width:500px;height:50px"/>
<input type="hidden" id="startdate" value="<%out.println(request.getAttribute("startdate"));%>" />
<input type="hidden" id="enddate" value="<%out.println(request.getAttribute("enddate"));%>" />
 <script type="text/javascript">

//document.getElementById("date").value = <%if (request.getParameter("date")!=null){out.println(request.getParameter("date"));}%>;
$(function(){
	var startDate = document.getElementById("startdate").value;
	var enddate = document.getElementById("enddate").value;
	var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1;

var yyyy = today.getFullYear();
if(dd<10){
    dd='0'+dd;
} 
if(mm<10){
    mm='0'+mm;
} 
var today = mm+'/'+dd+'/'+yyyy;
    $('input[name="date"]').daterangepicker({
		"timePicker": true,
    "timePickerIncrement": 30,
    "dateLimit": {
        "days": 30
    },
    "startDate": startDate,
    "endDate": enddate,
    "minDate": today,
    "maxDate": "12/31/2017",
	 locale: {
            format: 'MM/DD/YYYY h:mm A'
}
});
});

</script>
 <input type="submit" value="Continue"/>
 </form>
</div>
</div>
</div>
</div>
	<% if (request.getAttribute("Carlist")==null || request.getAttribute("Carlist")==""){
		out.println("<div align='center'>No Such Cars Available</div></body></html>");
	}else{%>
	
	<div class="container" style="clear:both;padding-bottom:70px;padding-top:70px">
			<div class="row">
			
				<div class="col-sm-3" >
				<div class="stuck">
					<div class="left-sidebar" >
					<div><form action="LeftNavSearch" method="POST">
						<div class="line" style="font-size:25px"><span><b>Brand</b></span></div>
						<div class="brands-name" style="outline: 1px solid orange;">
								<ul class="nav nav-pills nav-stacked">
									<li><a>Audi  <span class="pull-right"><input type="checkbox" value="Audi" name="brand"/></span></a> </li> 
									<li><a>BMW  <span class="pull-right"><input type="checkbox" value="BMW" name="brand"/></span></a> </li>
									<li><a>Mercedes  <span class="pull-right"><input type="checkbox" value="Mercedes" name="brand"/></span></a> </li>
									<li><a>VolksWagen <span class="pull-right"><input type="checkbox" value="VolksWagen" name="brand"/></span></a> </li>
									<li><a>Ferrari<span class="pull-right"><input type="checkbox" value="Ferrari" name="brand"/></span></a> </li>
									<li><a>Toyota<span class="pull-right"><input type="checkbox" value="Toyota" name="brand"/></span></a> </li>
									<li><a>Honda<span class="pull-right"><input type="checkbox" value="Honda" name="brand"/></span></a> </li>
									<li><a>Chevrolet<span class="pull-right"><input type="checkbox" value="Chevrolet" name="brand"/></span></a> </li>
									<li><a>Mazda<span class="pull-right"><input type="checkbox" value="Mazda" name="brand"/></span></a> </li>
									<li><a>KIA<span class="pull-right"><input type="checkbox" value="KIA" name="brand"/></span></a> </li>
									<li><a>Range Rover<span class="pull-right"><input type="checkbox" value="Range Rover" name="brand"/></span></a> </li>
									<li><a>Rolls Royce<span class="pull-right"><input type="checkbox" value="Rolls Royce" name="brand"/></span></a> </li>
									<li><a>Bugatti<span class="pull-right"><input type="checkbox" value="Bugatti" name="brand"/></span></a> </li> 
									<li><a>Lamborghini<span class="pull-right"><input type="checkbox" value="Lamborghini" name="brand"/></span></a> </li>
									<li><a>Ford<span class="pull-right"><input type="checkbox" value="Ford" name="brand"/></span></a> </li>									
									<li><a>Jaguar<span class="pull-right"><input type="checkbox" value="Jaguar" name="brand"/></span></a> </li>																
									</ul>
							</div>
					
						<div class="brands_products" style="padding-bottom:50px;padding-top:20px"><!--brands_products-->
						<div class="line" style="font-size:20px"><span><b>Categories</b></span></div>
							<div class="brands-name" style="outline: 1px solid orange;" >
								<ul class="nav nav-pills nav-stacked">
									<li><a>Hatchback  <span class="pull-right"><input type="checkbox"  value="Hatchback" name="category"/></span></a> </li> 
									<li><a>Sedan  <span class="pull-right"><input type="checkbox" value="Sedan" name="category"/></span></a> </li>
									<li><a>Van  <span class="pull-right"><input type="checkbox" value="Van" name="category"/></span></a> </li>
									<li><a>SUV  <span class="pull-right"><input type="checkbox" value="SUV" name="category"/></span></a> </li>
									<li><a>Crossover  <span class="pull-right"><input type="checkbox" value="Crossover" name="category"/></span></a> </li>
									<li><a>Coupe  <span class="pull-right"><input type="checkbox" value="Coupe" name="category"/></span></a> </li>
									<li><a>Convertible  <span class="pull-right"><input type="checkbox" value="Convertible" name="category"/></span></a> </li></ul>
							</div>
						</div><!--/brands_products-->
						
						
						<div class="brands_products" style="padding-bottom:50px;padding-top:20px"><!--brands_products-->
						<div class="line" style="font-size:20px"><span><b>Select Price</b></span></div>
						<div class="brands-name" style="outline: 1px solid orange;" >
							<ul class="nav nav-pills nav-stacked">
									<li><a>$0 - $50  <span class="pull-right"><input type="checkbox" value="0,50" name="pricerange"/></span></a> </li> 
									<li><a>$51 - $150  <span class="pull-right"><input type="checkbox" value="51,150" name="pricerange"/></span></a> </li>
									<li><a>$151 - $300 <span class="pull-right"><input type="checkbox" value="151,300" name="pricerange"/></span></a> </li>
									<li><a>$300 - $1000 <span class="pull-right"><input type="checkbox" value="300,1000" name="pricerange"/></span></a> </li>
						</div><!--/brands_products-->
						</div>
						
						
						
						
						<div>
						<input type="submit" value="Update Search" style="color:black;height:30px;width:200px" /><br/><br/>
						
						</div>
						</form>
						</div>
						</div>
					</div>
				</div>
				
				<% 
				
				int i =0;
				request.setAttribute("Carlist",carlist);
				%>
				<div class="col-xs-9" >
				<div class="col-xs-12" style="margin-top:150px">
				<%while (i<carlist.size()){%>
							<div class="container-fluid" style="padding-top:25px;padding-left:25px;">
							<a href="CarDetailServlet?carid=<%out.println(carlist.get(i));%>&date=<%if((request.getParameter("date"))==null) out.println("11/16/2017 12:00 AM - 12/31/2017 12:00 AM"); else out.println(request.getParameter("date"));%>&location=<%if(request.getParameter("location")==null) out.println(carlist.get(i+11)); else out.println(request.getParameter("location"));%>" style="text-decoration:none;"><img src="data/images/<%out.println(carlist.get(i+8));%>" style="padding:10px;height:500px">
							<div  style="float:left;margin-left:15px"><p  style="font-family:Impact;text-transform: uppercase;font-size:20px;color:black"><%out.println(carlist.get(i+1));%>
							<font size="3"><%out.println(carlist.get(i+4));%></font></p>
							<div><span class="stars-container stars-<%out.println(carlist.get(i+12));%>" style="font-size:25px">&#9733;&#9733;&#9733;&#9733;&#9733;</span></div>
							</div>
							<div style="float:right;margin-right:15px"><p style="font-size:20px;color:black">
							<b>$<%out.println(carlist.get(i+9));%></b>/day</p></div>
							</a>
							</div>
				<%i=i+14;}%>
			</div>
			<div align="center">No more Cars Available Please update your search</div>
			</div>
			
			</div>
			</div>
	<%}%>