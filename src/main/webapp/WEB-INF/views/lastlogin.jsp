<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<!-- Head part-->
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>HITS</title>
<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />


</head>

<body>
<div class="large-2 push-1 columns">
					<input type="text" placeholder="Find Vehicle">
				</div>
				<div class="large-2 push-1 columns">
					<a href="#" class="alert button expand">Search</a>
				</div>
	<div class="large-5 columns small-3" style="height: 17%;">
		<label>
		<br>
		<strong>
		<font color="white">Welcome	! </font>
		<font color="#1AB3BD"> ${userName} &nbsp;</font> 
		<font color="white">| last logged in :${lastLogin}</font>
		<a	href="/HITS-UI/login.do?isSignOut=true"> <font color="white">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;Sign Out</font></a>
		</strong>
		</label>
	</div>
</body>

</html>