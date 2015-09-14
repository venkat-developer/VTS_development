<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<!-- Head part-->
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>HITS-Print Preview</title>
<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />
</head>
<body>
	<div class="row" style="height: 100%;">
		<center>
			<div>
				<br>
				<h3>
					<strong>BHOPAL BUS RAPID TRANSIT SYSTEM</strong>
				</h3>
				<h4>
					<strong>Report For - ${heading}</strong>
				</h4>
			</div>
		</center>
		<br>
		<div>
			<form>
				<table id="dataTable">
					<caption>
						<strong>${heading}</strong>
					</caption>

					<tr>
						<c:forEach items="${tableColumnNamesList}" var="columnName">
							<th>${columnName}</th>
						</c:forEach>
					</tr>

					<c:forEach items="${reportList}" var="reportEntity">
						<tr>
							<c:forEach items="${reportEntity}" var="cellValue">

								<td>${cellValue}</td>

							</c:forEach>

						</tr>
					</c:forEach>
				</table>
			</form>
		</div>

	</div>

	<script src="js/foundation.min.js"></script>
	<script src="js/foundation.js"></script>



</body>
</html>