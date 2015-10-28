<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Head part-->
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>HITS-Login Page</title>
<link rel="stylesheet" href="css/foundation.css" />

<link rel="stylesheet" href="css/normalize.css" />
<script src="js/vendor/modernizr.js"></script>
</head>
<!-- Body Part of html-->
<body>

	<!-- Header part-->
	<div id="header"></div><br>
	<!-- Body part-->
	<div class="row" style="opacity: 30;height:585px;border: solid;border-color: gainsboro;margin:0px;padding:10px;margin-left: 141px">
		<!--Slider part-->
		
		<!-- Login part-->
		<div class="large-3 push-8 columns">
			<br>
			<div class="row">
				<div class="th">
					<center><div class="section-container tabs" data-section>
						<h5 class="title">
							<strong><center>Login Here</center></strong>
						</h5>
						<div class="content" data-slug="panel1">
							<h6 style="color: #de4c4c">* ${msg}</h6>
							<form action="/HITS-UI/login.do" method="POST">
								<center>
									<!--Username -->
									<div class="large-11 columns">
										<br> <input type="text" id="username" name="userName"
											placeholder="Enter the UserName" required>
									</div>
								</center>
								<center>
									<!-- Password -->
									<div class="large-11 columns">
										<input type="password" id="password" name="password"
											placeholder="Enter the password" required>
									</div>
								</center>
								<br>
								<center>
									<button type="submit" class="radius button">Login</button>
								</center>
							</form>
						</div>
					</div></center>
				</div>
			</div>
			<br>
			<!-- Image displayed below the login form-->

			
		</div>
	</div>
	<!--Body part div ends here-->
	<!-- Footer of index.html-->
<br>
	<div id="footer"></div>
	<!--Scripts of the index.html -->
	<script>
		$(document).foundation({

			orbit : {
				animation : 'slide',
				timer_speed : 1000,
				pause_on_hover : true,
				animation_speed : 500,
				navigation_arrows : true,
				bullets : false
			},
			offcanvas : {
				open_method : 'move', // Sets method in which offcanvas opens, can also be 'overlap'
				close_on_click : true
			}

		});
	</script>
	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js">
		
	</script>
	<script src="js/foundation.js"></script>
	<script src="js/foundation.orbit.js"></script>
	<script src="js/brts/main.js"></script>
</body>
</html>