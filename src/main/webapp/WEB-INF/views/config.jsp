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
<title>HITS-System Config File</title>
<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />

<script type="text/javascript">
	function displayRouteType() {
		if ((document.getElementById("routeType").value) == "ac") {
			$(".actype").show();
			$(".nonactype").hide();
		}
		if ((document.getElementById("routeType").value) == "nonac") {
			$(".nonactype").show();
			$(".actype").hide();
		}

	}
</script>
</head>

<body>
	<!-- Header Part of the html-->
	<div id="header"></div>
	<!-- Body Part of the html-->
	<br>
	<div class="row" style="width: 100%">
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
					<div class="large-11 columns">
						<h1>Config File Details</h1>

						<div class="large-4 columns">

							<!--- Side Form Starts here--->

							<form action="/HITS-UI/Configfilehome.do?step_number=device_id"
								method="post" name="typedetails" id="typedetails">
								<fieldset>
									<legend>
										<strong>Step 1</strong><br> <br>
									</legend>
									<label>Device Types :<br> <br> <select
										name="device_type" id="device_type" required>
											<c:if test="${empty types}">
												<option value="" disabled selected style="display: none;">Select
													your option </option>
												<c:forEach items='${typeList}' var="type">
													<option value='${type.typeValue}'>${type.typeValue}</option>
												</c:forEach>

											</c:if>

											<c:if test="${not empty types}">
												<option value='${types}' disabled selected
													style="display: none;">${types}</option>
											</c:if>
									</select> <br> <br>
									</label>

									<center>
										<button type="submit" class="radius button" ${disabled2}
											${disabled3}>Next >></button>
									</center>

								</fieldset>
							</form>

							<!--- Table Starts here--->

							<div>
								<fieldset ${disabled1} ${disabled3}>
									<form action="/HITS-UI/Configfilehome.do?step_number=getData&device_type=${types}"
										method="post" name="typedetails" id="typedetails">

										<legend>
											<strong>Step 2 ${types}</strong><br> <br>
										</legend>
										<label>Devices :<br> <br> <select
											name="device_id" id="devices" required>
												<option value="" disabled selected style="display: none;">Select
													your option</option>

												<c:if test="${empty devices}">
													<c:forEach items='${deviceList}' var="device">
														<option value='${device.deviceID}'>${device.deviceID}</option>
													</c:forEach>

												</c:if>
												<c:if test="${not empty deviceId}">
													<option value='${deviceId}' disabled selected
														style="display: none;">${deviceId}</option>
												</c:if>

										</select> <br> <br>
										</label>

										<center>
											<button type="button" class="radius button"
												onclick="window.location.href='/HITS-UI/Configfilehome.do?step_number=device_type'"
												${disabled1} ${disabled3}><< Previous</button>
											<button type="submit" class="radius button" ${disabled1}
												${disabled3}>Next >></button>
										</center>
									</form>


								</fieldset>

								<br>

							</div>
						</div>
						<div class="large-8 columns" contenteditable="false">

							<form
								action="/HITS-UI/Configfilehome.do?step_number=generate_config&device_type=${types}&device_id=${configEntity.deviceId}"
								method="post" name="typedetails" id="typedetails">
								<fieldset ${disabled1} ${disabled2}>
									<legend>
										<strong>Step 3</strong><br> <br>
									</legend>

									<div class="large-4 columns">
										<label> Device Type :</label> <input id="deviceType"
											name="device_type" type="text" value='${types}'
											disabled="disabled" />
									</div>


									<div class="large-4 columns">
										<label> Device Id :</label> <input id="deviceId"
											name="device_id" type="text" value='${deviceId}'
											disabled="disabled" />
									</div>

									<div class="large-4 columns">
										<label> Config Sync Time:</label>
										<c:if test="${empty configEntity.configSyncTime}">
											<input id="syncTime" name="syncTime" type="text"
												value="Generated Automatically" disabled="disabled"
												readonly="readonly" />
										</c:if>
										<c:if test="${not empty configEntity.configSyncTime}">
											<input id="syncTime" name="syncTime" type="text"
												value='${configEntity.configSyncTime}' readonly="readonly" />
										</c:if>

									</div>

									<div class="large-4 columns">
										<label> Key B :</label> <input id="keyB" name="keyB"
											type="password" value='${configEntity.keyB}' disabled="disabled"/>
									</div>


									<div class="large-4 columns">
										<label> Config File Version : </label> <input id="fileVersion"
											name="fileVersion" type="text"
											value='${configEntity.fileVersion}' required>
									</div>
									<c:choose>
										<c:when
											test="${types=='ATVM' || types=='Tri Pod' || types=='Entry Fare Gate' || types=='Exit Fare Gate'}">
											<div class="large-4 columns">
												<label> Stop Id :</label> <input id="stopId" name="stopId"
													type="text" value='${configEntity.stopId}' />
											</div>
										</c:when>
										<c:otherwise>
											<div class="large-4 columns">
												<label> Stop Id :</label> <input id="stopId" name="stopId"
													type="text" value='${configEntity.stopId}' readonly />
											</div>
										</c:otherwise>
									</c:choose>


									<div class="large-4 columns">
										<label>Health Sync Interval(Minutes) :</label> <input
											id="healthSyncInterval" name="healthSyncInterval" type="text"
											value='${configEntity.healthSyncInterval}' required />
									</div>

									<div class="large-4 columns">
										<label>Data Sync Interval(Minutes) :</label> <input
											id="dataSyncInterval" name="dataSyncInterval" type="text"
											value='${configEntity.dataSyncInterval}' required />
									</div>
									<div class="large-4 columns">
										<label>Hits Request Password :</label> <input
											id="dataSyncInterval" name="hitsPassword" type="password"
											value='${configEntity.hitPassword}' readonly />
									</div>
									<div class="large-4 columns">
										<label>Bonus Percentage :</label> <input id="bonusPercentage"
											name="bonusPercentage" type="text"
											value='${configEntity.bonusPercentage}' />
									</div>
									<div class="large-4 columns">
										<label>CardBalanceValidity Duration(Months): </label> <input id="cardBalanceValidityDuration"
											name="cardBalanceValidityDuration" type="text"
											value='${configEntity.cardBalanceValidityDuration}' readonly/>
									</div>
									<div class="large-4 columns">
										<label>CardValidityDuration(Years):</label> <input id="cardValidityDuration"
											name="cardValidityDuration" type="text"
											value='${configEntity.cardValidityDuration}' readonly/>
									</div>
									<div class="large-4 columns">
										<label> A/C Minimum Fare(Rs.):</label> <input id="acminfare"
											name="acminfare" type="text"
											value='${configEntity.acMinimumFare}' required />
									</div>

									<div class="large-4 columns">
										<label> Non A/C Minimum fare(Rs.):</label> <input
											id="nonacminfare" name="nonacminfare" type="text"
											value='${configEntity.nonACMinimumFare}' required />
									</div>

									<div class="columns">
										<fieldset>
											<legend>Maximum fare </legend>

											<div class="large-5 columns">
												<label> Route Type</label> <select name="routeType"
													id="routeType" required onchange="displayRouteType()">
													<option value="" disabled selected style="display: none;">----
														Select the Type ----</option>
													<option value="ac">A/C Type</option>
													<option value="nonac">Non A/C Type</option>
												</select>

											</div>
											<div class="columns actype" style="display: none">
												<c:forEach items="${configEntity.fareDataList}" var="fare">
													<div class="large-4 columns">
														<label> ${fare.routeCode} :</label> <input
															id="AC${fare.routeCode}" name="AC${fare.routeCode}"
															type="text" value='${fare.maximumACFare}' />
													</div>
												</c:forEach>
											</div>

											<div class="columns nonactype" style="display: none">
												<c:forEach items="${configEntity.fareDataList}" var="fare">
													<div class="large-4 columns">
														<label> ${fare.routeCode} :</label> <input
															id="NonAc${fare.routeCode}" name="NonAc${fare.routeCode}"
															type="text" value='${fare.maximumNonACFare}' />
													</div>
												</c:forEach>
											</div>
										</fieldset>
									</div>
									<div class="columns push-3">
										<br>
										<button type="button" class="radius button"
											onclick="window.location.href='/HITS-UI/Configfilehome.do?step_number=device_id&device_type=${types}'"
											${disabled1} ${disabled2}><< Previous</button>
										<button type="submit" class="radius button"
											onclick="alertUpload()" ${disabled1} ${disabled2}>Generate
											File</button>
									</div>
									<br> <br>
								</fieldset>
							</form>

							<br>

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
	<script src="js/foundation.min.js">
		
	</script>
	<script src="js/foundation.js"></script>
	<script src="js/foundation.orbit.js"></script>
	<script src="js/brts/main.js"></script>
	<script src="js/brts/alerts.js"></script>

</body>
</html>
