<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.jacaranda.carrito.ItemCart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jacaranda.control.ItemCartControl"%>
<%@page import="com.jacaranda.carrito.ShoppingCart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/cartStyle.css">
<script src="https://kit.fontawesome.com/acaa90b7af.js" crossorigin="anonymous"></script>
</head>
<body>
<%
	ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
	String name = (String) session.getAttribute("username");
%>
<header>
 <h1>BotanicaLandia</h1>
	<div class="icons">
		<ul>
			<li><a href="cart.jsp"><i class="fa-solid fa-cart-shopping"></i></a></li>
			<li><i class="fa-solid fa-user"></i></li>
			<li class="user"><strong>Welcome</strong><br><%=name %></li>
		</ul>
	</div>
</header>
<div class="drop-menu">
	<button class="logout">Log out</button>
</div>
<div class="container_cart">
	<%if(cart != null) {
		for(ItemCart aux : cart.getItemList()) {
		String itemId = aux.getItem().getId();
		%>
		<div class="item">
				<div class="itemField">
					<h4>Item name: </h4><span><%=aux.getItem().getName() %></span>
				</div>
				<div class="itemField">
					<h4>Price: </h4><span><%=aux.getPrice() %></span>
				</div>
					<div class="itemField">
						<h4>Amount: </h4>
						<%if(aux.getAmount() == 1) {%>
							<button class="removeItem" disabled="disabled">-</button>
						<%} else {%>
							<button type="submit" class="removeItem" onclick="location.assign('addCart?id=<%= itemId%>&operation=-1')">-</button>
						<%}%>
						<input name="amount" class="amount" value="<%=aux.getAmount() %>" readonly="readonly">
						<button class="addItemButton" onclick="location.assign('addCart?id=<%= itemId%>&operation=1')">+</button>
					</div>
		</div>
	<%}%>
		<a href="buyItem"><button>Buy</button></a>
		<a href="shop"><button onclick="location.assign('addCart?cancel=true')">Cancel</button></a>
	<%} else {%>
		<div class="standarMsg">
			<p>Cart is empty :(</p>
		</div>
	<%}%>
	<a href="shop"><button>Back shop</button></a>
</div>
</body>
<script type="text/javascript" src="./js/dropMenu.js"></script>
</html>