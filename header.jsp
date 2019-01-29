<!DOCTYPE html>
<html lang="en">
<head>
	<title>Home</title>
	<meta charset="utf-8">
	<meta name = "format-detection" content = "telephone=no" />
	<link rel="icon" href="images/favicon.ico">
	<link rel="shortcut icon" href="images/favicon.ico" />
	<link rel="stylesheet" href="booking/css/booking.css">
	<link rel="stylesheet" href="css/camera.css">
	<link rel="stylesheet" href="css/owl.carousel.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/mystyle.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
	<script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap/3/css/bootstrap.css" />
	<script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
	<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
	
	<!--	<script src="js/jquery.js"></script> -->
	<script src="js/jquery-migrate-1.2.1.js"></script>
	<script src="js/script.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/superfish.js"></script>

	<script src="js/jquery.ui.totop.js"></script>
	<script src="js/jquery.equalheights.js"></script>
	<script src="js/jquery.mobilemenu.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/owl.carousel.js"></script>
	<script src="js/camera.js"></script>
	<script src="js/jquery.mobile.customized.min.js"></script>
	<!--<![endif]-->
	<script src="booking/js/booking.js"></script>
</head>
<body class="page1" id="top">
	
		
		<div class="fixheader" align="center">
		<div>
		<!--==============================header=================================-->
		<header>
					<div class="jumbotron" style="background-color:black;padding:20px">
						<div class="row">
							<div class="col-md-3">
								<a href="home.jsp">
								<img src="images/logo.jpg" style="height:60px;width:200px;float:left;margin-left:80px;">
							</a></div>
							<div class="col-md-9">
				
							<nav class="navbar" style="float:left">
								<ul class="sf-menu" >
									
									<li><form action="AutoCompleteSearchServlet">
        <input type="text" name="search" id="search" class="input_search" style="font-size:20px;width:500px;height:38px" placeholder="Search Cars...."></li>
		
		<script type="text/javascript" src="js/jquery.autocomplete.js"></script>
		<script>
		jQuery(function(){
		$("#search").autocomplete("AutoCompleteServlet");
		});
		</script>
   <li> <button type="submit" style="height:38px" class="btn btn-default">
        <span class="glyphicon glyphicon-search"></span>
    </button>
</form></li><
<%String username = (String) session.getAttribute("username");
if (username==null){%>
									<li><a href="login.jsp" style="font-size:20px;background-color:black;color:white;text-decoration:none">Log in</a></li>
									<li><a href="UserRegistration.jsp" style="font-size:20px;background-color:black;color:white;text-decoration:none">Sign up</a></li>
<%}else{%><li>
<div class="dropdown">
    <button class="btn dropdown-toggle" type="button" style="background-color:black;color:gold;" data-toggle="dropdown"><%out.println(username.toUpperCase());%>
    <span class="caret"></span></button>
    <ul class="dropdown-menu" style="top:35px;background-color:black;">
      <li><a href="ProfileServlet" style="color:gold">Profile</a></li>
      <li><a href="bookinghistory.jsp" style="color:gold">History</a></li>
	  <li><a href="home.jsp?logout=done"style="color:gold">Log Out</a></li>
    </ul>
  </div>
<%}%>
							<li><a href="trending.jsp" style="font-size:20px;background-color:black;color:white;text-decoration:none">Trending</a></li>	
								</ul>
							</nav>
								</div>
							</div>
						</div>

				</header>
				<!--=====================================================================-->
