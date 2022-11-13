package com.jacaranda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.jasper.tagplugins.jstl.core.Out;

import com.jacaranda.control.UsersControl;
import com.jacaranda.users.Users;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("error.jsp?errorId=0002");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		session.setAttribute("username", username);
		session.setAttribute("login", "true");
		
		if(username != null && password != null) {
			UsersControl daoUser = null;
			try {
				daoUser = new UsersControl();
				
				String encriptedPass = DigestUtils.md5Hex(password);
				Users user = new Users(username, encriptedPass);
				
				if(daoUser.checkUser(user) == true) {
					System.out.println("dentro");
					response.sendRedirect("shop");
				} else {
					response.sendRedirect("index.jsp?msg=The user or password is not correct");
				}
			} catch (Exception e) {
				response.sendRedirect("error.jsp?errorId=0001&msg=" + e.getMessage());
			}
			
		}
	}

}
