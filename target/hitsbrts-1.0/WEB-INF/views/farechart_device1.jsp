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

</head>


<c:if test="${empty msg}">
	<body>
</c:if>
<c:if test="${not empty msg}">
	<body onload="alertRouteMismatch()">
</c:if>



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
				<h1>Farechart</h1>
				<div class="large-4 columns">
					<!--- Side Form Starts here--->

					<form action="/HITS-UI/farechartupload.do?deviceName=DeviceType1"
						class="dummy" name="fareChart" enctype="multipart/form-data"
						method="POST">
						<fieldset>
							<legend>
								<strong>Details</strong><br>
							</legend>
							<!-- 	
									<label>Route Name :<br> <br> <select
										name="routename" id="routename" required>
											<option value="" disabled selected style="display: none;">Select your option</option>
											<option value="Route1">Route1</option>
											<option value="Route2">Route2</option>
											<option value="Route3">Route3</option>
											<option value="Route4">Route4</option>
									
									</select> <br> 
									</label>  -->
							<br> <label> A/C Fare :</label> <br> <br> <input
								id="myfile" name="acFile" type="file" /> <label> Non A/C
								Fare : </label> <br> <br> <input id="myfile" name="nonAcFile"
								type="file" /> <br>
							<button type="submit" class="radius button"
								onclick="alertUpload()">Upload</button>
							<button type="reset" class="radius button">Reset</button>
						</fieldset>
					</form>
				</div>
				<!--- Table Starts here--->
				<div class="large-8 columns">
					<br>
					<div style="width: 100%; height: 350px; overflow: scroll;">
						<table id="dataTable">
							<caption>
								<strong>Selected Items</strong>
							</caption>
							<tr>
								<th>Option</th>
								<th>Route Name</th>
								<th>Non A/c Fare</th>
							</tr>
						</table>
					</div>
					<center>
						<label> <br>
							<button type="submit" class="radius button"
								onclick="navigation()">Submit</button>
							<button type="button" class="radius button" onclick="deleteRow()">Clear</button>
							<button type="button" class="radius button"
								onclick="deleteAllRows(1)">Clear All</button>
						</label>
					</center>

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










