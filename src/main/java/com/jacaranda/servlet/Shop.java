package com.jacaranda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacaranda.category.Category;
import com.jacaranda.control.CategoryControl;
import com.jacaranda.control.UsersControl;
import com.jacaranda.item.Item;
import com.jacaranda.users.Users;

/**
 * Servlet implementation class Shop
 */
@WebServlet("/shop")
public class Shop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shop() {
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
		UsersControl daoUser = null;
		try {
			daoUser = new UsersControl();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean isAdmin = false;
		
		Users user = new Users(name, "");
		try {
			isAdmin = daoUser.getUser(user).isAdmin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(login == null && name == null) {
			response.sendRedirect("error.jsp?errorId=0002");
		} else {
			CategoryControl daoCategory = new CategoryControl();
			List<Category> categoryList = daoCategory.getCategories();
			
			PrintWriter out = response.getWriter();
			//Empezamos escribiendo la estructura del html
			out.append("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n"
					+ "<link rel=\"stylesheet\" href=\"./css/style.css\">\r\n"
					+ "<script src=\"https://kit.fontawesome.com/acaa90b7af.js\" crossorigin=\"anonymous\"></script>"
					+ "</head>\r\n"
					+ "<body>\r\n");
			
			//Escribimos el header del html
			out.append("<header>\r\n"
					+ "		<h1>BotanicaLandia</h1>\r\n"
					+ "		<div class=\"icons\">\r\n"
					+ "			<ul>\r\n");
			if(isAdmin) {
				out.append("<li><a href=\"addItem.jsp\"><button class=\"addItem\">Add Item</button></a></li>\r\n");
			}
			out.append("			<li><a><i class=\"fa-solid fa-cart-shopping\"></i></a></li>\r\n"
					+ "				<li><i class=\"fa-solid fa-user\"></i></li>\r\n"
					+ "				<li class=\"user\"><strong>Welcome</strong><br>" + name + "</li>\r\n"
					+ "			</ul>\r\n"
					+ "		</div>\r\n"
					+ "	</header>"
					+ " <div class=\"drop-menu\">"
					+ "   <button class=\"logout\">Log out</button>"
					+ "</div>");
			
			//Recorremos la lista de items y las vamos escribiendo en el html
			out.append("<div class=\"grid-container\">");
			for(Category category : categoryList) {
				for(Item item : category.getItems()) {
					out.append("<div class=\"grid-item\">\r\n"
							+ "		<div class=\"item-title\">\r\n"
							+ "			<h3>" + item.getName() + "</h3>\r\n"
							+ "		</div>\r\n"
							+ "		<div class=\"item-info\">\r\n"
							+ "			<ul>\r\n"
							+ "				<li>Id: " + item.getId() + "</li>\r\n"
							+ "				<li>Description: " + item.getDescription() + "</li>\r\n"
							+ "				<li>Price: " + item.getPrice() + "</li>\r\n"
							+ "			</ul>\r\n"
							+ "		</div>\r\n"
							+ "		<div class=\"item-img\">\r\n");
							if(item.getImgUrl() != null) {
								out.append("<img alt=\"\" src=\"./uploadedImages/" + item.getImgUrl() + "\">");
							} else {
								out.append("<p>No photo yet</p>\r\n");
							}
							out.append("</div>\r\n"
							+ "		</div>\r\n");
				}
			}
			//Por último cerramos la tabla y el html
			out.append("</div>"
					+ "</body>\r\n"
					+ "<script type=\"text/javascript\" src=\"./js/dropMenu.js\"></script>"
					+ "</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
