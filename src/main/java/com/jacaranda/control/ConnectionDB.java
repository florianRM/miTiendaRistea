package com.jacaranda.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ConnectionDB {
	private static StandardServiceRegistry sr;
	private static SessionFactory sf;
	private static Session session;
	
	static {
		try {
			sr = new StandardServiceRegistryBuilder().configure().build();
			sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
			session = sf.openSession();
		} catch (Exception e) {
			throw new Error();
		}
	}
	
	public static Session getSession() {
		return ConnectionDB.session;
	}
}
