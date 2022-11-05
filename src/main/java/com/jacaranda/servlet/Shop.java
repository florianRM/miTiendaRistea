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
import com.jacaranda.item.Item;

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
		
		if(login == null && name == null) {
			response.sendRedirect("error.jsp");
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
					+ "			<ul>\r\n"
					+ "				<li><a><i class=\"fa-solid fa-cart-shopping\"></i></a></li>\r\n"
					+ "				<li><i class=\"fa-solid fa-user\"></i></li>\r\n"
					+ "				<li class=\"user\"><strong>Welcome</strong><br>" + name + "</li>\r\n"
					+ "			</ul>\r\n"
					+ "		</div>\r\n"
					+ "	</header>"
					+ " <div class=\"drop-menu\">"
					+ "   <button class=\"logout\">Log out</button>"
					+ "</div>");
			
			//Creamos la tabla donde se listara todo
			out.append("<table align=\"center\">\r\n"
					+ "     <caption>Our plants</caption>"
					+ "		<thead>\r\n"
					+ "			<tr>\r\n"
					+ "				<th><h3>Category</h3></th>\r\n"
					+ "				<th><h3>Id</h3></th>\r\n"
					+ "				<th><h3>Name</h3></th>\r\n"
					+ "				<th><h3>Description</h3></th>\r\n"
					+ "				<th><h3>Price</h3></th>\r\n"
					+ "			</tr>\r\n"
					+ "		</thead>\r\n"
					+ "		<tbody>\r\n");
			
			//Recorremos la lista de items y las vamos escribiendo en el html
			for(Category category : categoryList) {
				for(Item item : category.getItems()) {
					out.append("<tr>\r\n"
							+ "		<td>" + category.getName() +"</td>\r\n"
							+ "		<td>" + item.getId() +"</td>\r\n"
							+ "		<td>" + item.getName() +"</td>\r\n"
							+ "		<td>" + item.getDescription() +"</td>\r\n"
							+ "		<td>" + item.getPrice() +"</td>\r\n"
							+ "	</tr>");
				}
			}
			
			//Por último cerramos la tabla y el html
			out.append("</tbody>\r\n"
					+ "	</table>\r\n"
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
