package com.jacaranda.control;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.jacaranda.users.Users;

public class UsersControl {
	
	public UsersControl() throws Exception {
	}
	
	public boolean checkUser(Users user) throws Exception {
		Session session = comprobationSession();
		boolean exist = false;
		Users aux = null;
		
		aux = session.get(Users.class, user.getUsername());
		
		if((aux != null) && (aux.getUsername().equals(user.getUsername()) && aux.getPassword().equals(user.getPassword()))) {
			exist = true;
		}
		
		return exist;
	}
	
	public void registerUser(Users user) throws Exception {
		Session session = comprobationSession();
		try {
			session.getTransaction().begin();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new Exception("User already exist");
		}
	}
	
	public Users getUser(Users user) throws Exception {
		Session session = comprobationSession();
		Users aux = null;
		
		aux = session.get(Users.class, user.getUsername());
		
		return aux;
	}
	
	private Session comprobationSession() throws Exception {
		Session session = null;
		try {
			session = ConnectionDB.getSession();
		} catch (HibernateException e) {
			throw new Exception(e.getMessage());
		}
		return session;
	}
}
