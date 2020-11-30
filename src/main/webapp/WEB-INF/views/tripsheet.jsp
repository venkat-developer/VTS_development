<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Travel management</title>

<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />
<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />
</head>

<body>
	<!-- Header Part of the html-->
	<div id="header"></div>
	<!-- Body Part of the html-->
	<br>
	<div class="row" style="width: 100%">
		<div class="off-canvas-wrap" data-offcanvas>
			<div class="inner-wrap">
				<nav class="tab-bar"> <section class="left-small"> <a
					class="left-off-canvas-toggle menu-icon" href="#"><span></span></a>
				</section> <section class="middle tab-bar-section">
				<h1 class="title">Menu</h1>
				</section>
				<div id="lastlogin"></div>
				</nav>
				<div id="navbar"></div>
				<br>
				<br>
				<form action="/HITS-UI/tripSheet.do?action=add"  method="post"> 
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
      <span class="prefix">Trip Number : </span>
    </div>
    <div class="large-6 columns" style="width: 260px;">
      <input type="text" name="tripId" placeholder="Enter trip number...">
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
      <span class="prefix">Passanger name :</span>
    </div>
    <div class="large-6 columns" style="width: 260px;">
	<select name="paxName">
		<c:forEach items='${passangerList}' var='passangerData'>
		<option value=${passangerData.passengerId.id}>${passangerData.firstName}</option>
		</c:forEach>
	</select>
    </div>
	<div class="large-3 columns"></div>
  </div>
  
   <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
		&nbsp;
	</div>
    <div class="large-6 columns">
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
      <span class="prefix">Referred by :</span>
    </div>
    <div class="large-6 columns" style="width: 260px;">
      <input type="text" name="referredBy" placeholder="Enter Referred by name ">
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
      <span class="prefix">Trip Type :</span>
    </div>
    <div class="large-6 columns" style="width: 260px;">
      <select name="tripType">
            <option value="1">Local</option>
            <option value="2">OutStation</option>
         </select>
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
		&nbsp;
	</div>
    <div class="large-6 columns">
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
      <span class="prefix">Select vehicle Type :</span>
    </div>
    <div class="large-6 columns" style="width: 260px;">
      <select name="vehicleType">
			<option value = "">Select Vehicle type</option>
            <option value = "1">Sedan</option>
            <option value = "2">SUV</option>
            <option value = "3">Mini Van</option>
            <option value = "4">Bus</option>
         </select>
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
		&nbsp;
	</div>
    <div class="large-6 columns">
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
      <span class="prefix">Vehicle No  :</span>
    </div>
    <div class="large-6 columns" style="width: 260px;">
	<select name="vehicleId">
		<c:forEach items='${vehicleList}' var='vehicleData'>
		<option value=${vehicleData.vehcielId.id}>${vehicleData.registrationNo}</option>
		</c:forEach>
	</select>
    </div>
	<div class="large-3 columns"></div>
  </div>
  
   <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
		&nbsp;
	</div>
    <div class="large-6 columns">
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
      <span class="prefix">Driver Name :</span>
    </div>
	<div class="large-6 columns" style="width: 260px;">
    <select name="driverId">
		<c:forEach items='${driverList}' var='driverData'>
		<option value=${driverData.driverId.id}>${driverData.firstName}</option>
		</c:forEach>
	</select>
	</div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
		&nbsp;
	</div>
    <div class="large-6 columns">
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
      <span class="prefix">Start Date : </span>
    </div>
    <div class="large-6 columns">
      <input type="datetime-local" name="startDate" id="startDate" required style="width: 260px;">
	</div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
      <span class="prefix">End Date : </span>
    </div>
    <div class="large-6 columns">
      <input type="datetime-local" name="endDate" id="endDate" required style="width: 260px;">
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
		&nbsp;
	</div>
    <div class="large-6 columns">
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
	<br>
	</div>
  <div class="large-6 columns">
    <br>
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
	&nbsp;
	</div>
    
	<div class="large-6 columns">
      	<span>
		<input type="radio" name="ac" value="true" id="ac" required>AC</input>
		<input type="radio" name="ac" value="false" id="nonac">Non-AC</input>
		</span>
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  
  
 </div>
</div>
  <div class="input-group-button">
    <div class="large-6 small-offset-4 columns">
    <input type="submit" class="button" value="Submit">
	<input type="reset" class="button" value="Clear"></div>
  </div>
</form>
				<a class="exit-off-canvas"></a>
			</div>
		</div>
	</div>
	<br>
	<!-- Footer of the Google app html-->
	<div id="footer"></div>
	<script src="js/vendor/modernizr.js"></script>
	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js">
		
	</script>
	<script src="js/foundation.js"></script>
	<script src="js/foundation.orbit.js"></script>
	<script src="js/brts/main.js"></script>
	<script src="/zurb-foundation3/foundation3/javascripts/jquery.min.js"></script>
<script src="/zurb-foundation3/foundation3/javascripts/jquery.customforms.js"></script>
</body>
</html>