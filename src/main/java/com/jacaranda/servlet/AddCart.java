package com.jacaranda.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacaranda.carrito.ItemCart;
import com.jacaranda.carrito.ShoppingCart;
import com.jacaranda.control.ItemControl;
import com.jacaranda.control.UsersControl;
import com.jacaranda.item.Item;
import com.jacaranda.users.Users;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/addCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		String user = (String) session.getAttribute("username");
		String id = request.getParameter("id");
		String operation = request.getParameter("operation");
		
		ItemControl daoItem = new ItemControl();
		UsersControl daoUsers = null;
		try {
			daoUsers = new UsersControl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ItemCart item = null;
		Item auxItem = daoItem.getItem(id);
	
		if(cart != null) {
			item = new ItemCart(auxItem, daoUsers.getUser(user), 1, auxItem.getPrice());
			int pos = cart.getItemList().indexOf(item);
			if(pos != -1 && operation != null) {
				int operationNumber = Integer.parseInt(operation);
				ItemCart aux = cart.getItemList().get(pos);
				aux.setAmount(aux.getAmount() + operationNumber);
				aux.setPrice(auxItem.getPrice() * aux.getAmount());
				response.sendRedirect("cart.jsp");
			} else {
				cart.setItemList(item);
				response.sendRedirect("shop");
			}
			
		} else {
			ShoppingCart newCart = new ShoppingCart();
			item = new ItemCart(daoItem.getItem(id), daoUsers.getUser(user), 1, auxItem.getPrice());
			newCart.setItemList(item);
			session.setAttribute("cart", newCart);
			response.sendRedirect("shop");
		}
	}

}
