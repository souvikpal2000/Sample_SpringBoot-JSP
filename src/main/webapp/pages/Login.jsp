<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
		<a href="/register">New User</a>
		<a href="/changepassword">Change Password</a>
		<p><b>${message}</b></p>
		<form method="post" action="login">
			Enter Username : <input type="text" name="username"><br>
			Enter Password : <input type="password" name="password"><br>
			<input type="submit" value="Login">
		</form>
	</body>
</html>