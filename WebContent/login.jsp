<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: center">
		<div style="background-image: url('img_girl.jpg');">
			<h1>Login</h1>
			<form action="login" method="post">
				<label for="username">username:</label> <input name="username"
					size="30" /> <br>
				<br> <label for="password">Password:</label> <input
					type="password" name="password" size="30" /> <br>${message} <br>
				<br>
				<button type="submit">Login</button>
			</form>
		</div>
	</div>
</body>
</html>