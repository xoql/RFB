package com.javalec.tea_pjt.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.javalec.tea_pjt.model.shop.dao.OrdersDAO;
import com.javalec.tea_pjt.model.shop.dto.OrdersDTO;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Inject
	OrdersDAO orderDAO;

	@Override
	public void insert_order(OrdersDTO dto) {
		orderDAO.insert_order(dto);
	}

	@Override
	public int selectRownum() {
		// TODO Auto-generated method stub
		return orderDAO.selectRownum();
	}

	@Override
	public void insert_orders_detail(OrdersDTO dto) {
		orderDAO.insert_orders_detail(dto);
	}

	@Override
	public List<OrdersDTO> ordersCount(String option,int number) {
		// TODO Auto-generated method stub
		return orderDAO.ordersCount(option,number);
	}

	@Override
	public List<OrdersDTO> order_history(String userid) {
		// TODO Auto-generated method stub
		return orderDAO.order_history(userid);
	}

	@Override
	public List<OrdersDTO> ordersMoney(String option,int number) {
		// TODO Auto-generated method stub
		return orderDAO.ordersMoney(option,number);
	}

}
