<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<!-- Head part-->
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>HITS-Error Page</title>
<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />

</head>
<body>
	<!-- Header Part of the html-->
	<div id="header"></div>
	<!-- Body Part of the html-->
	<br>

	<div class="row" style="height: 50%; width: 100%">
		<section class="main-section">
			<div class="off-canvas-wrap" data-offcanvas>
				<div class="inner-wrap">
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
					<div class="large-11 columns">
						<br>
						<br>
						<div class="large-10 push-1 columns " style="height: 75%">
							<br>
							<form>
								<fieldset>
									<legend>
										<h3 style="color: red;">
											<img src="img/error.png" height="30" width="30" /> Error
										</h3>
									</legend>
									<div class="push-1">
										<p style="color: red;">
											<br> <strong>Error In :</strong> ${errorHeading} API <br>
											<strong>Exception :</strong> ${errorException} <br> <strong>Message
												:</strong> ${errorMsg }
										</p>
										<br>
										<br>
									</div>
								</fieldset>
							</form>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br> <br> <br>
							<br>
							<br>
						</div>
						<br>
						<br>
						<br> <br>
						<br>
						<br>
					</div>
				</div>
			</div>
		</section>
	</div>
	<a class="exit-off-canvas"></a>
	<!-- Footer part-->
	<br>
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