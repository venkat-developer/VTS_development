<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- Head part-->
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>HITS-Upload Fare Chart Details</title>
<link rel="stylesheet" href="css/foundation.css" />

<link rel="stylesheet" href="css/normalize.css" />

</head>
<body>
	<!-- Header Part of the html-->
	<div id="header"></div>
	<!-- Body Part of the html-->
	<br>
	<div class="row" style="height: 60%; width: 100%">
		<div class="off-canvas-wrap" data-offcanvas>
			<div class="inner-wrap">
				<nav class="tab-bar"> <section class="left-small"> <a
					class="left-off-canvas-toggle menu-icon" href="#"><span></span></a>
				</section> <section class="middle tab-bar-section">
				<h1 class="title">Menu</h1>
				</section> <div id="lastlogin"></div></nav>
				<div id="navbar"></div>
				<section class="main-section"> <!-- content goes here -->
				<div class="large-11 columns" style="height: 92.5%">
					<h1>Fare Chart</h1>
					<br> <br>
					<div class="large-5 push-1 columns">
						<!--- Device type1 Form Starts here--->
						
						<!-- 
						 Device Type 1 - Unified
						 Device Type 2 - Stopwise Farechart
						 Device Type 3 - Routewise Farechart						
						 -->
						<form action="/HITS-UI/farechartupload.do">
							<fieldset>
								<legend>
									<strong>Device Type</strong><br> <br>
								</legend>
								<label>Device Name :<br> <br> <select
									name="devicename" id="devicename"
									onchange="window.open(this.options[this.selectedIndex].value,'_top')"
									required>
										<option value="" disabled selected style="display: none;">----
											Select the device ----</option>
										<option
											value="/HITS-UI/farechartupload.do?deviceName=DeviceType1">Unified</option>
										<option
											value="/HITS-UI/farechartupload.do?deviceName=DeviceType2">Stopwise Farechart</option>
										<option
											value="/HITS-UI/farechartupload.do?deviceName=DeviceType3">Routewise Farechart</option>	
								</select>
								</label> <br> <br>
							</fieldset>
						</form>
					</div>
					<div class="large-4 columns">
						<!--- Display Form Starts here--->
						<form action="/HITS-UI/farechartupload.do?report=set">
							<fieldset>
								<legend>
									<strong>Display</strong><br> <br>
								</legend>
								<label>Select the type to Display :<br> <br> <select
									name="devicename" id="devicename" required>
										<option value="" disabled selected style="display: none;">----
											Select the content ----</option>
										<option value="Device1">Device1</option>
										<option value="Device2">Device2</option>
										<option value="Device3">Device3</option>
										<option value="Device4">Device4</option>
										<option value="Device4">View All</option>
								</select> <br> <br>
								</label>
								<center>
									<button type="submit" class="radius button">Go</button>
								</center>
								<br> <br>
							</fieldset>
						</form>
					</div>
				</div>
				</section>
				<a class="exit-off-canvas"></a>
			</div>
		</div>
	</div>
	<!-- Footer of the Google app html-->
	<div id="footer"></div>
	<script src="js/vendor/modernizr.js"></script>
	<script src="js/brts/farechart.js"></script>
	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js"></script>
	<script src="js/foundation.js"></script>
	<script src="js/foundation.orbit.js"></script>
	<script src="js/brts/main.js"></script>
</body>
</html>










