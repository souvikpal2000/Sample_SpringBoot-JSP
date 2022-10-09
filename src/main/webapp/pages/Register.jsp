<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Register</title>
	</head>
	<body>
		<a href="/">Login</a>
		<a href="/changepassword">Change Password</a>
		<p><b>${message}</b></p>
		<form method="post" action="register">
			Enter Username : <input type="text" name="username"><br>
			Enter Password : <input type="password" name="password"><br>
			Confirm Password : <input type="password" name="conPassword"><br>
			<input type="submit" value="Register">
		</form>
	</body>
</html>