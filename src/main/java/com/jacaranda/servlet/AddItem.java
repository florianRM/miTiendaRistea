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
	private static final String uploadDir = "uploadedImages";
       
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
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		
		String uploadFilePath = getServletContext().getRealPath(uploadDir);
		 
		 File fileSaveDir = new File(uploadFilePath);
	     if (!fileSaveDir.exists()) {
	    	 fileSaveDir.mkdirs();
	     }

	     Part part = request.getPart("uploadFile");
	     part.write(uploadFilePath + File.separator + part.getSubmittedFileName());
	 
	     response.sendRedirect("addItem.jsp");
	}
}
