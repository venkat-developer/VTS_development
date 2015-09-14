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
<title>HITS-Pass Key</title>
<link rel="stylesheet" href="css/foundation.css" />
<link rel="stylesheet" href="css/normalize.css" />
</head>

<body>
	<!-- Header Part of the html-->
	<div id="header"></div>
	<!-- Body Part of the html-->
	<br>
	<div class="row" style="height: 70%; width: 100%">
		<nav class="tab-bar">
			<div id="lastlogin"></div>
		</nav>
		<!-- content goes here -->
		<div class="large-11 columns" style="height: 99.5%">
			<h1>Password Update</h1>
			<div class="large-7 push-4 columns">
				<c:if test="${divLoad == 'pswdverification'}">
					<div class="large-7">
						<form action="/HITS-UI/passkey.do?otp=passwordOtp" method="post">
							<fieldset>
								<p>	
									<label><strong>* Re-Enter your password :</strong></label>
								</p>
								<input type="password" value="" name="usrpswd" id="usrpswd">
								<label style="color: #de4c4c"><strong>${msg}</strong></label>
								<center>
									<button type="submit" value="Submit" class="radius button" >Submit</button>
								</center>
							</fieldset>
						</form>
					</div>
				</c:if>
				<c:if test="${divLoad == 'pswdChange'}">
					<div class="large-7">
						<form action="/HITS-UI/passkey.do?otp=passkeySet" method="post">
							<fieldset>
								<legend>
									<label><strong>Change Password</strong></label>
								</legend>
								<br>
								<p>
									<label><strong>New PassKey :</strong></label>
								</p>
								<input type="password" value="" name="newpswd" id="newpswd"
									required maxlength="5"
									title="Password must contain atmost 5 characters">
								<p>
									<label><strong>Confirm the new PassKey :</strong></label>
								</p>
								<input type="password" value="" name="confirmpswd"
									id="confirmpswd" required maxlength="5"
									title="Please enter the same Password as above.">
								<label style="color: #de4c4c"><strong>${returnMsgError}</strong></label>	
								<center>
									<button type="submit" value="Submit" class="radius button">Submit</button>
								</center>
							</fieldset>
						</form>
					</div>
				</c:if>
				<c:if test="${divLoad == 'pswdSet'}">
					<div class="large-7">
						<fieldset>
							<legend>
								<label><strong></strong></label>
							</legend>
							<label><strong><center>
										<h5>
											Passkey has been already updated today<br> You cant
											reset the passkey again..
										</h5>
									</center> </strong></label>
						</fieldset>
					</div>
				</c:if>
				<c:if test="${divLoad == 'pswdSetMessage'}">
					<div class="large-7">
						<fieldset>
							<legend>
								<label><strong></strong></label>
							</legend>
							<label><strong><center>
										<h5>
										 ${returnMsg}
										</h5>
									</center> </strong></label>
						</fieldset>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<!-- Footer part-->
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
	<script src="js/brts/passwordValidator.js"></script>
</body>
</html>
