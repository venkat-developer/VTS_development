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
    <title>HITS-Upload Setting files</title>
    <link rel="stylesheet" href="css/foundation.css" />
    <link rel="stylesheet" href="css/normalize.css" />
    <script type="text/javascript">
      function displayStopList() {
      		if((document.getElementById("stopType").value) == "unified"){
      			$(".routeNames").hide();
      		}
      		if((document.getElementById("stopType").value) == "routewise"){
      			$(".routeNames").show();
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
              <div id="lastlogin"></div>
            </nav>
            <div id="navbar"></div>
            <!-- content goes here -->
            <div class="large-11 columns">
              <br>
              <marquee behavior="alternate">
                <strong><font color="red">*Alert !!</font></strong>
              </marquee>
              <h1>${heading}</h1>
              <h1></h1>
              <div class="large-4 columns" style="height: 100%">
                <!--- Side Form Starts here--->
                <c:if test="${userRole == 0}">
                  <form action='${action}' class="dummy" name="dummy"
                    enctype="multipart/form-data" method="POST">
                    <fieldset>
                      <legend>
                        Upload Details<br>
                        <br>
                      </legend>
                      <c:if test="${not empty stopTypes}">
                        <div>
                          <label>Stop Type</label><br>
                          <select name="stopType" id="stopType" required onchange="displayStopList()">
                            <option value="" disabled selected style="display: none;">----
                              Select the Type ----
                            </option>
                            <option value="unified">Unified</option>
                            <option value="routewise">RouteWise Stops</option>
                          </select>
                        </div>
                        <div class="routeNames" style="display: none">
                          <br>
                          <br>
                          <label>Route Name</label>
                          <br>
                          <select name="routeTypes" id="routeTypes">
                            <option value="" disabled selected style="display: none;">----
                              Select the Type ----
                            </option>
                            <c:forEach items='${routeNameList}' var="route">
                              <option value='${route.routeCode}'>${route.routeCode}</option>
                            </c:forEach>
                            <option value="all">All Routes</option>
                          </select>
                        </div>
                      </c:if>
                      <c:if test="${not empty typeDetails}">
                        <div>
                          <br>
                          <br>
                          <label>Type Details</label>
                          <br>
                          <select name="types" id="types" required>
                            <option value="" disabled selected style="display: none;">----
                              Select the Type ----
                            </option>
                            <option value="terminal_device_type">Terminal Device
                              Type
                            </option>
                            <option value="bus_stop_type">Bus Stop Type</option>
                            <option value="bus_type">Bus Type</option>
                            <option value="card_type">Card Type</option>
                            <option value="transaction_type">Transaction Type</option>
                            <option value="file_type">File Type</option>
                            <option value="file_category_type">File Category
                              Type
                            </option>
                          </select>
                        </div>
                      </c:if>
                      <div>
                        <br>
                        <br> <label> Upload file :<br> <br> <input
                          id="myfile" name="myfile" type="file" />
                        </label> <br>
                        <center>
                          <button type="submit" value="Submit" class="radius button"
                            onclick="alertUpload()">Submit</button>
                        </center>
                      </div>
                    </fieldset>
                  </form>
                  <br>
                  <br>
                  <br>
                </c:if>
                <form action="${action}?report=set" class="report" name="report"
                  method="post">
                  <fieldset>
                    <legend>
                      <strong>Report Generation</strong><br>
                      <br>
                    </legend>
                    <center>
                      <button type="submit" class="radius button">Generate
                      Report</button>
                    </center>
                  </fieldset>
                </form>
                <br>
                <br>
                <br>
              </div>
              <br>
              <br>
              <br>
            </div>
          </div>
        </div>
      </section>
    </div>
    <a class="exit-off-canvas"></a>
    <!-- Footer part-->
    <div id="footer"></div>
    <script src="js/vendor/modernizr.js"></script>
    <script src="js/foundation/wifi.js"></script>
    <script src="js/vendor/jquery.js"></script>
    <script src="js/vendor/jquery.js"></script>
    <script src="js/foundation.min.js"> </script>
    <script src="js/foundation.js"></script>
    <script src="js/foundation.orbit.js"></script>
    <script src="js/brts/main.js"></script>
    <script src="js/brts/alerts.js"></script>
  </body>
</html>