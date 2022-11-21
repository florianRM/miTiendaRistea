package com.jacaranda.control;

import org.hibernate.Session;

import com.jacaranda.carrito.ItemCart;

public class ItemCartControl {
	
	private Session session = null;
	
	public ItemCartControl() {
		ConnectionDB connection = new ConnectionDB();
		session = connection.getSession();
	}
	
	public void addItems(ItemCart items) {
		session.getTransaction().begin();
		session.save(items);
		session.getTransaction().commit();
	}
}
