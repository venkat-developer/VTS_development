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
<title>HITS-Health Sync</title>
<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />

</head>

<body>
	<!-- Header Part of the html-->
	<div id="header"></div>
	<!-- Body Part of the html-->
	<br>

	<div class="row" style="height: 75%; width: 100%">
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


					<div class="large-11 columns" style="height: 93.5%">
						<h1>Health Sync History</h1>


						<form action='${action}' class="typedetail" name="typedetail"
							method="POST">
							<div class="large-11 columns">


								<c:if test="${empty set}">
									<div class="large-6 columns">
										<fieldset>
											<legend>
												<strong>Type Details</strong><br> <br>
											</legend>

											<div class="large-4 small-6 columns">
												<img
													src="https://c2.staticflickr.com/2/1063/5101847091_8f7017dfd0_z.jpg"
													height="80%" width="50%"> <br>
												<br>
												<br> <input type="radio" value="ac" name="bustype"
													required>
												<h7>
												<strong> Prasanna Purple</strong></h7>
											</div>
											<div class="large-4 small-6 columns">
												<img
													src="http://img85.imageshack.us/img85/575/ahmedabadbrts.jpg"
													height="50%" width="50%"> <br>
												<br>
												<br> <input type="radio" value="nonac" name="bustype"
													required>
												<h7>
												<strong> Capital Roadways</strong></h7>
												<br>
											</div>
					    					<div class="large-4 small-6 columns">
												<img
													src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQYf5PLDp0w_c9unuYJhLbhOk0LO4yFmVx_vFL6xE4naTwXTdwG"
													height="50%" width="50%"> <br>
												<br> <br> <input type="radio" value="both"
													name="bustype" required>
												<h7>
												<strong> Both</strong></h7>

											</div>
										</fieldset>
									</div>

									<div class="large-6 columns">
										<fieldset>
											<legend>
												<strong>List of Routes</strong><br>
												<br>
											</legend>
											<br>
											<br>
											<div class="large-7 small-6 columns">
												<select name="route" id="route" required>
													<option value="" disabled selected style="display: none;">----
														Select the Route ----</option>
													<c:forEach items='${routelist}' var="route">
														<option value='${route.routeName}'>${route.routeName}</option>
													</c:forEach>
												</select>

											</div>
											<div class="large-4 small-6 columns">
												<img
													src="http://www.hillsofmorni.com/wp-content/uploads/2012/07/Morni-Route-Master.jpg"
													height="70%" width="80%"> <br>
											</div>
											<br>
											<br>
											<br>
											<br>
											<br>
											<br>
										</fieldset>
									</div>

								</c:if>

								<c:if test="${not empty set}">
									<div class="large-6 columns">
										<fieldset>
											<legend>
												<strong>Type Details</strong><br> <br>
											</legend>


											<c:if test="${typeDetails == 'ac'}">

												<div class="large-4 small-6 columns">
													<img
														src="https://c2.staticflickr.com/2/1063/5101847091_8f7017dfd0_z.jpg"
														height="80%" width="50%"> <br>
													<br>
													<br> <input type="radio" value="ac" name="bustype"
														checked="checked">
													<h7>
													<strong> Prasanna Purple</strong></h7>

												</div>
											</c:if>

											<c:if test="${typeDetails ne 'ac'}">

												<div class="large-4 small-6 columns">
													<img
														src="https://c2.staticflickr.com/2/1063/5101847091_8f7017dfd0_z.jpg"
														height="80%" width="50%"> <br>
													<br>
													<br> <input type="radio" value="ac" name="bustype">
													<h7>
													<strong> Prasanna Purple</strong></h7>

												</div>
											</c:if>

											<c:if test="${typeDetails == 'nonac'}">
												<div class="large-4 small-6 columns">

													<img
														src="http://img85.imageshack.us/img85/575/ahmedabadbrts.jpg"
														height="50%" width="50%"> <br>
													<br>
													<br> <input type="radio" value="nonac" name="bustype"
														checked="checked">
													<h7>
													<strong> Capital Roadways</strong></h7>
													<br>

												</div>
											</c:if>

											<c:if test="${typeDetails ne 'nonac'}">
												<div class="large-4 small-6 columns">

													<img
														src="http://img85.imageshack.us/img85/575/ahmedabadbrts.jpg"
														height="50%" width="50%"> <br>
													<br>
													<br> <input type="radio" value="nonac" name="bustype">
													<h7>
													<strong> Capital Roadways</strong></h7>
													<br>

												</div>
											</c:if>

											<c:if test="${typeDetails == 'both'}">
												<div class="large-4 small-6 columns">

													<img
														src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQYf5PLDp0w_c9unuYJhLbhOk0LO4yFmVx_vFL6xE4naTwXTdwG"
														height="50%" width="50%"> <br>
													<br> <br> <input type="radio" value="both"
														name="bustype" checked="checked">
													<h7>
													<strong> Both</strong></h7>

												</div>
											</c:if>
											<c:if test="${typeDetails ne 'both'}">
												<div class="large-4 small-6 columns">

													<img
														src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQYf5PLDp0w_c9unuYJhLbhOk0LO4yFmVx_vFL6xE4naTwXTdwG"
														height="50%" width="50%"> <br>
													<br> <br> <input type="radio" value="both"
														name="bustype">
													<h7>
													<strong> Both</strong></h7>

												</div>
											</c:if>
										</fieldset>
									</div>

									<div class="large-6 columns">
										<fieldset>
											<legend>
												<strong>List of Routes</strong><br>
												<br>
											</legend>
											<br>
											<br>
											<div class="large-7 small-6 columns">
												<select name="route" id="route">
													<option value="" disabled selected style="display: none;">
														${route}</option>
												</select>

											</div>
											<div class="large-4 small-6 columns">
												<img
													src="http://www.hillsofmorni.com/wp-content/uploads/2012/07/Morni-Route-Master.jpg"
													height="70%" width="80%"> <br>
											</div>
											<br>
											<br>
											<br>
											<br>
											<br>
											<br>
										</fieldset>
									</div>
								</c:if>



							</div>
							<div class="large-3 push-1 columns">
								<br>
								<br>
								<button type="submit" class="radius button">${button}</button>
							</div>
						</form>


						<div class="large-11 columns">
							<br>
							<br>
							<form action="/HITS-UI/healthsync.do?type=history&opt=1"
								class="typedetails" name="typedetails" method="POST">
								<div class="large-6 column">
									<fieldset>
										<legend>
											<strong>List of Buses</strong><br>
											<br>
										</legend>
										<br>
										<br>
										<div class="large-9 push-1 small-6 columns">

											<select name="stops" id="stops" required>

												<option value="" disabled selected style="display: none;">----
													Select the Bus Stops ----</option>

												<c:forEach items='${buslist}' var="bus">
													<option value='${bus}'>${bus}</option>
												</c:forEach>

											</select> <br>
											<br>
											<br>
											<br>
										</div>
									</fieldset>
								</div>
								<div class="large-6 columns">
									<fieldset>
										<legend>
											<strong>Device Type</strong><br>
											<br>
										</legend>
										<br>
										<br>
										<div class="large-7 small-6 columns">
											<input type="radio" name="types" value="bv">BV<br>
											<input type="radio" name="types" value="etvm">ETVM<br>
										</div>
									</fieldset>
								</div>
								<div class="large-4 push-1 columns">
									<br>
									<br>
									<center>
										<button type="submit" class="radius button">Proceed</button>
									</center>
									<br>
									<br>
									<br>
									<br>
								</div>
							</form>

						</div>
					</div>
		</section>
	</div>

	<a class="exit-off-canvas"></a>

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










