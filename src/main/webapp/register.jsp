<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BotanicaLandia</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<%
	session.invalidate();
	String errorMsg = request.getParameter("msg");
%>
<body>
	<div class="container">
		<div class="image">
			<img alt="Plantas en una mesa" src="./img/portada.webp">
		</div>
		<div class="main_register">
			<div class="title">
				<h1>BotanicaLandia</h1>
			</div>
			<form action="RegisterSend.jsp" method="get">
				<div class="formField">
					<label for="username">Username</label>
					<input type="text" name="username" class="username" required>
				</div>
				<div class="formField">
					<label for="password">Password</label>
					<input type="password" name="password" class="password" required>
				</div>
				<div class="formField">
					<label for="name">Name</label>
					<input type="text" name="name" class="name" required>
				</div>
				<div class="formField">
					<label for="lastname">Last Name</label>
					<input type="text" name="lastname" class="lastname" required>
				</div>
				<div class="formField">
					<label for="birth">Birth</label>
					<input type="date" name="birth" class="birth" required>
				</div>
				<div class="formField">
					<label for="gender">Gender</label>
					<select class="gender" name="gender">
						<option value="M">Male</option>
						<option value="F">Female</option>
						<option value="O">Other</option>
					</select>
				</div>
				<div class="error">
					<%if(errorMsg != null) {%>
						<small><%=errorMsg %></small>
					<%}%>
				</div>
				<div class="buttons">
					<button type="submit" class="register">Register</button>
				</div>
			</form>
			<div class="separator">
				<div class="bar"></div>
				<div class="or">O</div>
				<div class="bar"></div>
			</div>
			<div class="loginUrl">
				<p>Do you have an account?<br><a href="index.jsp">Log in</a></p>
			</div>
		</div>
	</div>
</body>
</html>