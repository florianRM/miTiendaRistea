package com.jacaranda.control;

import org.hibernate.Session;
import com.jacaranda.item.Item;

public class ItemControl {
	
	private Session session = null;
	
	public ItemControl() {
		ConnectionDB connection = new ConnectionDB();
		session = connection.getSession();
	}
	
	public void addItem(Item item) throws Exception {
		Item aux = session.get(Item.class, item.getId());
		
		if(aux != null) {
			throw new Exception("Id exist");
		}
		
		session.getTransaction().begin();
		session.save(item);
		session.getTransaction().commit();
	}
	
	public Item getItem(String id) {
		return session.get(Item.class, id);
	}
}
