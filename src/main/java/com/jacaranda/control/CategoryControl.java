package com.jacaranda.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.jacaranda.category.Category;

public class CategoryControl {
	
	private static StandardServiceRegistry sr;
	private static SessionFactory sf;
	private static Session session;
	
	public CategoryControl() {
		sr = new StandardServiceRegistryBuilder().configure().build();
		sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		session = sf.openSession();
	}
	
	public List<Category> getCategories() {
		@SuppressWarnings("unchecked")
		Query<Category> query = session.createQuery("SELECT c FROM Category c");
		return query.getResultList();
	}
}
