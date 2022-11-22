<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<%
	String msg = request.getParameter("msg");
	String errorId = request.getParameter("errorId");
%>
<body>
	<%
	switch(errorId) {
	case "0001":%>
		<div class="window_message">
			<div class="message">
				<h1>Error 500</h1>
				<h3><%=msg %></h3>
				<a href="index.jsp"><button class="return">Return log in</button></a>
			</div>
		</div>
		<%break;
	case "0002":%>
		<img alt="403 error" src="./img/403-error.jpg" class="error_image">
		<div class="window_message">
			<div class="message">
				<h1>Error 403</h1>
				<h3>You don't have permission to access / on this server. Please return to log in.</h3>
				<a href="index.jsp"><button class="return">Return log in</button></a>
			</div>
		</div>
		<%break;
	case "0003":%>
		<div class="window_message">
			<div class="message">
				<h1>Error</h1>
				<h3><%=msg %></h3>
				<a href="cart.jsp"><button class="return">Return cart</button></a>
			</div>
		</div>
		<%break;
	default:%>
		<div class="window_message">
			<div class="message">
				<h1>Error 500</h1>
				<h3>Oops an unexpected error has occurred.</h3>
				<a href="index.jsp"><button class="return">Return log in</button></a>
			</div>
		</div>
		<%break;
	}%>
</body>
</html>