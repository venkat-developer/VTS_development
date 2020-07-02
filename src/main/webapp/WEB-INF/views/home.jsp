<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>VTS-Home</title>

<link rel="stylesheet" href="resources/css/foundation.css" />
<link rel="stylesheet" href="resources/css/normalize.css" />
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
				<div class="large-12 columns">
					<center>
						<div id ="chart_div" class="orbit-container" style ="height:500px;border: solid;border-color: gainsboro;margin:0px">
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
	<script src="resources/js/vendor/modernizr.js"></script>
	<script src="resources/js/vendor/jquery.js"></script>
	<script src="resources/js/foundation.min.js">
		
	</script>
	<script src="resources/js/foundation/foundation.js"></script>
	<script src="resources/js/foundation/foundation.orbit.js"></script>
	<script src="resources/js/brts/main.js"></script>
</body>
</html>