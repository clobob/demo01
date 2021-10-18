package com.example.movie.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Logged extends NotLogged{
	
	/**
	 * 预定电影订单数据
	 */
	private Orders orders = Orders.getInstance();
	
	/**
	 * 人员列表
	 */
	private List<People> peoples = new ArrayList<>();
	
	public Orders getOrders() {
		return orders;
	}


	public List<People> getPeoples() {
		return peoples;
	}


	public List<List<Integer>> getSelectedSeats() {
		return selectedSeats;
	}

	private List<List<Integer>> selectedSeats = new ArrayList<>();
	
	/**
	 * 预定电影
	 */
	@Override
	public Prompt orderMovie(Movie movie) {
		String id = UUID.randomUUID().toString();
		
		Order o = new Order(id, this, movie, selectedSeats);
		// 预定电影逻辑 
		orders.getOrderList().add(o);
		Prompt prompt = new Prompt();
		prompt.setMsg("预定电影成功");
		int[][] seatsModify = changeSeatsStatus(movie.getSeats(), selectedSeats, 1); // 修改座位状态
		movie.setSeats(seatsModify); //写入新座位信息
		return prompt;
	}
	
	
	/**
	 * 取消预定
	 */
	public void cancelOrder(Order order) {
		System.out.println("取消订单");
		// 取消已选座位
		changeSeatsStatus(order.getMovie().getSeats(), order.getSeatsIndex(), 0);
		// 订单列表中删除订单信息
		orders.getOrderList().remove(order);
	}
	
	/**
	 * 
	 */
	public void addPeople(int peopleClass) {
		People p = new People();
		p.setPeopleClass(peopleClass);
		peoples.add(p);
		System.out.println("添加人员");
	}
	
	/**
	 * 选座位： 记录电影 和 被选座位的坐标? 需指定具体选哪些座位
	 */
	public void selectSeat(Movie movie, int postion) {
		int count = peoples.size();
		int i = 0,j = 0; // 选取座位起始位置
		int end = 4;
		if(Position.front == postion) {
			// 不变
		}else if(Position.middle == postion)  {
			 i = 3;
			 end = 6;
		}else {
			i = 6;
			end = 10;
		}
		int[][] seats = movie.getSeats();
		selectedSeats.clear();
		//找到未选中的座位
		for(int m = i;m<end;m++) {
			for(int n =j; n<10;n++) {
				if(count>0 && seats[m][n] == 0) {
					List<Integer> index = new ArrayList<>();
					index.add(m);
					index.add(n);
					selectedSeats.add(index);
					count--; // 根据人数选择座位
				}
			}
		}
		if(count>0) {
			selectedSeats.clear(); // 清理选择的座位
			throw new RuntimeException("当前位置没有充足的座位，请重选");
		}
		
//		System.out.println("选择座位");
	}
	
	private int[][] changeSeatsStatus(int[][] seats, List<List<Integer>> seatIndex, int status) {
		for(List<Integer> seat: seatIndex) {
			seats[seat.get(0)][seat.get(1)] = status;
		}
		return seats;
	}
}
