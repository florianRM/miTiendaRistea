package com.jacaranda.carrito;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jacaranda.item.Item;
import com.jacaranda.users.Users;

@Entity(name = "Bought")
@IdClass(ItemCartId.class)
public class ItemCart {
	
	@Id
	@ManyToOne
	@JoinColumn(name="item_id", insertable = false, updatable = false)
	private Item item;
	@Id
	@ManyToOne
	@JoinColumn(name="username_id", insertable = false, updatable = false)
	private Users user;
	private int amount;
	private double price;
	private LocalDateTime purchase_date;
	
	public ItemCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ItemCart(Item item, Users user) {
		super();
		this.item = item;
		this.user = user;
	}



	public ItemCart(Item item, Users user, int amount, double price) {
		super();
		this.item = item;
		this.user = user;
		this.amount = amount;
		this.price = price;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getDate() {
		return purchase_date;
	}

	public void setDate(LocalDateTime date) {
		this.purchase_date = date;
	}
	
	@Override
	public String toString() {
		return "ItemCart [item=" + item + ", user=" + user + ", amount=" + amount + ", price=" + price
				+ ", purchase_date=" + purchase_date + "]";
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
		ItemCart other = (ItemCart) obj;
		return Objects.equals(item, other.item) && Objects.equals(user, other.user);
	}
	
}
