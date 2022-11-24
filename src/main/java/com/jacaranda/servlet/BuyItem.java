package com.jacaranda.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacaranda.carrito.ItemCart;
import com.jacaranda.carrito.ShoppingCart;
import com.jacaranda.control.ItemCartControl;
import com.jacaranda.control.ItemControl;

/**
 * Servlet implementation class BuyItem
 */
@WebServlet("/buyItem")
public class BuyItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyItem() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("username");
		String login = (String) session.getAttribute("login");
		if(name == null && login == null) {
			response.sendRedirect("error.jsp?errorId=0002");
		} else {
			ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
			ItemCartControl daoItemCart = new ItemCartControl();
			ItemControl daoItem = new ItemControl();
			StringBuilder parameters = new StringBuilder();
			
			if(cart != null) {
				for (ItemCart itemCart : cart.getItemList()) {
					int finalAmount = itemCart.getItem().getAmount() - itemCart.getAmount();
					//Comprobamos que si la cantidad final es menor que 0
					if(finalAmount < 0) {
						//Conseguimos la cantidad del item
						int amount = itemCart.getItem().getAmount();
						itemCart.setDate(LocalDateTime.now());
						//Actualizamos la cantidad del item y la ponemos a 0
						daoItem.updateAmount(itemCart.getItem().getId(), 0);
						//A la compra le asignamos la cantidad restante del producto
						itemCart.setAmount(amount);
						daoItemCart.addItems(itemCart);
						//Le añadimos un mensaje para avisar de que no hay suficiente cantidad
						parameters.append("msg=You could only buy " + amount + " " + itemCart.getItem().getName() + "&");
					} else {
						itemCart.setDate(LocalDateTime.now());
						daoItem.updateAmount(itemCart.getItem().getId(), finalAmount);
						daoItemCart.addItems(itemCart);
					}
				}
				//Al terminarse la compra se borra el carrito
				session.removeAttribute("cart");
				
				//Si el stringbuilder de mensajes no esta vació se lo enviamos por parámetros
				if(parameters.length() != 0) {
					response.sendRedirect("cart.jsp?" + parameters.toString());
				} else {
					response.sendRedirect("shop");
				}
			} else {
				response.sendRedirect("error.jsp?errorId=0003&msg=Cart cannot be null");
			}
		}
	}

}
