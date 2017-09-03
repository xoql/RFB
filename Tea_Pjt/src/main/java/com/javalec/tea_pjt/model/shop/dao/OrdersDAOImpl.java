package com.javalec.tea_pjt.model.shop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javalec.tea_pjt.model.shop.dto.OrdersDTO;

@Repository
public class OrdersDAOImpl implements OrdersDAO{

	@Inject
	SqlSession sqlSession;

	@Override
	public void insert_order(OrdersDTO dto) {
		sqlSession.insert("orders.cart_orders",dto);
	}

	@Override
	public int selectRownum() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("orders.selectRownum");
	}

	@Override
	public void insert_orders_detail(OrdersDTO dto) {
		sqlSession.insert("orders.orders_detail",dto);
	}

	@Override
	public List<OrdersDTO> ordersCount(String option,int number) {
		Map<String,Object> map = new HashMap<>();
		map.put("option",option);
		map.put("number",number);
		return sqlSession.selectList("orders.orders_count",map);
	}

	@Override
	public List<OrdersDTO> order_history(String userid) {
		return sqlSession.selectList("orders.order_history",userid);
	}

	@Override
	public List<OrdersDTO> ordersMoney(String option,int number) {
		Map<String,Object> map = new HashMap<>();
		map.put("option",option);
		map.put("number",number);
		return sqlSession.selectList("orders.orders_money",map);
	}
	
	
}
