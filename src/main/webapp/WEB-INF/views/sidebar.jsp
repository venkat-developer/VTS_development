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
	
	<aside class="left-off-canvas-menu">
		<ul class="off-canvas-list">
			<li><label>Menu</label></li>
			<li><a href="/HITS-UI/home.do">Home</a></li>
			<li><a href="/HITS-UI/live.do">Live Data</a></li>
			<li><label>Reports</label></li>
			<li><a href="/HITS-UI/track.do?reportType=track">Trck</a></li>
			<li><a href="/HITS-UI/idle.do?reportType=idle">Idle</a></li>
			<li><a href="/HITS-UI/stats.do?reportType=stats">Stastics</a></li>
			<!--  <li><a href="/HITS-UI/driverhome.do">Driver</a></li> -->
			<li><a href="/HITS-UI/activity.do?reportType=activity">Activity</a></li>
			<li><a href="/HITS-UI/inputValidate.do?reportType=activity">Settings</a></li>
			<li><a href="/HITS-UI/login.do?isSignOut=true">Sign Out</a></li>

		</ul>
	</aside>

</body>
</html>