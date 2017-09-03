package com.javalec.tea_pjt.service.shop;

import java.util.List;

import com.javalec.tea_pjt.model.shop.dto.OrdersDTO;

public interface OrdersService {

	public void insert_order(OrdersDTO dto);
	public void insert_orders_detail(OrdersDTO dto);
	public int selectRownum();
	public List<OrdersDTO> ordersCount(String option,int number);
	public List<OrdersDTO> ordersMoney(String option,int number);
	public List<OrdersDTO> order_history(String userid);
}
