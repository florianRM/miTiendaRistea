package com.jacaranda.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

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
	
	public List<ItemCart> getPurchases(String username) {
		@SuppressWarnings("unchecked")
		Query<ItemCart> query = session.createQuery("SELECT ic FROM Bought ic WHERE username_id = '" + username + "'");
		return query.list();
	}
}
