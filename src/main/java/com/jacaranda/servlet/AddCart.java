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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		String user = (String) session.getAttribute("username");
		
		String id = request.getParameter("id");
		String amount = request.getParameter("amount");
		//El párametro nos muestra si hay que restar o sumar 1 a la cantidad
		String operation = request.getParameter("operation");
		boolean cancel = Boolean.parseBoolean(request.getParameter("cancel"));
		
		//Comprobamos si ha pulsado el botón de cancelar el pedido y borramos el carrito
		if(cancel) {
			session.removeAttribute("cart");
			response.sendRedirect("shop");
		//Comprobamos que no se haya introducido un id nulo
		} else if(id == null) {
			response.sendRedirect("error.jsp?errorId=0003&msg=Id or amount cannot be null.");
		} else {
			ItemControl daoItem = new ItemControl();
			UsersControl daoUsers = null;
			try {
				daoUsers = new UsersControl();
			} catch (Exception e) {
				response.sendRedirect("error.jsp");
			}
			Item auxItem = daoItem.getItem(id);
			ItemCart itemCart = null;
			int amountInt = Integer.parseInt(amount);
			
			//Comprobamos si el carrito existe y si es así procedemos a introducir el item
			if(cart != null) {
				//Creamos el nuevo item carrito
				itemCart = new ItemCart(auxItem, daoUsers.getUser(user), amountInt, auxItem.getPrice());
				//Comprobamos si existe ese item en el carrito
				int pos = cart.getItemList().indexOf(itemCart);
				//Si existe le sumamos o le quitamos a la cantidad y hacemos lo mismo con el precio
				if(pos != -1 && operation != null) {
					int operationNumber = Integer.parseInt(operation);
					ItemCart aux = cart.getItemList().get(pos);
					aux.setAmount(aux.getAmount() + operationNumber);
					aux.setPrice(auxItem.getPrice() * aux.getAmount());
					response.sendRedirect("cart.jsp");
				} else {
				//Si el item no existe en el carrito solo lo añadimos
					cart.setItemList(itemCart);
					response.sendRedirect("shop");
				}
			//En caso de que no exista el carrito se crea un nuevo y se le agrega el item
			} else {
				ShoppingCart newCart = new ShoppingCart();
				itemCart = new ItemCart(daoItem.getItem(id), daoUsers.getUser(user), amountInt, auxItem.getPrice());
				newCart.setItemList(itemCart);
				session.setAttribute("cart", newCart);
				response.sendRedirect("shop");
			}
		}
	}
}
