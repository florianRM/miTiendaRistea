package com.jacaranda.control;

import org.hibernate.Session;

import com.jacaranda.users.Users;

public class UsersControl {
	
	private Session session = ConnectionDB.getSession();

	public UsersControl() {
	}
	
	public boolean checkUser(Users user) {
		boolean exist = false;
		Users aux = session.get(Users.class, user.getUsername());
		
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
}
