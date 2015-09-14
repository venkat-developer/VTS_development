<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Head part-->
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>HITS-Upload Fare Chart Details</title>
<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />
<link rel="stylesheet" href="css/loader.css" />
 <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
$(window).load(function() {
	$(".loader").fadeOut("slow");
})
</script>
</head>
<c:if test="${empty msg}">
	<body>
</c:if>
<c:if test="${not empty msg}">
	<body onload="alertRouteMismatch()">
</c:if>
<div class="loader"></div>
<!-- Header Part of the html-->
<div id="header"></div>
<!-- Body Part of the html-->
<br>
<div class="row" style="height: 75%; width: 100%">
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
			<div class="large-11 columns" style="height: 93.5%">
				<h1>Farechart</h1>
				<div class="large-4 columns">
					<!--- Side Form Starts here--->
					<c:if test="${deviceType == 'stopwise'}">
					<form action="/HITS-UI/farechartupload.do?deviceName=DeviceType2"
						class="fareChart" name="fareChart" enctype="multipart/form-data"
						method="POST">
						<fieldset>
							<legend>
								<strong>Stop Details</strong><br> <br>
							</legend>
							<label>Stop Name :<br> 
							<input type="text" name="stopname" id="stopname" list="datalist1" required />
							 <datalist id="datalist1">
 							 <c:forEach items="${stopCodes}" var="stop">
								<option value="${stop.stopName}">${stop.stopName}</option>
							</c:forEach>
							 </datalist>
							<br><br>
							</label>
						</fieldset>
						<br>
						<fieldset>
							<legend>
								<strong>Details</strong><br> <br>
							</legend>
							<br> <label> A/C Fare :<br> <br> <input
								type="file" id="acfare" name="acfare" required />
							</label> <label> Non A/C Fare :<br> <br> <input
								type="file" id="nonacfare" name="nonacfare" required />
							</label> <br>
							<button type="submit" class="radius button"
								onclick="alertUpload()">Ok</button>
							<button type="reset" class="radius button"
								onclick="alertUpload()">Reset</button>
							<br> <br>
						</fieldset>
					</form>
					</c:if>
					
					<c:if test="${deviceType == 'routewise'}">
					<form action="/HITS-UI/farechartupload.do?deviceName=DeviceType3"
						class="fareChart" name="fareChart" enctype="multipart/form-data"
						method="POST">
						<fieldset>
						<legend>
								<strong>Route Details</strong><br> <br>
							</legend>
							<label>Route Name :<br> 
							<input type="text" name="routename" id="routename" list="datalist1" required />
							 <datalist id="datalist1">
 							 <c:forEach items='${routeNameList}' var="route">
								<option value='${route.routeCode}'>${route.routeCode}</option>
							</c:forEach>	
							<option value="all">All Routes</option>
							 </datalist>
							<br><br>
							</label>
						
						</fieldset>
						<br>
						<fieldset>
							<legend>
								<strong>Details</strong><br> <br>
							</legend>
							<br> <label> A/C Fare :<br> <br> <input
								type="file" id="acfare" name="acfare" required />
							</label> <label> Non A/C Fare :<br> <br> <input
								type="file" id="nonacfare" name="nonacfare" required />
							</label> <br>
							<button type="submit" class="radius button"
								onclick="alertUpload()">Ok</button>
							<button type="reset" class="radius button"
								onclick="alertUpload()">Reset</button>
							<br> <br>
						</fieldset>
					</form>
					</c:if>
				</div>
				<!--- Table Starts here--->
				<div class="large-8 columns">
					<br>
					<form action="javascript:void(0);" method="get" name="detailform">
						<div style="width: 100%; height: 450px; overflow: scroll;">
							<table id="dataTable">
								<caption>
									<strong>Selected Items</strong>
								</caption>
								<tr>
									<th>Option</th>
									<th>Route Name</th>
									<th>A/c Fare</th>
									<th>Non A/c Fare</th>
								</tr>
							</table>
						</div>
						<center>
							<label> <br>
								<button type="submit" class="radius button"
									onclick="enableopt()">Submit</button>
								<button type="button" class="radius button"
									onclick="deleteRow()">Clear</button>
								<button type="button" class="radius button"
									onclick="deleteAllRows(1)">Clear All</button>
							</label>
						</center>
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
<script src="js/foundation.min.js"> </script>
<script src="js/foundation.js"></script>
<script src="js/foundation.orbit.js"></script>
<script src="js/brts/main.js"></script>
<script src="js/brts/alerts.js"></script>
</body>
</html>
