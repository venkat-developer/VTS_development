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
<title>HITS-Health Sync History Details</title>
<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />

</head>

<body>
	<!-- Header Part of the html-->
	<div id="header"></div>
	<!-- Body Part of the html-->
	<br>
	<div class="row" style="height: 65%; width: 100%">
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
						<h1>Health Status History</h1>
						<c:if test="${empty syncTime}">
							<br>
							<h1>No data is Available !!!</h1>

						</c:if>
						<c:if test="${not empty syncTime}">
							<div class="large-4 columns">
								<fieldset>

									<br> <br> <br> <strong>SyncTime :</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<button type="button" class="radius button expand">${syncTime}</button>
									<br> <br> <br>

									<c:if test="${not empty location}">
										<strong>Location :</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <button type="button" class="radius button expand">${location}</button>
										<br>
										<br>
										<br>
									</c:if>

									<c:if test="${not empty fareChartVersion}">
										<strong>Farechart Version :</strong>
										<button type="button" class="radius button expand">${fareChartVersion}</button>
										<br>
										<br>
										<br>
									</c:if>


									<c:if test="${not empty entryAFG}">
										<strong>Enrty AFG :</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <button type="button" class="radius button expand">${entryAFG}</button>
										<br>
										<br>
										<br>

									</c:if>

									<c:if test="${not empty exitAFG}">
										<strong>Exit AFG :</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <button type="button" class="radius button expand">${exitAFG}</button>
										<br>
										<br>

									</c:if>

									<br> <br>

								</fieldset>
							</div>

							<div class="large-4   columns">
								<fieldset>
									<br> <br> <strong><center>
											<h4>Device Type : ${deviceType}</h4>
										</center></strong><br> <br> <img
										src="http://www.brightview.net.cn/wp-content/uploads/2011/05/global-connectivity.jpg"
										height="1000%" width="100%" /> <br> <br> <br>
									<br>
								</fieldset>
							</div>

							<div class="large-4  columns">
								<fieldset>
									<br> <br>

									<c:if test="${not empty wifi}">
										<strong>Wi-Fi Strength: </strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                 <c:if test="${wifiStrength == 'success'}">
											<img src="http://images.knowhow.com/Computing/WiFi.jpg"
												height="10%" width="15%" title="High Signal">
										</c:if>
										<c:if test="${wifiStrength == 'alert'}">
											<img src="http://www.belden.com/images/Weak-Signal-Photo.jpg"
												height="10%" width="15%" title="Weak Signal">
										</c:if>
										<c:if test="${wifiStrength == 'moderate'}">
											<img src="http://techlozenge.com/images/wireless-symbol.png"
												height="10%" width="15%" title="Moderate Signal">
										</c:if>

										<br>
										<br>
										<br>
									</c:if>


									<c:if test="${not empty battery}">
										<strong>Battery Strength: </strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <c:if test="${batteryStrength == 'success'}">
											<img
												src="https://lh5.ggpht.com/HOEBFSSBSgiBsbhDpmw-eXVPqT8Fo1o3cI8cXbE82NVcePseP6g7sNBJcNbKDotf8A=w300"
												height="10%" width="15%" title="High Strength">
										</c:if>
										<c:if test="${batteryStrength == 'alert'}">
											<img
												src=" http://assets-02.app.lk/icons/4/e91726f6cf55bd52ffd9b9db5033fec3?size=200"
												height="10%" width="15%" title="Low Strength">
										</c:if>
										<c:if test="${batteryStrength == 'moderate'}">
											<img
												src="http://globalapk.com/uploads/posts/2014-06/1403727876_unnamed.png"
												height="10%" width="15%" title="Moderate Strength">
										</c:if>
										<br>
										<br>
										<br>
									</c:if>


									<c:if test="${not empty gps}">
										<img
											src="http://joesappfactory.com/public/media/apps/gps/logo.png"
											height="10%" width="15%">
										<strong>: </strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <button type="button" class="radius button expand">${gps}</button>
										<br>
										<br>
										<br>
									</c:if>


									<c:if test="${not empty config}">
										<strong>Config Version :</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <button type="button" class="radius button expand">${config}</button>
										<br>
										<br>
										<br>
									</c:if>


									<c:if test="${not empty tripod}">
										<strong>Tripod Reachability :</strong>&nbsp;&nbsp;
                  <button type="button" class="radius button expand">${tripod}</button>
									</c:if>



									<br> <br>

								</fieldset>

							</div>
							<br>
							<br>
						</c:if>
					</div>
					<br> <br> <br>
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
</body>
</html>










