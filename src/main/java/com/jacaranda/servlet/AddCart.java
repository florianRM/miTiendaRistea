package com.jacaranda.servlet;

import java.io.IOException;

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
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		String user = (String) session.getAttribute("username");
		String id = request.getParameter("id");
		String operation = request.getParameter("operation");
		boolean cancel = Boolean.parseBoolean(request.getParameter("cancel"));
		
		if(cancel) {
			session.removeAttribute("cart");
		} else if(id == null) {
			response.sendRedirect("error.jsp?errorId=0003&msg=Id cannot be null.");
		} else {
			ItemControl daoItem = new ItemControl();
			UsersControl daoUsers = null;
			try {
				daoUsers = new UsersControl();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Item auxItem = daoItem.getItem(id);
			ItemCart item = null;
			
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

}
