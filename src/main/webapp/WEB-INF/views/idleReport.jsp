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
<!--<script src="js/sorttable.js"></script>
<script src="js/brts/tablefilter.js"></script> -->
<script src="js/brts/report.js"></script>
<!--<script>
	var table3Filters = {
		col_0 : "select",
		col_5 : "none",
		btn : true
	}
	var tf03 = setFilterGrid("dataTable", 2, table3Filters);
</script> -->
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
											<c:if test="${not empty idlPointsData}">
											<strong>Filter Data here
											<img src="img/filter.png"  height="20" width="20"/></strong>
											</c:if> --%>
											</caption>
										</c:if>
										<!-- <thead>
											<tr>
												<c:forEach items="${tableColumnNamesList}" var="columnName">
													<th title="Click to Sort"><strong
														style="color: #159faa">${columnName}</strong></th>

												</c:forEach>
											</tr>
										</thead> -->
										<%
											int count = 0;
										%>
										<c:forEach items="${idlPointsData}" var="idlePoint">
											<tr>
												<%
													count = count + 1;
												%>
												<td>
													<%
														out.println(count);
													%>
												</td>
												
													<td>${idlePoint.starttime}</td>
													<td>${idlePoint.endtime}</td>
													<td>${idlePoint.idleLocation.getFirstPoint().getX()}</td>
													<td>${idlePoint.idleLocation.getFirstPoint().getY()}</td>
													<td>${idlePoint.locationName}</td>
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
	<br>
	<!-- Footer part-->
	<div id="footer"></div>
	<br>
</body>
</html>
