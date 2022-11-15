package com.jacaranda.item;

import java.sql.Blob;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.jacaranda.category.Category;

@Entity
public class Item {
	
	@Id
	private String id;
	private String name;
	private String description;
	private double price;
	@ManyToOne
	private Category category;
	private Blob img;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Item(String id) {
		super();
		this.id = id;
	}

	public Item(String id, String name, String description, double price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory_id() {
		return category;
	}

	public void setCategory_id(Category category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category_id=" + category + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
}