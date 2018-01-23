<%@ page import="org.json.JSONObject" %>
<%@ page import="java.util.Map" %>
<%@ page import ="java.util.List" %>
<%@ page import="com.coviam.entity.FlightSearchResponse" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Test</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <style>

        .center {
            margin: auto;
            width: 60%;
            border: 3px solid #73AD21;
            padding: 10px;
        }
        </style>
</head>
<body>

<div class="center">
<form action="/flight/search" method="GET" >
  From : <input type="text" name="origin"><br>
  To: <input type="text" name="destination"><br>
  DepartDate: <input type="text" name="originDepartDate"><br>
  ReturnDate: <input type="text" name="destinationArrivalDate"><br>
  flightType: <input type="text" name="flightType"><br>
  Adult: <input type="text" name="adults"><br>
  Infant: <input type="text" name="infants"><br>
  Child: <input type="text" name="children"><br>
  <input type="submit" value="Submit">
</form>
</div>

</body>
</html>
