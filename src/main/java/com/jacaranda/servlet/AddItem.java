package com.jacaranda.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jacaranda.category.Category;
import com.jacaranda.control.ItemControl;
import com.jacaranda.item.Item;

/**
 * Servlet implementation class AddItem
 */
@WebServlet("/addItem")
//Indicamos el tamaño de los archivos permitidos
@MultipartConfig(fileSizeThreshold=1024*1024*10, 
					maxFileSize=1024*1024*50,
					maxRequestSize=1024*1024*100) 
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Ruta relativa del directorio donde se guardaran los archivos
       
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
		final String uploadDir = "miTiendaRistea\\src\\main\\webapp\\uploadedImages";
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		
		if(id != null && name != null && price != null && category != null) {
			
			//Cogemos la ruta absoluta
			String filePath = getServletContext().getRealPath("");
			//Buscamos la posición del punto
			int position = filePath.indexOf(".");
			//Cortamos la ruta absoluta hasta la posición del punto y le añadimos la nuestra
			String uploadFilePath = filePath.substring(0, position) + uploadDir;
			 //Convertimos la ruta en un fichero y si no existe lo creamos
			 File fileSaveDir = new File(uploadFilePath);
		     if (!fileSaveDir.exists()) {
		    	 fileSaveDir.mkdirs();
		     }
		     ItemControl daoItem = new ItemControl();
		     
		     Category aux = new Category(category);
		     Item item = new Item(id, name, description, price, aux);
		     
		     try {
				daoItem.addItem(item);
				//Conseguimos la foto del formulario mediante la clase part
			     Part part = request.getPart("uploadFile");
			     //Introducimos la foto en la ruta creada anteriormente y su nombre
			     part.write(uploadFilePath + File.separator + part.getSubmittedFileName());
				response.sendRedirect("addItem.jsp");
			} catch (Exception e) {
				response.sendRedirect("error.jsp?msg=" + e.getMessage());
			}
		}
	 
	}
}
