<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page language="java" import="java.util.*,org.json.simple.JSONValue"%>

<!DOCTYPE html>
<html>
<!-- Head part-->
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>HITS</title>
<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />

<script type="text/javascript">
	$(document).ready(function() {
		$('input[type="radio"]').click(function() {
			if ($(this).attr("value") == "day") {
				$(".to").hide();
				$(".from").hide();
				$(".fhrs").hide();
				$(".fmins").hide();
				$(".fsecs").hide();
				$(".toread").hide();
			}
			if ($(this).attr("value") == "custom") {
				$(".from").show();
				$(".to").show();
				$(".fhrs").show();
				$(".fmins").show();
				$(".fsecs").show();
				$(".toread").hide();
			}
		});
	});
</script>

<script>
	function displayDate() {

		var today = document.getElementById("from").value.split('-');
		var dat = new Date();
		dat.setFullYear(today[0]);
		dat.setMonth(today[1]);
		dat.setDate(today[2]);
		dat.setDate(dat.getDate() + 7);
		document.getElementById("toread").value = dat.getMonth() + "/"
				+ dat.getDate() + "/" + dat.getFullYear();
	}
</script>
</head>

<body>
		<form action="/HITS-UI/activity.do?reportType=idle" method="post" name="filters" id="filters">
		<div class="large-2 push-1 columns" style="color:black">
			<select name="vehicleId" style="padding: 0px;">
			<c:forEach items='${vehiclesList}' var='vehicleData'> 
				<option value="${vehicleData.id.id}">${vehicleData.displayName}</option>
			</c:forEach>
			</select>
		</div>
	<div class="large-2 push-1 columns">
			<!-- <a href="#" class="alert button expand">Search</a> -->
		</div>
		<div class="large-2 push-1 columns">
			<ul class="button-group round toggle" data-toggle="buttons-radio">
				<li>
					<input type="radio" id="r1" name="r-group" data-toggle="button" value="today">
					<label class="button" for="r1">Today</label>
				</li>
				<li>
					<input type="radio" id="r3" name="r-group" data-toggle="button" value="custom">
					<label class="button" for="r3">Custom</label>
				</li>
			</ul>
		</div>
		<div class="large-3 push-1 columns">
		<button type="submit" class="radius button">Generate</button>
		</div>
	<label>
		<br>
		<strong>
		<font color="white">Welcome	! </font>
		<font color="#1AB3BD"> ${userName} &nbsp;</font> 
		<font color="white">| last logged in :${lastLogin}</font>
		</strong>
	</label>
	<div class="large-12 columns small-3" style="height: 17%;">
			<div class="columns from" style="marging-left:75px;display: none;">
						<div class="small-1 columns" style="width:68px;color:black;"><strong>From : </strong></div>
						<div class="large-3 columns" style="margin-top: 5px;width:270px">
							<input type="date" name="from" id="from" style="width: 260px;" required onchange="displayDate()">
						</div>
						<!-- From Hours Start ...-->
						<div class="large-1 columns fhrs" style="margin-top: 5px;">
													 <select name="fhrs" id="fhrs" style="color: black;padding: 2px" required>
														<option value="00" disabled selected
															style="display: none;">00</option>
														<%
															int hourCount = 0;
															while (hourCount < 24) {
																if (hourCount < 10) {
																	String hrsValue = "0" + String.valueOf(hourCount);
														%>
														<option value=<%out.println(hrsValue);%>>
															<%
																out.println(hrsValue);
															%>
														</option>
														<%
															} else {
														%>
														<option value=<%out.println(hourCount);%>>
															<%
																out.println(hourCount);
															%>
														</option>
														<%
															}
																hourCount++;
															}
														%>
													</select>
						</div>
						<!-- From Hours End ...-->
						<!-- From Minutes Start ...-->
						<div class="large-1 columns fmins" style="margin-top: 5px;">
													<select name="fmin" id="fmin" style="color: black;padding: 2px" required>
														<option value="00" disabled selected
															style="display: none;">00</option>
														<%
															int minCount = 0;
															while (minCount < 60) {
																if (minCount < 10) {
																	String value = "0" + String.valueOf(minCount);
														%>
														<option value=<%out.println(value);%>>
															<%
																out.println(value);
															%>
														</option>
														<%
															} else {
														%>
														<option value=<%out.println(minCount);%>>
															<%
																out.println(minCount);
															%>
														</option>
														<%
															}
																minCount++;
															}
														%>
													</select>
						</div>
						<!-- From Minutes End  ...-->
						<!-- From Seconds Start ...-->
						<div class="large-1 columns fsecs" style="margin-top: 5px;">
													 <select name="fsec" id="fsec" style="color: black;padding: 2px" required>
														<option value="00" disabled selected
															style="display: none;">00</option>
														<%
															int secCount = 0;
															while (secCount < 60) {
																if (secCount < 10) {
																	String value = "0" + String.valueOf(secCount);
														%>
														<option value=<%out.println(value);%>>
															<%
																out.println(value);
															%>
														</option>
														<%
															} else {
														%>
														<option value=<%out.println(secCount);%>>
															<%
																out.println(secCount);
															%>
														</option>
														<%
															}
																secCount++;
															}
														%>
													</select>
						</div><!-- From seocnds end ... -->
						<div class="small-1 columns" style="width:46px;color:black;"><strong>To : </strong></div>
						<div class="large-3 columns" style="margin-top: 5px;width:270px">
							<input type="date" name="to" id="to" style="width: 260px;" required>
						</div>
							<div class="large-1 columns" style="margin-top: 5px;">
									<select name="thrs" id="thrs" style="color: black;padding: 2px">
														<option value="23" disabled selected
															style="display: none;">23</option>
														<%
															hourCount = 0;
															while (hourCount < 24) {
																if (hourCount < 10) {
																	String hrsValue = "0" + String.valueOf(hourCount);
														%>
														<option value=<%out.println(hrsValue);%>>
															<%
																out.println(hrsValue);
															%>
														</option>
														<%
															} else {
														%>
														<option value=<%out.println(hourCount);%>>
															<%
																out.println(hourCount);
															%>
														</option>
														<%
															}
																hourCount++;
															}
														%>
													</select>
							</div>
							<div class="large-1 columns" style="margin-top: 5px;">
													<select name="tmin" id="tmin" style="color: black;padding: 2px">
														<option value="59" disabled selected
															style="display: none;">59</option>
														<%
															minCount = 0;
															while (minCount < 60) {
																if (minCount < 10) {
																	String value = "0" + String.valueOf(minCount);
														%>
														<option value=<%out.println(value);%>>
															<%
																out.println(value);
															%>
														</option>
														<%
															} else {
														%>
														<option value=<%out.println(minCount);%>>
															<%
																out.println(minCount);
															%>
														</option>
														<%
															}
																minCount++;
															}
														%>
													</select>
							</div>
							<div class="large-1 columns" style="margin-top: 5px; ">
													<select name="tsec" id="tsec" style="color: black;padding: 2px">
														<option value="59" disabled selected
															style="display: none;">59</option>
														<%
															secCount = 0;
															while (secCount < 60) {
																if (secCount < 10) {
																	String value = "0" + String.valueOf(secCount);
														%>
														<option value=<%out.println(value);%>>
															<%
																out.println(value);
															%>
														</option>
														<%
															} else {
														%>
														<option value=<%out.println(secCount);%>>
															<%
																out.println(secCount);
															%>
														</option>
														<%
															}
																secCount++;
															}
														%>
													</select>
							</div>
							<div class="large-1 columns" style="margin-top:0px;width:90px;">
							
							</div>
		</form>
												
			</div>
										<div class="columns toread" style="display: none">
												<div class="large-6 columns">
													<label><strong>To :</strong></label> <br> <input
														type="text" name="toread" id="toread"
														style="width: 260px;" readonly placeholder="mm/dd/yyyy">
												</div>

											</div>

</body>

</html>