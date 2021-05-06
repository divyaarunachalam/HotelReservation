<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> Hotel Booking </title>
</head>
<body>
	<div style="text-align: center">
		<h1>Booking Confirmed</h1>
			<label for="indate">From date: ${indate}</label> 
			<br>
		    <label for="outdate">To date: ${outdate}</label> 
			<br>
			 <label for="rooms">Rooms available : ${booking}</label>
            <br><br>
	</div>
</body>
</html>