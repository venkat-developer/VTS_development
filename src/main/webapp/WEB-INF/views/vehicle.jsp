<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Travel Management | Vehicle</title>

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
				<form action="/HITS-UI/vehicle.do" method="post"> 
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
      <span class="prefix">Registration No : </span>
    </div>
    <div class="large-6 columns">
      <input type="text" name="registrationNo" placeholder="Eg : KAO1AA0000">
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
      <span class="prefix">Vehicle Make :</span>
    </div>
    <div class="large-6 columns">
      <input type="text"  name="vehicleMake" placeholder="Eg : KIA">
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
      <span class="prefix">Vehicle Model :</span>
    </div>
    <div class="large-6 columns">
      <input type="text"  name="vehicleModel" placeholder="Eg : Carnival">
    </div>
	<div class="large-3 columns"></div>
  </div>
  
  <div class="row collapse">
    <div class="large-2 small-offset-2 columns">
      <span class="prefix">Vehcile Type :</span>
    </div>
    <div class="large-6 columns">
      <select name="vehicleType">
            <option value="1">Sedan</option>
            <option value="2">SUV</option>
			<option value="3">Hatchback</option>
			<option value="4">Mini Van</option>
			<option value="5">Bus</option>
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
      <span class="prefix">Insurance valid up to :</span>
    </div>
    <div class="large-6 columns">
      <input type="text" name="insurance" placeholder="Insurance validity date">
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
    <div class="large-6 small-offset-4 columns"><input type="submit" class="button" value="Submit">
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