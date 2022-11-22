package com.jacaranda.carrito;

import java.util.Comparator;

public class OrderItemByDate implements Comparator<ItemCart> {

	@Override
	public int compare(ItemCart o1, ItemCart o2) {
		return -o1.getDate().compareTo(o2.getDate());
	}

}
