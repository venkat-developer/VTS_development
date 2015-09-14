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
<title>HITS-Input File Validator</title>
<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />

<script type="text/javascript">
function alertValidation(msg){
	 
	 alert(msg);
	 
	 
}</script>
</head>

<body>
	<!-- Header Part of the html-->
	<div id="header"></div>
	<!-- Body Part of the html-->
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
					</nav>
					<div id="navbar"></div>



					<!-- content goes here -->
					<%
						String bus_result = (String) request.getAttribute("bus_result");
						
						String bus_flag = (String) request.getParameter("bus_flag");
						String stops_result = (String) request.getAttribute("stops_result");
						
						String stops_flag = (String) request.getParameter("stops_flag");
						String conductor_result = (String) request
								.getAttribute("conductor_result");
						
						String conductor_flag = (String) request
								.getParameter("conductor_flag");
						String depot_result = (String) request.getAttribute("depot_result");
						
						String depot_flag = (String) request.getParameter("depot_flag");
						String division_result = (String) request
								.getAttribute("division_result");
						
						String division_flag = (String) request
								.getParameter("division_flag");
						String driver_result = (String) request
								.getAttribute("driver_result");
						
						String driver_flag = (String) request.getParameter("driver_flag");
						String farechart_result = (String) request
								.getAttribute("farechart_result");
						
						String farechart_flag = (String) request
								.getParameter("farechart_flag");
						String routes_result = (String) request
								.getAttribute("routes_result");
					
						String routes_flag = (String) request.getParameter("routes_flag");
						String users_result = (String) request.getAttribute("users_result");
					
						String users_flag = (String) request.getParameter("users_flag");
						String type_result = (String) request.getAttribute("type_result");
						
						String type_flag = (String) request.getParameter("type_flag");
						String wifi_result = (String) request.getAttribute("wifi_result");
						
						String wifi_flag = (String) request.getParameter("wifi_flag");
					%>

					<div class="large-11 columns" style="height: 100%">
						<br>
						<p>
							<strong><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; INPUT EXCEL FILES VALIDATION</h3></strong>
						<div class="large-4 columns">
							<br>
							<fieldset>
								<legend>
									<h6>
										<strong> Bus Details File</strong>
									</h6>
								</legend>
								<form action="/HITS-UI/busInputFileValidator.do" method="post"
									enctype="multipart/form-data">

									<p>
										Select a file : <input type="file" name="bus_file" size="45" />

									</p>

									<input type="submit" value="Validate File" />


								</form>


								<%-- <p>String bustop=${bus_result}</p> --%>


							</fieldset>
						</div>

						<div class="large-4 columns">
							<br>
							<fieldset>
								<legend>
									<h6>
										<strong>Bus Stops File</strong>
									</h6>
								</legend>
								<form action="/HITS-UI/stopsInputFileValidator.do" method="post"
									enctype="multipart/form-data">

									<p>
										Select a file : <input type="file" name="stops_file" size="45" />
									</p>

									<input type="submit" value="Validate File" />
								</form>
								<%-- <p>${stops_result}</p> --%>

							</fieldset>
						</div>


						<div class="large-4 columns">
							<br>
							<fieldset>
								<legend>
									<h6>
										<strong>Conductor Details File</strong>
									</h6>
								</legend>
								<form action="/HITS-UI/conductorInputFileValidator.do"
									method="post" enctype="multipart/form-data">

									<p>
										Select a file : <input type="file" name="conductor_file"
											size="45" />
									</p>

									<input type="submit" value="Validate File" />
								</form>

							</fieldset>
						</div>

						<div class="large-4 columns">
							<br>
							<fieldset>
								<legend>
									<h6>
										<strong>Depot Details File</strong>
									</h6>
								</legend>
								<form action="/HITS-UI/depotInputFileValidator.do" method="post"
									enctype="multipart/form-data">

									<p>
										Select a file : <input type="file" name="depot_file" size="45" />
									</p>

									<input type="submit" value="Validate File" />
								</form>
								<%-- <p>${depot_result}</p> --%>

							</fieldset>
						</div>


						<div class="large-4 columns">
							<br>
							<fieldset>
								<legend>
									<h6>
										<strong>Division Details File</strong>
									</h6>
								</legend>
								<form action="/HITS-UI/divisionInputFileValidator.do"
									method="post" enctype="multipart/form-data">

									<p>
										Select a file : <input type="file" name="division_file"
											size="45" />
									</p>

									<input type="submit" value="Validate File" />
								</form>
								<%-- <p>${division_result}</p> --%>

							</fieldset>
						</div>


						<div class="large-4 columns">
							<br>
							<fieldset>
								<legend>
									<h6>
										<strong>Driver Details File</strong>
									</h6>
								</legend>
								<form action="/HITS-UI/driverInputFileValidator.do"
									method="post" enctype="multipart/form-data">

									<p>
										Select a file : <input type="file" name="driver_file"
											size="45" />
									</p>

									<input type="submit" value="Validate File" />
								</form>
								<%-- <p>${driver_result}</p> --%>

							</fieldset>
						</div>



						<div class="large-4 columns">
							<br>
							<fieldset>
								<legend>
									<h6>
										<strong>Farechart Details File</strong>
									</h6>
								</legend>
								<form action="/HITS-UI/farechartInputFileValidator.do"
									method="post" enctype="multipart/form-data">

									<p>
										Select a file : <input type="file" name="acfarechart_file"
											size="45" />
									</p>

									<input type="submit" value="Validate File" />
								</form>
								<%-- <p>${farechart_result}</p> --%>

							</fieldset>
						</div>


						<div class="large-4 columns">
							<br>
							<fieldset>
								<legend>
									<h6>
										<strong>Route Details File</strong>
									</h6>
								</legend>
								<form action="/HITS-UI/routesInputFileValidator.do"
									method="post" enctype="multipart/form-data">

									<p>
										Select a file : <input type="file" name="route_file" size="45" />
									</p>

									<input type="submit" value="Validate File" />
								</form>
								<%-- <p>${routes_result}</p> --%>

							</fieldset>
						</div>


						<div class="large-4 columns">
							<br>
							<fieldset>
								<legend>
									<h6>
										<strong>Type Details File</strong>
									</h6>
								</legend>
								<form action="/HITS-UI/typeInputFileValidator.do" method="post"
									enctype="multipart/form-data">

									<p>
										Select a file : <input type="file" name="users_file" size="45" />
									</p>

									<input type="submit" value="Validate File" />
								</form>
								<%-- <p>${type_result}</p> --%>

							</fieldset>
						</div>

						<!-- 						<br>
 -->

						<div class="large-4 columns">
							<br>
							<fieldset>
								<legend>
									<h6>
										<strong>Terminal Device Users Details File</strong>
									</h6>
								</legend>
								<form action="/HITS-UI/usersInputFileValidator.do" method="post"
									enctype="multipart/form-data">

									<p>
										Select a file : <input type="file" name="users_file" size="45" />
									</p>

									<input type="submit" value="Validate File" />
								</form>
								<%-- <p>${users_result}</p> --%>

							</fieldset>
						</div>


						<div class="large-4 columns">
							<br>
							<fieldset>
								<legend>
									<h6>
										<strong>Wifi Details File</strong>
									</h6>
								</legend>
								<form action="/HITS-UI/wifiInputFileValidator.do" method="post"
									enctype="multipart/form-data">

									<p>
										Select a file : <input type="file" name="wifi_file" size="45" />
									</p>

									<input type="submit" value="Validate File" />
								</form>
								<%-- <p>${wifi_result}</p> --%>

							</fieldset>
						</div>
						<div class="large-4 columns"></div>
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
	<script src="js/foundation.min.js"></script>
	<script src="js/foundation.js"></script>
	<script src="js/foundation.orbit.js"></script>
	<script src="js/brts/main.js"></script>
	<script src="js/brts/alerts.js"></script>


	<c:if test="${ bus_flag=='set'}">
		<script type="text/javascript">
		
	alertValidation('<%=bus_result%>');
	</script>
		<%
			bus_flag = null;
		%>
	</c:if>
	<c:if test="${ stops_flag=='set'}">
		<script type="text/javascript">
	alertValidation('<%=stops_result%>');
	</script>
		<%
			stops_flag = null;
		%>
	</c:if>
	<c:if test="${ conductor_flag=='set'}">
		<script type="text/javascript">
	alertValidation('<%=conductor_result%>');
	</script>
		<%
			conductor_flag = null;
		%>
	</c:if>
	<c:if test="${ depot_flag=='set'}">
		<script type="text/javascript">
	alertValidation('<%=depot_result%>');
	</script>
		<%
			depot_flag = null;
		%>
	</c:if>
	<c:if test="${division_flag=='set'}">
		<script type="text/javascript">
	alertValidation('<%=division_result%>');
	</script>
		<%
			division_flag = null;
		%>
	</c:if>
	<c:if test="${ driver_flag=='set'}">
		<script type="text/javascript">
	alertValidation('<%=driver_result%>');
	</script>
		<%
			driver_flag = null;
		%>
	</c:if>
	<c:if test="${ farechart_flag=='set'}">
		<script type="text/javascript">
	alertValidation('<%=farechart_result%>');
	</script>
		<%
			farechart_flag = null;
		%>
	</c:if>
	<c:if test="${ routes_flag=='set'}">
		<script type="text/javascript">
	alertValidation('<%=routes_result%>');
	</script>
		<%
			routes_flag = null;
		%>
	</c:if>
	<c:if test="${ type_flag=='set'}">
		<script type="text/javascript">
	alertValidation('<%=type_result%>');
	</script>
		<%
			type_flag = null;
		%>
	</c:if>
	<c:if test="${ users_flag=='set'}">
		<script type="text/javascript">
	alertValidation('<%=users_result%>');
	</script>
		<%
			users_flag = null;
		%>
	</c:if>
	<c:if test="${ wifi_flag=='set'}">
		<script type="text/javascript">
	alertValidation('<%=wifi_result%>');
		</script>
		<%
			wifi_flag = null;
		%>
	</c:if>
</body>
</html>
