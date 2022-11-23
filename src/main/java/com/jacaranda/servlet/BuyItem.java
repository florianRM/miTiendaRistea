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
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		ItemCartControl daoItemCart = new ItemCartControl();
		ItemControl daoItem = new ItemControl();
		
		for (ItemCart itemCart : cart.getItemList()) {
			int finalAmount = itemCart.getItem().getAmount() - itemCart.getAmount();
			
			itemCart.setDate(LocalDateTime.now());
			daoItem.updateAmount(itemCart.getItem().getId(), finalAmount);
			daoItemCart.addItems(itemCart);
		}
		
		session.removeAttribute("cart");
		response.sendRedirect("shop");
	}

}
