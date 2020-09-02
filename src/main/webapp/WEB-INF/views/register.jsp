<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Head part-->
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Travel management Login Page</title>
<link rel="stylesheet" href="css/foundation.css" />

<link rel="stylesheet" href="css/normalize.css" />
<script src="js/vendor/modernizr.js"></script>
</head>
<!-- Body Part of html-->
<body>

	<br>
	<br>
	<br>
	<!-- Header part-->
	<div id="header"></div><br>
	<!-- Body part-->
	<div class="row" style="opacity: 30">
		<br> <br>
		<!--Slider part-->
		<div class="large-9 push-3 columns" style="opacity: 10">
			<center>
				<div class="orbit-container">
<!-- 					<ul data-orbit -->
<!-- 						data-options="animation:slide; -->
<!--                                       pause_on_hover:true; -->
<!--                                       animation_speed:500; -->
<!--                                       navigation_arrows:true; -->
<!--                                       bullets:false;"> -->
<!-- 						<li><img src="img/home1.jpg" alt="slide 1" height="3600" -->
<!-- 							width="900" /></li> -->
<!-- 						<li><img src="img/home2.jpg" alt="slide 1" height="3600" -->
<!-- 							width="900" /></li> -->
<!-- 						<li><img src="img/home3.jpg" alt="slide 1" height="3600" -->
<!-- 							width="900" /></li> -->
<!-- 					</ul> -->
				</div>
			</center>
			<br>
		</div>
		<!-- Login part-->
		<div class="large-3 pull-9 columns">
			<br>
			<div class="row">
				<div class="th">
					<div class="section-container tabs" data-section>
						<h5 class="title">
							<strong><center>Login Here</center></strong>
						</h5>
						<div class="content" data-slug="panel1">
							<h6 style="color: #de4c4c">* ${msg}</h6>
							<form action="/HITS-UI/register.do" method="POST">
								<center>
									<!--Username -->
									<div class="large-11 columns">
										<br> <input type="text" id="username" name="userName"
											placeholder="Enter the UserName" required>
									</div>
								</center>
								<center>
									<!--First name -->
									<div class="large-11 columns">
										<br> <input type="text" id="firstName" name="firstName"
											placeholder="Enter the First Name" required>
									</div>
								</center>
								
								<center>
									<!--Last name name -->
									<div class="large-11 columns">
										<br> <input type="text" id="lastName" name="lastName"
											placeholder="Enter the Last Name">
									</div>
								</center>
								
								<center>
									<!-- Password -->
									<div class="large-11 columns">
										<input type="password" id="password" name="password"
											placeholder="Enter the password" required>
									</div>
								</center>
								<center>
									<!-- Confirm Password -->
									<div class="large-11 columns">
										<input type="password" id="confirmpassword" name="confirmpassword"
											placeholder="Confirm password" required>
									</div>
								</center>
								<center>
									<!-- Phone -->
									<div class="large-11 columns">
										<input type="text" id="phone" name="phone"
											placeholder="Enter the password" required>
									</div>
								</center>
								<br>
								<center>
									<!-- Email -->
									<div class="large-11 columns">
										<input type="text" id="emial" name="emial"
											placeholder="Email" required>
									</div>
								</center>
								<br>
								<center>
									<!-- Address -->
									<div class="large-11 columns">
										<input type="text" id="address" name="address"
											placeholder="Address" required>
									</div>
								</center>
								<br>
								<center>
									<button type="submit" class="radius button">Register</button>
								</center>
							</form>
						</div>
					</div>
				</div>
			</div>
			<br>
			<!-- Image displayed below the login form-->

			<img
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEbsXy-ZiBF44bzEeaeZlrpwjbkhRpvJnejYq_tlG5xf2lCse3tg"
				alt="slide 1" height="3600" width="900" />
		</div>
	</div>
	<!--Body part div ends here-->
	<!-- Footer of index.html-->

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