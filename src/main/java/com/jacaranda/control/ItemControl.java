package com.jacaranda.control;

import org.hibernate.Session;

import com.jacaranda.item.Item;

public class ItemControl {
	private Session session = ConnectionDB.getSession();

	public ItemControl() {
	}
	
	public void addItem(Item item) throws Exception {
		/*try {
			session.getTransaction().begin();
			session.save(item);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new Exception("Id exist");
		}*/
		Item aux = session.get(Item.class, item.getId());
		
		if(aux != null) {
			throw new Exception("Id exist");
		}
		
		session.getTransaction().begin();
		session.save(item);
		session.getTransaction().commit();
	}
}
