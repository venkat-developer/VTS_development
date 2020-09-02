<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page language="java" import="java.util.*,org.json.simple.JSONValue"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>VTS-Home</title>

<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script src="https://maps.googleapis.com/maps/api/js"></script>
   <script>
  function initialize() {
    var mapCanvas = document.getElementById('map_Data');
    var mapOptions = {
      center: new google.maps.LatLng(12.123, 77.123),
      zoom: 3,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    var map = new google.maps.Map(mapCanvas, mapOptions);
  }
  google.maps.event.addDomListener(window, 'load', initialize);
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
				<div class="large-1 push columns" style="height:500px;overflow-y:scroll;width: 153px; overflow-x: visible;">
				<div style="background-image: linear-gradient(to bottom,#2ba6cb 0,#2ba6cb 100%);font-weight: bold;color: #FFF;height: 22px;padding-top: 2px;padding-left: 0px;width:115px">Vehicles List</div>
				<c:forEach items='${tripDeatils}' var='tripdata'>
					<a herf="#"><div style="border-radius: 10px; width:115px;overflow-wrap: initial;border-bottom-left-radius: 10px;border-bottom-right-radius: 10px;border-top-left-radius: 5px;border-top-right-radius: 5px">
					<h3 style="font-size:1em;font-size: 1em;font-weight: normal;border-top: 2px solid #CEDBE6;padding-left: 0px;margin-top: 0;margin-bottom: 0;padding-top: 2px;color: #000;">${tripdata.vehicleName}</h3>
					<ul><li><h1 style="font-size:.9em;">Driver Name : ${tripdata.driverName}</h1></li></ul>
					</div></a>
				</c:forEach>
				</div>
				<div class="large-10 columns">
					<center>
						<div class="orbit-container" id="map_Data" style ="height:500px">

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