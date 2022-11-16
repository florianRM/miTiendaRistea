package com.jacaranda.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.jacaranda.category.Category;


public class CategoryControl {
	
	private Session session = null;
	
	public CategoryControl() {
		ConnectionDB connection = new ConnectionDB();
		session = connection.getSession();
	}
	
	public List<Category> getCategories() {
		@SuppressWarnings("unchecked")
		Query<Category> query = session.createQuery("SELECT c FROM Category c");
		return query.getResultList();
	}
}
