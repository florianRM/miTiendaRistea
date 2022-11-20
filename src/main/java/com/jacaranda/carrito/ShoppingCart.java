package com.jacaranda.carrito;

import java.util.ArrayList;

public class ShoppingCart {
	
	private ArrayList<ItemCart> itemList;
	
	public ShoppingCart() {
		itemList = new ArrayList<>();
	}

	public ArrayList<ItemCart> getItemList() {
		return itemList;
	}

	public void setItemList(ItemCart item) {
		itemList.add(item);
	}
	
}
