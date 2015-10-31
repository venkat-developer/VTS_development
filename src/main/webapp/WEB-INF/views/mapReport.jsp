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
<script src="js/brts/InfoBubble.js"></script>
 
   <script>
   var mapCanvas ;
   var map1=false ;
   var markersArray =[];
   var _aPolylines = null
   var mapObject = null;
   function loadMap(){
   var mapCanvas = document.getElementById('map_Data');
		var mapOptions = {center: new google.maps.LatLng(12.123, 77.123),
						  zoom: 4,
						  mapTypeId: google.maps.MapTypeId.ROADMAP
						}
		map = new google.maps.Map(mapCanvas,mapOptions);
		map1=true;
   mapObject = map;
  }
function addMapMarkers(data){
	if(!map1){
		var mapCanvas = document.getElementById('map_Data');
		var mapOptions = {center: new google.maps.LatLng(12.123, 77.123),
						  zoom: 4,
						  mapTypeId: google.maps.MapTypeId.ROADMAP
						}
		map = new google.maps.Map(mapCanvas,mapOptions);
		map1=true;
		mapObject = map;
	}
	
	
		var marker = new google.maps.Marker({
          map: map,
          position: new google.maps.LatLng(data.latitude,data.longitude),
          title: 'Track Point # '+markersArray.length,
		  icon:"img/vehicles/360s.png",
		  draggable: false
        });
        var infoWindow = new InfoBubble({
          maxWidth: 300
        });
    var div = document.createElement('DIV');
        div.style.color ="#FFFFFF";
		div.style.fontSize ="22px";
		div.innerHTML += '<b>Latitude : </b>'+data.latitude+'<br>';
		div.innerHTML += '<b>Longitude : </b>'+data.longitude+'<br>';
		div.innerHTML += '<b>Speed : </b>'+data.speed+'<br>';
		div.innerHTML += '<b>GSM : </b>'+data.gsmStrength+'<br>';
		div.innerHTML += '<b>GPS : </b>'+data.gpsStrength+'<br>';
		div.innerHTML += '<b>Reported Time : </b>'+data.occurredat
		
        infoWindow.addTab('Track Point Info', div);
        //infoBubble.addTab('Uluru', contentString);
    new google.maps.event.addListener(marker, 'click', function() {
          if (!infoWindow.isOpen()) {
            infoWindow.open(map, marker);
          }else{
			  infoWindow.close();
		  }
          });
	markersArray.push({lat: data.latitude, lng: data.longitude});	
	}
	function drawPath(){
		for(var k =0;k<markersArray.length;k++){
				
	}
		var vehiclePath = new google.maps.Polyline({
			path: markersArray,
			geodesic: true,
			strokeColor: '#FF0000',
			strokeOpacity: 1.0,
			strokeWeight: 1
		});
		vehiclePath.setMap(mapObject);
		markersArray=[];		
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
				<form action="/HITS-UI/track.do" method="post" name="filters" id="filters">
						<div id="lastlogin"></div>
						</form>
				<div id="track"></div>
				</nav>
				<div id="navbar"></div>
				<section class="main-section"> <!-- content goes here -->
				<br>
			
				<div class="large-12 columns">
						<div class="orbit-container" id="map_Data" style ="height:500px;border: solid;border-color: gainsboro;margin:0px">
							<c:if test="${empty trackData}">
							<script>
							loadMap();
							</script>
							</c:if>
							<c:forEach items='${trackData}' var='trackData'> 
								<script>
								var rawData = {
												vehicleName : '${tripdata.vehicleName}',
												latitude : ${trackData.location.getFirstPoint().getX()},
												longitude : ${trackData.location.getFirstPoint().getY()},
												gsmStrength : ${trackData.gsmSignal},
												gpsStrength : ${trackData.gpsSignal},
												batteryVoltage : ${trackData.batteryVoltage},
												course : ${trackData.direction},
												speed : ${trackData.speed},
												occurredat : '${trackData.occurredat}',
											}
								addMapMarkers(rawData);
								</script>
							</c:forEach>
							<script>
							drawPath();
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