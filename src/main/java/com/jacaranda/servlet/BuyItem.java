package com.jacaranda.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;

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
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		ItemCartControl daoItemCart = new ItemCartControl();
		boolean outStock = false;
		
		for (Iterator<ItemCart> iterator = cart.getItemList().iterator(); iterator.hasNext() && !outStock;) {
			ItemCart itemCart = (ItemCart) iterator.next();
			int finalAmount = itemCart.getItem().getAmount() - itemCart.getAmount();
			
			if(finalAmount <= 0) {
				outStock = true;
				response.sendRedirect("error.jsp?errorId=0003&msg=" + itemCart.getItem().getName() + "out of stock");
			} else {
				itemCart.setDate(LocalDateTime.now());
				itemCart.getItem().setAmount(finalAmount);
				daoItemCart.addItems(itemCart);
			}
		}
		
		if(!outStock) {
			session.removeAttribute("cart");
			response.sendRedirect("shop");
		}
	}

}
