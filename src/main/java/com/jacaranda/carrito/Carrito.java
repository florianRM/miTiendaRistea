package com.jacaranda.carrito;

import java.util.ArrayList;

public class Carrito {
	private ArrayList<ItemCart> itemList;
	
	public Carrito() {
		itemList = new ArrayList<ItemCart>();
	}

	public ArrayList<ItemCart> getItemList() {
		return itemList;
	}

	public void setItemList(ItemCart itemList) {
		this.itemList.add(itemList);
	}
	
	
}
