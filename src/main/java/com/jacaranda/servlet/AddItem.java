package com.jacaranda.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Hibernate;

import com.jacaranda.category.Category;
import com.jacaranda.control.ConnectionDB;
import com.jacaranda.control.ItemControl;
import com.jacaranda.item.Item;

/**
 * Servlet implementation class AddItem
 */
@WebServlet("/addItem")
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		
		//Conseguimos la foto del formulario mediante el objeto part
	    Part part = request.getPart("uploadFile");
	    
	    //Conseguimos los bytes de la imagen
	    InputStream fileContent = part.getInputStream();
	    //Conseguimos un creador de datos blob para esta sesión y creamos un blob con la imagen
	    Blob blob = Hibernate.getLobCreator(ConnectionDB.getSession()).createBlob(fileContent, fileContent.available());
	    
	    Category aux = new Category(category);
	    Item item = new Item(id, name, description, price, aux);
	    //Le añadimos al item la imagen de tipo blob
	    item.setImg(blob);
	    try {
			ItemControl.addItem(item);
			response.sendRedirect("addItem.jsp");
		} catch (Exception e) {
			response.sendRedirect("error.jsp");
		}
	}

}
