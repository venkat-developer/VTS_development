<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>VTS-Home</title>

<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">

      // Load the Visualization API and the piechart package.
      google.load('visualization', '1.0', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
     // google.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
	  //(${vehiclesonlinecount},${vehiclesoffroadcount},${vehiclesofflinecdccount},${vehiclesofflinelowgpscount},${vehiclesofflinelowgsmcount},${vehiclesofflinecount});
      function drawChart(vehiclesonlinecount,vehiclesoffroadcount,vehiclesofflinecdccount,vehiclesofflinelowgpscount,vehiclesofflinelowgsmcount,vehiclesofflinecount) {
		//alert('You have called me '+onLineCount+' offline count'+offlinecount);
        // Create the data table.
         var data = google.visualization.arrayToDataTable([
          ['Status', 'No.of Vehicles'],
          ['Online',     vehiclesonlinecount],
          ['Offroad',      vehiclesoffroadcount],
		  ['Charger Disconnected',      vehiclesofflinecdccount],
		  ['Low GPS',      vehiclesofflinelowgpscount],
		  ['Low GSM',      vehiclesofflinelowgsmcount],
		  ['Offline',      vehiclesofflinecount]
        ]);

        // Set chart options
		var options = {'title':'How Much Pizza I Ate Last Night',
						title: 'My Daily Activities',
						pieHole: 0.4,
                       'width':600,
                       'height':600};
		// Instantiate and draw our chart, passing in some options.
        
		var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
		//var chart = new google.visualization.ScatterChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>

</head>

<body>
	<!-- Header Part of the html-->
	<div id="header"></div>
	<!-- Body Part of the html-->
	<br>
	<div class="row" style="width: 100%">
		<div class="off-canvas-wrap" data-offcanvas>
			<div class="inner-wrap">
				<nav class="tab-bar"> <section class="left-small"> <a
					class="left-off-canvas-toggle menu-icon" href="#"><span></span></a>
				</section> <section class="middle tab-bar-section">
				<h1 class="title">Menu</h1>
				</section>
				<div id="lastlogin"></div>
				</nav>
				<div id="navbar"></div>
				<section class="main-section"> <!-- content goes here -->
				<br>
				<br>
				<div class="large-9 push-1 columns">
					<center>
						<div id ="chart_div" class="orbit-container" style ="height:500px">
							<script>
							drawChart(${vehiclesonlinecount},${vehiclesoffroadcount},${vehiclesofflinecdccount},${vehiclesofflinelowgpscount},${vehiclesofflinelowgsmcount},${vehiclesofflinecount});
							</script>
						</div>
					
					</center>
					<br>
				</div>
				</section>
				<a class="exit-off-canvas"></a>
			</div>
		</div>
	</div>
	<br>
	<!-- Footer of the Google app html-->
	<div id="footer"></div>
	<script src="js/vendor/modernizr.js"></script>
	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js">
		
	</script>
	<script src="js/foundation.js"></script>
	<script src="js/foundation.orbit.js"></script>
	<script src="js/brts/main.js"></script>
</body>
</html>