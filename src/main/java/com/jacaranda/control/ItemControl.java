package com.jacaranda.control;

import org.hibernate.Session;

import com.jacaranda.item.Item;

public class ItemControl {
	
	private static Session session = ConnectionDB.getSession();

	public ItemControl() {
	}
	
	public static void addItem(Item item) throws Exception {
		Item aux = session.get(Item.class, item.getId());
		
		if(aux != null) {
			throw new Exception("Id exist");
		}
		
		session.getTransaction().begin();
		session.save(item);
		session.getTransaction().commit();
	}
	
	public static Item getItem(String id) {
		return session.get(Item.class, id);
	}
}
