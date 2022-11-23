<%@page import="java.util.List"%>
<%@page import="com.jacaranda.carrito.OrderItemByDate"%>
<%@page import="com.jacaranda.carrito.ItemCart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="daoUser" class="com.jacaranda.control.UsersControl"></jsp:useBean>
<jsp:useBean id="daoItemCart" class="com.jacaranda.control.ItemCartControl"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/purchasesStyle.css">
<script src="https://kit.fontawesome.com/acaa90b7af.js" crossorigin="anonymous"></script>
</head>
<body>
<%
	String name = (String) session.getAttribute("username");
	String login = (String) session.getAttribute("login");
	
	if(login != null && name != null) {
		boolean isAdmin = daoUser.getUser(name).isAdmin();
		List<ItemCart> purchasesList = daoItemCart.getPurchases(name);
		purchasesList.sort(new OrderItemByDate());%>
		<header>
		 <h1>BotanicaLandia</h1>
			<div class="icons">
				<ul>
					<li><a href="purchases.jsp"><button class="purchases">Purchases</button></a></li>
					<%if(isAdmin) {
						out.append("<li><a href=\"addItem.jsp\"><button class=\"addItem\">Add Item</button></a></li>\r\n");
					}%>
					<li><a href="cart.jsp"><i class="fa-solid fa-cart-shopping"></i></a></li>
					<li><i class="fa-solid fa-user"></i></li>
					<li class="user"><strong>Welcome</strong><br><%=name %></li>
				</ul>
			</div>
		</header>
		<div class="drop-menu">
			<button class="logout">Log out</button>
		</div>
		<div class="container_purchases">
			<%if(purchasesList != null) {%>
				<table>
				<caption>Purchases details</caption>
					<tr>
						<th>Name</th>
						<th>Item Name</th>
						<th>Amount</th>
						<th>Price</th>
						<th>Purchase Date</th>
					</tr>
					<%for(ItemCart aux : purchasesList) {%>
					<tr>
						<td><%=aux.getUser().getName() %></td>
						<td><%=aux.getItem().getName() %></td>
						<td><%=aux.getPrice() %></td>
						<td><%=aux.getAmount() %></td>
						<td><%=aux.getDate() %></td>
					<tr>
				<%} %>
				</table>
			<%} else {
				out.append("<h3>You don't have purchases yet</h3>");
			}%>
		</div>
	<%} else {
		response.sendRedirect("error.jsp?errorId=0002");
	}%>
</body>
<script type="text/javascript" src="./js/dropMenu.js"></script>
</html>