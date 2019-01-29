<%@ include file ='header.jsp' %>

<%@page import = "java.util.*"%>
<%@page import = "java.text.*"%>



<%
	ArrayList<String> carlist = (ArrayList<String>) session.getAttribute("Carlist");
	session.setAttribute("carlist",carlist);
%>
	<div style="margin-top:-40px">
	<div align="center" class="jumbotron" style="padding:10px" id="get-start">
<form action="CarListservlet" method="Post">
 <input id="mapinput" type="text"required placeholder="Enter Location Zip" value="<%if(request.getParameter("location")!=null) out.println(request.getParameter("location")); else out.println(carlist.get(11));%>" name="location" class="lot" style="font-size:20px;width:500px;height:50px">
          
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
		 
		 
 <input type="text" name="date" style="font-size:20px;width:500px;height:50px"/>
 <input type="hidden" id="startdate" value="<%if (request.getAttribute("startdate")!=null) out.println(request.getAttribute("startdate")); else out.println("11/15/2017 12:00 AM");%>" />
<input type="hidden" id="enddate" value="<%if (request.getAttribute("enddate")!=null) out.println(request.getAttribute("enddate"));  else out.println("11/16/2017 12:00 AM");%>" />
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
	<div class="row">		
	<% 
		//int carid = Integer.parseInt(request.s("carid"));
		int i = 0;
	%>
		<div style="width:100%;margin-top:150px; border: 1px solid black">
			<img src="data/images/<%out.println(carlist.get(i+8));%>" style="padding:10px;height;100%;width:100%">
			<div class="col-md-3" style="padding-top:50px;padding-left:50px">
				<font style="font-size:20px;color:grey"> Car Details:</font>
			</div>
			<div class="col-md-9 col-md-offset-2" >
				<p  style="font-family:Impact;text-transform: uppercase;font-size:30px;color:black;"><%out.println(carlist.get(i+1));%>
					<font size="3"><%out.println(carlist.get(i+4));%></font>
				</p>
				<div class="col-md-4" style="padding:10px">
					<p style="font-size:20px;color:black;padding:10px"><img src="images/money.png" style="height:30px;width:30px"/><b  style="padding-left:10px">$<%out.println(carlist.get(i+9));%></b>/day</p>
					<p style="font-size:20px;color:black;padding:10px"><img src="images/seats.png" style="height;30px;width:30px"/><b style="padding-left:10px">5</b> Seats</p></p>
				</div>
				<div class="col-md-4" style="padding:10px">
					<p style="font-size:20px;color:black;padding:10px"><img src="images/mpg.png" style="height;30px;width:30px"/><b  style="padding-left:10px"> <%out.println(carlist.get(i+5));%></b>MPG</p>
					<p style="font-size:20px;color:black;padding:10px"><img src="images/oil.png" style="height;30px;width:30px"/><b style="padding-left:10px"> Petrol</b></p></p>
				</div>
				<div class="col-md-4" style="padding:10px">
					<input type="button" value="Rent this car" style="color:black;font-weight: bold;font-size:20px;color:white" class="btn btn-success"/>
				</div>							
			</div>
			<div class="col-md-3" style="padding-top:50px;padding-left:50px;">
				<font style="font-size:20px;color:grey"> Ratings:</font>
			</div>
			<div class="col-md-9" style="padding-top:50px;margin-left:-90px">
				<span class="stars-container stars-<%out.println(carlist.get(i+12));%>" style="font-size:20px">
					&#9733;&#9733;&#9733;&#9733;&#9733;
				</span>
				<font style="font-size:20px;font-weight:bold;padding-left:20px"><%if (!(carlist.get(i+12).equals("0"))) {%>In <%out.println(carlist.get(i+13));%> Ratings<%}else out.println("No ratings yet");%>
				</font>
			</div>
			<div class="col-md-3" style="padding-top:50px;padding-left:50px;">
				<font style="font-size:20px;color:grey"> Reviews:</font>
			</div>
			<br/>
			<div class="col-md-3" style="padding-top:50px">
				<a href="WriteReview.jsp" class="btn btn-gold">Write Reviews</a>
			</div>

			<!-- -------------------------------- -->
			<!-- Review added by yatin  -->

			<div class="col-md-9" style="padding-top:50px;padding-left:50px">
				<ul>
					
				<%
				String name = (String)session.getAttribute("name");
				String date = (String)session.getAttribute("date");
				String text = (String)session.getAttribute("text");
				String[] newName = name.split(",");
				String[] newDate = date.split(",");
				String[] newText = text.split(",");
				for(int j=0;j<newText.length;j++){
					out.println("<div class='col-md-9' style='border:1px solid;background-color:#c3c3c3;padding:10px'>");
					out.println(newName[j]+"<br>");
					out.println(newDate[j]+"<br>");
					out.println(newText[j]+"<br>");
					out.println("</div>");
					out.println("<div class='col-md-9'>");
					out.println("<br/><br/>");
					out.println("</div>");
				}
				
				%>
				</ul>
				
			</div>
			<!-- ------------------------------------ -->
							
		</div>
			
	</div>
</div>

<%@ include file ='footer.jsp' %>