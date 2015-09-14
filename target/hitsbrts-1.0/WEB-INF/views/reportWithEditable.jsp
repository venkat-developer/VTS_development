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
<title>Front Page</title>
<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="js/editablegrid-master/editablegrid.css">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<style>
			body { font-family:'lucida grande', tahoma, verdana, arial, sans-serif; font-size:11px; }
			h1 { font-size: 15px; }
			a { color: #548dc4; text-decoration: none; }
			a:hover { text-decoration: underline; }
			table.testgrid { border-collapse: collapse; border: 1px solid #CCB; width: 800px; }
			table.testgrid td, table.testgrid th { padding: 5px; border: 1px solid #E0E0E0; }
			table.testgrid th { background: #E5E5E5; text-align: left; }
			input.invalid { background: red; color: #FDFDFD; }
			
		</style>
</head>
<body>

	<!-- Header Part of the html-->
	<div id="header"></div>
	<!-- Body Part of the html-->
	<br>

	<div class="row" style="height: 72%; width: 100%">
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
						<section class="right-small">
							<a class="right-off-canvas-toggle menu-icon" href="#"><span></span></a>
						</section>
						<div id="lastlogin"></div>
					</nav>
					<div id="navbar"></div>

					<aside class="right-off-canvas-menu">
						<ul class="off-canvas-list">
							<li><label>reportOptions</label></li>
							<li><label>Export To</label></li>
							<li><a
								href="/HITS-UI/reportsgen.do?reportOption=csv&heading=${heading}">
									&nbsp;&nbsp;<img src="img/CSV.png" height="30" width="40"
									title="csv" />&nbsp;&nbsp;&nbsp;Csv Format
							</a></li>
							<li><a
								href="/HITS-UI/reportsgen.do?reportOption=pdf&heading=${heading}">
									&nbsp;&nbsp;<img src="img/PDF.jpeg" height="30" width="40"
									title="pdf" />&nbsp;&nbsp;&nbsp;Pdf Format
							</a></li>
							<li><a
								href="/HITS-UI/reportsgen.do?reportOption=excel&heading=${heading}">
									&nbsp;&nbsp;<img src="img/excel.jpg" height="30" width="40"
									title="excel" />&nbsp;&nbsp;&nbsp;Excel Format
							</a></li>
							<li><label>Print reportOptions</label>
							<li onclick="openPrint('${heading}')"><a href=" ">
									&nbsp;&nbsp;<img src="img/printer.jpg" height="30" width="40"
									title="print" />&nbsp;&nbsp;&nbsp;Print
							</a></li>
							<li onclick="openPreview('${heading}')"><a href="">
									&nbsp;&nbsp; <img src="img/printpreview.png" height="30"
									width="40" title="Print Preview" />&nbsp;&nbsp;&nbsp;Print
									Preview
							</a></li>
						</ul>
					</aside>
					<!-- content goes here -->
					<!-- Table content starts here for report generation -->
					<br>
					<div id="report" style="position:relative;left:15%;">
						<div id="title" style="position:relative;left:20%;">
							<h3 >Report Generation</h3>
							</div>
							<br> <br>
						<div id="tablecontent"></div>
						<div id="paginator" style="position:relative;left:5%;"></div>
					
						
					</div>
						
					<br> <br>

				</div>
				<br> <br> <br> <br>
			</div>
		</section>
	</div>


	<a class="exit-off-canvas"></a>

	<!-- Footer part-->
	<div id="footer"></div>

	<script src="js/vendor/modernizr.js"></script>
	<script src="js/foundation/wifi.js"></script>
	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js">
		
	</script>
	<script src="js/foundation.js"></script>
	<script src="js/foundation.orbit.js"></script>
	<script src="js/brts/main.js"></script>
	<script src="js/brts/alerts.js"></script>
	<script src="js/brts/report.js"></script>
	<script src="js/sorttable.js"></script>	
	
	<script src="js/editablegrid-master/editablegrid.js"></script>
	<!-- [DO NOT DEPLOY] --> <script src="js/editablegrid-master/editablegrid_renderers.js" ></script>
		<!-- [DO NOT DEPLOY] --> <script src="js/editablegrid-master/editablegrid_editors.js" ></script>
		<!-- [DO NOT DEPLOY] --> <script src="js/editablegrid-master/editablegrid_validators.js" ></script>
		<!-- [DO NOT DEPLOY] --> <script src="js/editablegrid-master/editablegrid_utils.js" ></script>
		<!-- [DO NOT DEPLOY] --> <script src="js/editablegrid-master/editablegrid_charts.js" ></script>
	<script src=js/brts/reportEditable.js> </script>
	<script>
	$(document).ready(function() {
		var heading ='${heading}';
		   reportEdit(heading,${tableColumnNamesList},${reportList},${depotList}) ;
	   });
	   </script>
	</body>
</html>










