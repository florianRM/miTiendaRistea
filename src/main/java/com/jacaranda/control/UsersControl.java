package com.jacaranda.control;

import org.hibernate.Session;

import com.jacaranda.users.Users;

public class UsersControl {
	
	private Session session = ConnectionDB.getSession();

	public UsersControl() {
	}
	
	public boolean checkUser(Users user) throws Exception {
		boolean exist = false;
		Users aux = null;
		
		try {
			 aux = session.get(Users.class, user.getUsername());
		} catch (Exception e) {
			throw new Exception("Connection error. Contact an administrator");
		}
		
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
	
	public Users getUser(Users user) throws Exception {
		Users aux = null;
		
		try {
			aux = session.get(Users.class, user.getUsername());
		} catch (Exception e) {
			throw new Exception("Connection error. Contact an administrator");
		}
		
		return aux;
	}
}
