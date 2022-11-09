package com.jacaranda.servlet;

import java.io.File;
import java.io.IOException;
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
	private static final String uploadDir = "uploadedImage";
       
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
		 String applicationPath = request.getServletContext().getRealPath("");
		 
		 String uploadFilePath = applicationPath + File.separator + uploadDir;
		 
		 File fileSaveDir = new File(uploadFilePath);
	     if (!fileSaveDir.exists()) {
	    	 fileSaveDir.mkdirs();
	     }
	     
	     String fileName = null;
	     for (Part part : request.getParts()) {
	            fileName = getFileName(part);
	            part.write(uploadFilePath + File.separator + fileName);
	        }
	 
	        request.setAttribute("message", fileName + " File uploaded successfully!");
	        response.sendRedirect("addItem.jsp");
	}
	
	private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }

}
