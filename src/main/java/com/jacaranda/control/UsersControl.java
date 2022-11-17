package com.jacaranda.control;

import org.hibernate.Session;

import com.jacaranda.users.Users;

public class UsersControl {

	private Session session = null;
	
	public UsersControl() throws Exception {
		ConnectionDB connection = null;
		try {
			connection = new ConnectionDB();
		} catch (Exception e) {
			throw new Exception("Error establishing a database connection. Please contact an administrator.");
		}
		session = connection.getSession();
	}
	
	public boolean checkUser(Users user) {
		boolean exist = false;
		Users aux = null;
		
		aux = session.get(Users.class, user.getUsername());
		
		if((aux != null) && (aux.getUsername().equals(user.getUsername()) && aux.getPassword().equals(user.getPassword()))) {
			exist = true;
		}
		
		return exist;
	}
	
	public void registerUser(Users user) throws Exception {
		try {
			session.getTransaction().begin();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new Exception("User already exist");
		}
	}
	
	public Users getUser(Users user) {
		Users aux = null;
		
		aux = session.get(Users.class, user.getUsername());
		
		return aux;
	}
	
}
