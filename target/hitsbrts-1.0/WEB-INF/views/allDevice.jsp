<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<!-- Head part-->
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Front Page</title>
<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />
</head>
<body>
	<!-- Header Part of the html-->
	<div id="header"></div>
	<!-- Body Part of the html-->
	<br>
	<div class="row" style="height: 57%; width: 100%">
		<div class="off-canvas-wrap" data-offcanvas>
			<div class="inner-wrap">

				<section class="main-section">
					<nav class="tab-bar">
						<section class="left-small">
							<a class="left-off-canvas-toggle menu-icon" href="#"><span></span></a>
						</section>
						<section class="middle tab-bar-section">
							<h1 class="title">Menu</h1>
						</section>
						<div id="lastlogin"></div>
					</nav>
					<div id="navbar"></div>
					<!-- content goes here -->
					<div class="large-11 columns" style="height: 92.5%">
						<h1>Health Sync</h1>
						<br>
						<div class="large-6 push-3 columns">
							<form action="/HITS-UI/healthsync.do?type=history&opt=3"
								class="typedetails" name="typedetails" method="POST">
								<br>
								<br>
								<br>
								<fieldset>
									<legend>
										<strong>Device Type</strong><br>
										<br>
									</legend>
									<br>
									<br>
									<div class="large-6 small-6 columns">
										<input type="radio" name="types" value="bv">Bus	Validator<br>
										 <input type="radio" name="types" value="etvm">ETVM<br>
										  <input type="radio" name="types" value="afg">AFG<br>
										   <input type="radio" name="types" value="atvm">ATVM<br>
										<input type="radio" name="types" value="tripod">Tripod
									</div>
								</fieldset>
								<br>
								<br>
								<center>
									<button type="submit" class="radius button">Proceed</button>
								</center>
							</form>
						</div>
					</div>
				</section>
				<a class="exit-off-canvas"></a>
			</div>
		</div>
	</div>
	<!-- Footer part-->
	<br>
	<div id="footer"></div>
	<script src="js/vendor/modernizr.js"></script>
	<script src="js/foundation/wifi.js"></script>
	<script src="js/vendor/jquery.js"></script>
	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js"> </script>
	<script src="js/foundation.js"></script>
	<script src="js/foundation.orbit.js"></script>
	<script src="js/brts/main.js"></script>
	<script src="js/brts/alerts.js"></script>
</body>
</html>
