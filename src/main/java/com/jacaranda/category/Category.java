package com.jacaranda.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.jacaranda.item.Item;

@Entity
public class Category {
	
	@Id
	private String id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Item> itemList = new ArrayList<>();

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Category(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public void addItem(Item item) {
		this.itemList.add(item);
		item.setCategory_id(this);
	}
	
	public void removeItem(Item item) {
		this.itemList.remove(item);
		item.setCategory_id(null);
	}
	
	public List<Item> getItems() {
		return this.itemList;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", itemList=" + itemList
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}
	
}