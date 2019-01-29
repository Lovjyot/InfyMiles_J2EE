<%@ include file ='header.jsp' %>
<%@page import = "java.util.*"%>
<%@page import = "java.text.*"%>

<%
ArrayList<String> carlist = (ArrayList<String>) session.getAttribute("carlist");
if ((request.getParameter("check"))==null)
response.sendRedirect("ViewReviewServlet");
else{
ArrayList<String> reviewlist = (ArrayList<String>) session.getAttribute("reviewlist");
%>
	<div style="margin-top:-40px">
	<div align="center" class="jumbotron" style="padding:10px" id="get-start">
<form action="CarListservlet" method="Post">
 <input id="mapinput" type="text"required placeholder="Enter Location Zip" value="<%if(request.getParameter("location")!=null) out.println(request.getParameter("location")); else if (carlist.size()==0){out.println("");} else out.println(carlist.get(11));%>" name="location" class="lot" style="font-size:20px;width:500px;height:50px">
          
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
		 
		 
 <input type="text" id="date" name="date" style="font-size:20px;width:500px;height:50px"/>

 <input type="hidden" id="startdate" value="<%if (request.getAttribute("startdate")!=null) out.println(request.getAttribute("startdate")); else out.println("12/1/2017 12:00 AM");%>" />
<input type="hidden" id="enddate" value="<%if (request.getAttribute("enddate")!=null) out.println(request.getAttribute("enddate"));  else out.println("12/31/2017 12:00 AM");%>" />

<script type="text/javascript">



$(function() {
	
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
    "startDate": document.getElementById("startdate").value,
    "endDate": document.getElementById("enddate").value,
    "minDate": today,
    "maxDate": "12/31/2017",
	 locale: {
            format: 'MM/DD/YYYY h:mm A'
}
}, function(start, end, label) {
  console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
});
});
</script>
 <input type="submit" value="Continue"/>
 </form>
</div>
</div>
</div>
</div>


			
			<div class="container" style="clear:both;padding-bottom:70px;padding-top:70px;">
			<%
if (carlist.size()==0){
out.println("<div style='margin-top:100px'align='center'><h3>No such Cars Available<h3></div></div>");}
	else {
%>
			<div class="row">		
				<% 
					int i = 0;
					%>
							<div style="width:100%;margin-top:150px; border: 1px solid black">
							<img src="data/images/<%out.println(carlist.get(i+8));%>" style="padding:10px;height;100%;width:100%">
							<div class="col-md-3" style="padding-top:50px;padding-left:50px"><font style="font-size:20px;color:grey"> Car Details:</font></div>
							<div class="col-md-9 col-md-offset-2" ><p  style="font-family:Impact;text-transform: uppercase;font-size:30px;color:black;"><%out.println(carlist.get(i+1));%>
							<font size="3"><%out.println(carlist.get(i+4));%></font></p><div class="col-md-4" style="padding:10px"><p style="font-size:20px;color:black;padding:10px"><img src="images/money.png" style="height;30px;width:30px"/><b  style="padding-left:10px">$<%out.println(carlist.get(i+9));%></b>/day</p>
							<p style="font-size:20px;color:black;padding:10px"><img src="images/seats.png" style="height;30px;width:30px"/><b style="padding-left:10px">5</b> Seats</p></p>
							</div>
							<div class="col-md-4" style="padding:10px"><p style="font-size:20px;color:black;padding:10px"><img src="images/mpg.png" style="height;30px;width:30px"/><b  style="padding-left:10px"> <%out.println(carlist.get(i+5));%></b>MPG</p>
							<p style="font-size:20px;color:black;padding:10px"><img src="images/oil.png" style="height;30px;width:30px"/><b style="padding-left:10px"> Petrol</b></p></p>
							</div>
							<div class="col-md-4" style="padding:10px">
							<input type="button" value="Rent this car" <%if (session.getAttribute("username")!=null) {%> onclick="javascript:window.location.href='booking.jsp?date=' + document.getElementById('date').value + '&location=' + document.getElementById('mapinput').value "<% }else {%>onclick="window.location.href='login.jsp'"<%}%> style="color:black;font-weight: bold;font-size:20px;color:white" class="btn btn-success"/>
										<form action="SubmitRatingServlet?carid=<%out.println(request.getParameter("carid"));%>" >
							<p style="padding-top:50px"><select style="font-size:20px" name="select" id="select">
							  <option value="1">1</option>
							  <option value="2">2</option>
							  <option value="3">3</option>
							  <option value="4">4</option>
							  <option value="5" selected>5</option>
							</select>
							<input type="submit" value="Rate" style="height:30px;background-color:#71C737;color:white" /></p>
							</form>
							</div>							
							</div>
							<div class="col-md-3" style="padding-top:50px;padding-left:50px;"><font style="font-size:20px;color:grey"> Reviews:</font></div>
							<div class="col-md-9" style="padding-top:50px;margin-left:-90px"><span class="stars-container stars-<%out.println(carlist.get(i+12));%>" style="font-size:20px">&#9733;&#9733;&#9733;&#9733;&#9733;</span><font style="font-size:20px;font-weight:bold;padding-left:20px"><%if (!(carlist.get(i+12).equals("0"))) {%>In <%out.println(carlist.get(i+13));%> Ratings<%}else out.println("No ratings yet");%></font></div>
							
							
							</div>
			
			</div>
			
			<div class="col-md-3" style="padding-top:50px">
				<a href="<%if (session.getAttribute("username")==null) out.println("login.jsp"); else out.println("WriteReview.jsp");%>" class="btn btn-gold">Write Reviews</a>
			</div>

			<div class="col-md-9" style="padding-top:100px;margin-left:-90px">
				
				
					
				<%
				
				int z=0;
				while(z<reviewlist.size()){
					if ((Integer.parseInt(reviewlist.get(z+6)))==Integer.parseInt(carlist.get(0))){
				%>
					<div class="jumbotron" style="border:1px solid lightgrey;padding:20px"><font style="font-size:20px;padding-right:20px"><%out.println(reviewlist.get(z+7));%></font>
					<font style="font-size:13px;padding-right:20px;float:right">Date:<%out.println(reviewlist.get(z+12));%></font><br/><br/>
					<font style="font-size:15px;padding-right:20px;font-family:Arial;"><%out.println(reviewlist.get(z+13));%></font>
					</div>
					
					
				<%
					}
					z=z+14;
				}
	}
				%>
				
			
			
			
			
			</div>
			<%}%>