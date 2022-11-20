package com.jacaranda.carrito;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.jacaranda.item.Item;
import com.jacaranda.users.Users;

public class ItemCartId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String item;
	
	public ItemCartId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemCartId(String user, String item, int amount, double price, LocalDateTime date) {
		super();
		this.user = user;
		this.item = item;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		return Objects.hash(item, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCartId other = (ItemCartId) obj;
		return Objects.equals(item, other.item) && Objects.equals(user, other.user);
	}

}
