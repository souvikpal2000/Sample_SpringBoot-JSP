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
		<a href="/register">New User</a>
		<p><b>${message}</b></p>
		<form method="post" action="changepassword">
			Enter Username : <input type="text" name="username"><br>
			Enter Old Password : <input type="password" name="oldPassword"><br>
			Enter New Password : <input type="password" name="newPassword"><br>
			Confirm Password : <input type="password" name="conPassword"><br>
			<input type="submit" value="Change Password">
		</form>
	</body>
</html>