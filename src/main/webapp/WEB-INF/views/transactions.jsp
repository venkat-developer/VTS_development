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
<title>HITS-Transaction Report</title>
<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />
<script src="js/vendor/modernizr.js"></script>
<script src="js/vendor/jquery.js"></script>
<script src="js/foundation.js"></script>
<script src="js/foundation.min.js"></script>
<script src="js/foundation.orbit.js"></script>
<script src="js/brts/main.js"></script>
<script src="js/sorttable.js"></script>
<script src="js/brts/tablefilter.js"></script>
<script src="js/brts/report.js"></script>
<script>
	var table3Filters = {
		col_0 : "select",
		col_5 : "none",
		btn : true
	}
	var tf03 = setFilterGrid("dataTable", 2, table3Filters);
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('input[type="radio"]').click(function() {
			if ($(this).attr("value") == "day") {
				$(".to").hide();
				$(".from").show();
				$(".fhrs").hide();
				$(".fmins").hide();
				$(".fsecs").hide();
				$(".toread").hide();
			}
			if ($(this).attr("value") == "week") {
				$(".to").hide();
				$(".from").show();
				$(".fhrs").hide();
				$(".fmins").hide();
				$(".fsecs").hide();
				$(".toread").show();

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
	<%
		int rowCount = 0;
	%>
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
						<section class="right-small">
							<a class="right-off-canvas-toggle menu-icon" href="#"><span></span></a>
						</section>
						<div id="lastlogin"></div>
					</nav>
					<div id="navbar"></div>
					<aside class="right-off-canvas-menu">
						<ul class="off-canvas-list">
							<li><label>ReportOptions</label></li>
							<li><label>Export To</label></li>
							<li><a
								href="/HITS-UI/reportsgen.do?reportOption=csv&heading=${heading}&from=${from}&to=${to}&operatortype=${operatortype}&reportType=${reportType}&fhrs=${fhrs}
								&fmin=${fmin}&fsec=${fsec}&thrs=${thrs}&tmin=${tmin}&tsec=${tsec}&timefilter=${timefilter}">
									&nbsp;&nbsp;<img src="img/CSV.png" height="30" width="40"
									title="csv" />&nbsp;&nbsp;&nbsp;Csv Format
							</a></li>
							<li><a
								href="/HITS-UI/reportsgen.do?reportOption=pdf&heading=${heading}&from=${from}&to=${to}&operatortype=${operatortype}&reportType=${reportType}&fhrs=${fhrs}
								&fmin=${fmin}&fsec=${fsec}&thrs=${thrs}&tmin=${tmin}&tsec=${tsec}&timefilter=${timefilter}">
									&nbsp;&nbsp;<img src="img/PDF.jpeg" height="30" width="40"
									title="pdf" />&nbsp;&nbsp;&nbsp;Pdf Format
							</a></li>
							<li><a
								href="/HITS-UI/reportsgen.do?reportOption=excel&heading=${heading}&from=${from}&to=${to}&operatortype=${operatortype}&reportType=${reportType}&fhrs=${fhrs}
								&fmin=${fmin}&fsec=${fsec}&thrs=${thrs}&tmin=${tmin}&tsec=${tsec}&timefilter=${timefilter}">
									&nbsp;&nbsp;<img src="img/excel.jpg" height="30" width="40"
									title="excel" />&nbsp;&nbsp;&nbsp;Excel Format
							</a></li>
							<!-- 	<li><label>Print reportOptions</label>
							<li
								onclick="openTransactionPrint('${heading}','${from}',,'${to}','${operatortype}','${reportType}')"><a
								href=" "> &nbsp;&nbsp;<img src="img/printer.jpg" height="30"
									width="40" title="print" />&nbsp;&nbsp;&nbsp;Print
							</a></li>
							<li
								onclick="openTransactionPreview('${heading}','${from}','${to}','${operatortype}','${reportType}')"><a
								href=""> &nbsp;&nbsp; <img src="img/printpreview.png"
									height="30" width="40" title="Print Preview" />&nbsp;&nbsp;&nbsp;Print
									Preview
							</a></li> -->
						</ul>
					</aside>

					<!-- content goes here -->

					<div class="large-14 columns" style="height: 100%">
						<div class="large-14 columns">
							<div class="large-3 columns">
								<br> <br> <br>
								<h3>Transaction Reports</h3>
							</div>
							<div class="large-9 columns">
								<br>
								<form action="/HITS-UI/transaction.do?report=set" method="post"
									name="filters" id="filters">
									<fieldset>
										<legend>Filter</legend>
										<div class="large-7 columns">
											<div class="columns time">
												<div class="large-6 columns">
													<label><strong>Time :</strong></label>
												</div>
												<div class="columns">
													<div class="large-3 push-1 columns">
														<input type="radio" name="timefilter" value="day">
														Day
													</div>
													<div class="large-3 push-1 columns">
														<input type="radio" name="timefilter" value="week">
														Week
													</div>
													<div class="large-4 columns">
														<input type="radio" name="timefilter" value="custom">
														Custom
													</div>
												</div>
											</div>
											<div class="columns from" style="display: none">
												<div class="large-7 columns">
													<label><strong>From :</strong></label>
												</div>
												<div class="large-6 columns">
													<br> <input type="date" name="from" id="from"
														style="width: 260px;" required onchange="displayDate()">
												</div>
												<div class="large-2 columns fhrs">
													<label>Hrs :</label> <select name="fhrs" id="fhrs" required>
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
												<div class="large-2 columns fmins">
													<label>Min :</label> <select name="fmin" id="fmin" required>
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
												<div class="large-2 columns fsecs">
													<label>Sec :</label> <select name="fsec" id="fsec" required>
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
												</div>
											</div>
											<div class="columns to" style="display: none">
												<div class="large-7 columns">
													<label><strong>To :</strong></label>
												</div>
												<div class="large-6 columns">
													<br> <input type="date" name="to" id="to"
														style="width: 260px;">
												</div>
												<div class="large-2 columns">
													<label>Hrs :</label> <select name="thrs" id="thrs">
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
												<div class="large-2 columns">
													<label>Min :</label> <select name="tmin" id="tmin">
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
												<div class="large-2 columns">
													<label>Sec :</label> <select name="tsec" id="tsec">
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
											</div>
											<div class="columns toread" style="display: none">
												<div class="large-6 columns">
													<label><strong>To :</strong></label> <br> <input
														type="text" name="toread" id="toread"
														style="width: 260px;" readonly placeholder="mm/dd/yyyy">
												</div>

											</div>
										</div>
										<div class="large-5 columns">
											<div class="columns">
												<label><strong>Operator :</strong></label> <select
													name="operatortype" id="operatortype" required>
													<c:forEach items='${operatorList}' var="operator">
														<option value='${operator.operatorId}' selected>${operator.operatorName}</option>
													</c:forEach>
												</select>
											</div>
											<div class="columns">
												<br> <br> <label><strong>Report
														Type : </strong></label><br>
												<div class="large-5 push-1 columns">
													<input type="radio" name="reportType" value="detailed">Detailed
													Report
												</div>
												<div class="large-6 columns">
													<input type="radio" name="reportType" value="summary">Summary
													Report
												</div>
											</div>
										</div>
										<!-- 
										<div class="large-4 columns">
											<label><strong>Transaction Type :</strong></label> <select
												name="transactiontype" id="transactiontype" required>
												<option value="" disabled selected style="display: none;">Select
													your option</option>
												<option value="depot">Depot Type</option>
												<option value="stop">Bus Stop</option>
												<option value="bus">Bus</option>
												<option value="route">Route</option>
												<option value="device">Device Type</option>
												<option value="transaction">Transaction Type</option>
												<option value="card">Card Type</option>
												<option value="conductor">Conductor</option>
												<option value="driver">Driver</option>
												<option value="trip">Trip</option>
											</select>
										</div> -->

										<div class="large-2 columns">
											<br>
											<button type="submit" class="radius button">Go</button>
										</div>
									</fieldset>
								</form>
							</div>
						</div>
						<br>
						<!--- Table Starts here--->
						<div class="large-12 columns">
							<br>
							<div style="width: 100%; height: 500px; overflow: scroll;">

								<form>
									<table id="dataTable" class="mytable filterable sortable"
										cellspacing="0" width="100%">
										<c:if test="${not empty reportSet}">
											<caption>
												<strong>Transaction Reports ${from} - ${to} </strong>
												<%-- <br>
											<c:if test="${not empty reportList}">
											<strong>Filter Data here
											<img src="img/filter.png"  height="20" width="20"/></strong>
											</c:if> --%>
											</caption>
										</c:if>
										<thead>
											<tr>
												<c:forEach items="${tableColumnNamesList}" var="columnName">
													<th title="Click to Sort"><strong
														style="color: #159faa">${columnName}</strong></th>

												</c:forEach>
											</tr>
										</thead>
										<%
											int count = 0;
										%>
										<c:forEach items="${reportList}" var="reportEntity">
											<tr>
												<%
													count = count + 1;
												%>
												<td>
													<%
														out.println(count);
													%>
												</td>
												<c:forEach items="${reportEntity}" var="cellValue">
													<td>${cellValue}</td>
												</c:forEach>
											</tr>
										</c:forEach>

									</table>
								</form>
							</div>
							<br>
						</div>
					</div>
				</section>
				<a class="exit-off-canvas"></a>
			</div>
		</div>
	</div>
	<!-- Footer part-->
	<div id="footer"></div>
	<br>
</body>
</html>
