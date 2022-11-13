<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Expires" content="0">
 <meta http-equiv="Last-Modified" content="0">
 <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
 <meta http-equiv="Pragma" content="no-cache">
<title>BotanicaLandia</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
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
		<div class="main">
			<div class="title">
				<h1>BotanicaLandia</h1>
			</div>
			<form action="login" method="post">
				<div class="formField">
					<label for="username">Username</label>
					<input type="text" name="username" class="username" required>
				</div>
				<div class="formField">
					<label for="password">Password</label>
					<input type="password" name="password" class="password" required>
				</div>
				<div class="error">
					<%if(errorMsg != null) {%>
						<small><%=errorMsg %></small>
					<%}%>
				</div>
				<div class="buttons">
					<button type="submit" class="login" disabled>Log in</button>
				</div>
			</form>
			<div class="separator">
				<div class="bar"></div>
				<div class="or">O</div>
				<div class="bar"></div>
			</div>
			<div class="buttons">
				<button class="register">Register</button>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="./js/script.js"></script>
</html>