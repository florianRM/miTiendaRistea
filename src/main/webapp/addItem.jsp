<%@page import="com.jacaranda.category.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="daoCategory"
	class="com.jacaranda.control.CategoryControl"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
<script src="https://kit.fontawesome.com/acaa90b7af.js" crossorigin="anonymous"></script>
</head>
<%
String name = (String) session.getAttribute("username");
String login = (String) session.getAttribute("login");
List<Category> categoryList = daoCategory.getCategories();
%>
<body>
	<header>
		<h1>BotanicaLandia</h1>
		<div class="icons">
			<ul>
				<li><a href="addItem.jsp"><button class="addItem">Add
							Item</button></a></li>
				<li><a><i class="fa-solid fa-cart-shopping"></i></a></li>
				<li><i class="fa-solid fa-user"></i></li>
				<li class="user"><strong>Welcome</strong><br><%=name%></li>
			</ul>
		</div>
	</header>
	<div class="drop-menu">
		<button class="logout">Log out</button>
	</div>
	<div class="main_addItem">
		<h1 class="title">Add Item</h1>
		<form action="addItem" method="post" enctype="multipart/form-data">
			<div class="formField">
				<label for="id">Id</label> 
				<input type="text" name="id" class="id" required>
			</div>
			<div class="formField">
				<label for="name">Name</label> 
				<input type="text" name="name" class="name" required>
			</div>
			<div class="formField">
				<label for="uploadFile">Description</label><br> 
				<textarea rows="5" cols="26" name="description" class="description" required></textarea>
			</div>
			<div class="formField">
				<label for="price">Price</label> 
				<input type="number" name="price" class="price" step="0.01" required>
			</div>
			<div class="formField">
				<label for="price">Price</label> 
				<select name="category" class="category" required>
					<%
						for(Category aux : categoryList) {
							out.append("<option value=" + aux.getId() + ">" + aux.getName() + "</option>");
						}
					%>
				</select>
			</div>
			<div class="formField">
				<label for="uploadFile">Image</label> 
				<input type="file" name="uploadFile" class="uploadFile" required>
			</div>
			<div class="buttons">
				<button type="submit" class="register">Add Item</button>
			</div>
		</form>
		<div class="buttons">
			<a href="shop"><button class="register">Back shop</button></a>
		</div>
	</div>
</body>
<script type="text/javascript" src="./js/dropMenu.js"></script>
</html>