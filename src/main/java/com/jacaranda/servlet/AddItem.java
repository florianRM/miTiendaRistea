package com.jacaranda.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.query.Query;

import com.jacaranda.category.Category;
import com.jacaranda.control.ConnectionDB;
import com.jacaranda.item.Item;

/**
 * Servlet implementation class AddItem
 */
@WebServlet("/AddItem")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 
					maxFileSize=1024*1024*50,
					maxRequestSize=1024*1024*100)
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItem() {
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
		String username = (String) session.getAttribute("username");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		
		//Conseguimos la foto del formulario mediante el objeto part
	    Part part = request.getPart("uploadFile");
	    
	    InputStream fileContent = part.getInputStream();
	    
	    Category aux = new Category(category);
	     Item item = new Item(id, name, description, price, aux);
	     
	    /* try {
			daoItem.addItem(item);
			Query uploadQuery = ConnectionDB.getSession().createQuery("insert into Item (img) values (fileContent)");
			response.sendRedirect("addItem.jsp");
		} catch (Exception e) {
			response.sendRedirect("error.jsp?errorId=0001&msg=" + e.getMessage());
		} */
	}

}
