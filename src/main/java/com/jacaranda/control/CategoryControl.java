package com.jacaranda.control;

import java.util.List;

import org.hibernate.query.Query;

import com.jacaranda.category.Category;

public class CategoryControl {

	public CategoryControl() {
	}
	
	public List<Category> getCategories() {
		@SuppressWarnings("unchecked")
		Query<Category> query = ConnectionDB.getSession().createQuery("SELECT c FROM Category c");
		return query.getResultList();
	}
}
