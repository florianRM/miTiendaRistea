package com.jacaranda.carrito;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class ItemCartId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String item;
	private LocalDateTime purchase_date;
	
	public ItemCartId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemCartId(String user, String item, LocalDateTime date) {
		super();
		this.user = user;
		this.item = item;
		this.purchase_date = date;
	}

	public String getUserId() {
		return user;
	}

	public void setUserId(String user) {
		this.user = user;
	}

	public String getItemId() {
		return item;
	}

	public void setItemId(String item) {
		this.item = item;
	}
	
	public LocalDateTime getDate() {
		return purchase_date;
	}

	public void setDate(LocalDateTime date) {
		this.purchase_date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(purchase_date, item, user);
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
		return Objects.equals(purchase_date, other.purchase_date) && Objects.equals(item, other.item)
				&& Objects.equals(user, other.user);
	}

}
