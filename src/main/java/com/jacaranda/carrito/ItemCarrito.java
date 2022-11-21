package com.jacaranda.carrito;

import java.time.LocalDateTime;
import java.util.Objects;

public class ItemCarrito {
	
	private String userId;
	private String itemId;
	private LocalDateTime date;
	
	public ItemCarrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemCarrito(String userId, String itemId, LocalDateTime date) {
		super();
		this.userId = userId;
		this.itemId = itemId;
		this.date = date;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCarrito other = (ItemCarrito) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(userId, other.userId);
	}
	
}
