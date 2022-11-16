package com.jacaranda.servlet;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jacaranda.control.ItemControl;

/**
 * Servlet implementation class DownloadImage
 */
@WebServlet("/DownloadImage")
public class DownloadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadImage() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemControl daoItem = new ItemControl();
		//Recuperamos el id del item que llama al servlet
		String id = request.getParameter("id");
		//Recuperamos la imagen que es un tipo blob de la base de datos
		Blob img = daoItem.getItem(id).getImg();
		byte[] blobFiles = null;
		ServletOutputStream outputStream = null;
		
		try {
			//Recorremos la imagen y vamos añadiendo los bytes a un array de bytes
			blobFiles = img.getBytes(1, (int) img.length());
		} catch (SQLException e) {
			throw new ServletException("Unexpected error.");
		}
        //Conseguimos el outputstream para imprimir datos binarios en la respuesta
		outputStream = response.getOutputStream();
		//Escribimos el array de bytes en el servlet de Shop
		outputStream.write(blobFiles);
	}

}
