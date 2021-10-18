package com.example.movie.backend;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	private static Orders orders = new Orders();
	
	public static Orders getInstance() {
		return orders;
	}
	private Orders() {
		
	}
	
	/**
	 * 获取订单列表
	 * @return
	 */
	public List<Order> getOrderList() {
		return orderList;
	}

	private List<Order> orderList = new ArrayList<>();
}
