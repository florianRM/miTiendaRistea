<%@page import="org.hibernate.tool.hbm2ddl.UniqueConstraintSchemaUpdateStrategy"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="com.jacaranda.users.*" %>
<jsp:useBean id="daoUsers" class="com.jacaranda.control.UsersControl"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String lastname = request.getParameter("lastname");
	String birth = request.getParameter("birth");
	String gender = request.getParameter("gender");

	if (username != null && password != null && name != null && lastname != null && birth != null
			&& gender != null) {
		char genderChar = gender.charAt(0);
		/*Le sumamos un dia a la fecha ya que a la base de datos 
		se introduce con un dia menos*/
		DateTimeFormatter format =  DateTimeFormatter.ofPattern("yyyy-M-d");
		
		LocalDate newDate = LocalDate.parse(birth, format).plusDays(1);
		
		String encriptedPassword = DigestUtils.md5Hex(password);
		
		Users user = new Users(username, encriptedPassword, name, lastname, newDate, genderChar, false);
		
		try {
			daoUsers.registerUser(user);
			response.sendRedirect("index.jsp");
		} catch(Exception e) {
			response.sendRedirect("register.jsp?msg=" + e.getMessage());
		}
	} else {
		response.sendRedirect("error.jsp?errorId=0003&message=Parameters cannot be null");
	}
	%>
</body>
</html>