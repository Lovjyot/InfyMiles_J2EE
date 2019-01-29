<%@include file ='header.jsp' %>
<%@page import = "java.util.*"%>

</div>
</div>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/>
<title>Chart</title>  
  
  <% if(request.getAttribute("graph")==null){ %>
  <p>Something is wrong, may be nothing is there in database.</p>

  	<%} %>


  	<%ArrayList<String> carlist = (ArrayList<String>) request.getAttribute("graph");%>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <div id="chart_div"></div>
      
	 <script> 
	  google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {

	var data = google.visualization.arrayToDataTable([
        ['City', 'Available Cars',],
		<% 
				int i =0;
				%>
				<%while (i<carlist.size()){%>
              	
					['<%out.print(carlist.get(i));%>',<%out.print(carlist.get(i+1));%>],

					<%i=i+2;}%>
			
      ]);

      var options = {
        title: 'Available cars in U.S. Cities',
        chartArea: {width: '70%'},
		 
        hAxis: {
          title: 'Total Cars',
          minValue: 0
        },
        vAxis: {
          title: 'City'
        }
      };

      var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

      chart.draw(data, options);
    }
	</script>

  <br>
  <hr>

  <div id="chart_div2"></div>

  <% if(request.getAttribute("graph2")==null){ %>
  <p>Something is wrong, may be nothing is there in database.</p>

    <%} %>


    <%ArrayList<String> orderlist = (ArrayList<String>) request.getAttribute("graph2");%>
      
   <script> 
    google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {

  var data = google.visualization.arrayToDataTable([
        ['Cars', 'Total Amounnt',],
    <% 
        int j =0;
        %>
        <%while (j<orderlist.size()){%>
                
          ['<%out.print(orderlist.get(j));%>',<%out.print(orderlist.get(j+1));%>],

          <%j=j+2;}%>
      
      ]);

      var options = {
        title: 'Total sales of disparate cars',
        chartArea: {width: '70%'},
     
        hAxis: {
          title: 'Amount',
          minValue: 0
        },
        vAxis: {
          title: 'Cars'
        }
      };

      var chart = new google.visualization.BarChart(document.getElementById('chart_div2'));

      chart.draw(data, options);
    }
  </script>


  <br>
  <hr>

  <div id="chart_div3"></div>

  <% if(request.getAttribute("graph3")==null){ %>
  <p>Something is wrong, may be nothing is there in database.</p>

    <%} %>


    <%ArrayList<String> saleslist = (ArrayList<String>) request.getAttribute("graph3");%>
      
   <script> 
    google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {

  var data = google.visualization.arrayToDataTable([
        ['Cars', 'Count of cars sold',],
    <% 
        int k =0;
        %>
        <%while (k<saleslist.size()){%>
                
          ['<%out.print(saleslist.get(k));%>',<%out.print(saleslist.get(k+1));%>],

          <%k=k+2;}%>
      
      ]);

      var options = {
        title: 'Total times cars were sold',
        chartArea: {width: '70%'},
     
        hAxis: {
          title: 'Count',
          minValue: 0
        },
        vAxis: {
          title: 'Cars'
        }
      };

      var chart = new google.visualization.BarChart(document.getElementById('chart_div3'));

      chart.draw(data, options);
    }
  </script>