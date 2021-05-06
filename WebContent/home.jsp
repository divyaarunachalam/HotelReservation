<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> Hotel Booking </title>
<style>
 label {
         vertical-align: middle;
      }
</style>
</head>
<body>
	<div style="text-align: center">
		<h1>Welcome to Hotel ABC</h1>
		<form action="booking" method="post">
		 <label for="username">username: </label>
           <input name="username"  value= ${user} readonly/>
            <br><br>
			<label for="indate">Checkin date:</label> 
			<input type="date"
				id="indate" name="indate"> <br> <br>
		    <label for="outdate">Checkout date:</label> 
			<input type="date" id="outdate"
				name="outdate"> <br> 
			<br>
			 <label for="rooms">No. of rooms :</label>
            <input name="rooms" size="10" />
            <br><br>
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>