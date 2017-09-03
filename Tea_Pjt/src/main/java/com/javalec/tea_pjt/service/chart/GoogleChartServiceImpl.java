package com.javalec.tea_pjt.service.chart;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.javalec.tea_pjt.model.shop.dto.CartDTO;
import com.javalec.tea_pjt.model.shop.dto.OrdersDTO;
import com.javalec.tea_pjt.service.shop.CartService;
import com.javalec.tea_pjt.service.shop.OrdersService;

@Service
public class GoogleChartServiceImpl implements GoogleChartService{

	@Inject
	CartService cartService;
	
	@Inject
	OrdersService ordersService;
	
	private static final Logger logger = LoggerFactory.getLogger(GoogleChartServiceImpl.class);
	
	@Override
	public JSONObject getChartData() {
		List<CartDTO> items = cartService.cartMoney();
		logger.info("items : " + items);
		
		JSONObject data = new JSONObject();
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		JSONArray title = new JSONArray();
		col1.put("label","상품명");//key,value
		col1.put("type","string");
		col2.put("label","금액");//컬럼 이름
		col2.put("type","number");//컬럼 자료형
		title.add(col1);
		title.add(col2);
		data.put("cols",title);//컬럼 객체 추가
		
		JSONArray body = new JSONArray();//실제 데이터
		for(CartDTO dto : items){
			JSONObject name = new JSONObject();
			name.put("v",dto.getProduct_name());
			JSONObject money = new JSONObject();
			money.put("v",dto.getMoney());
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(money);
			JSONObject cell = new JSONObject();
			cell.put("c",row);//셀 추가
			body.add(cell);//row 
		}
		data.put("rows",body);
		return data;
		
		
	}

	@Override
	public JSONObject getOrdersCount(String option,int number) {
		
		List<OrdersDTO> list = ordersService.ordersCount(option,number);
		logger.info("getOrdersCount list = " + list.toString());
		
		JSONObject data = new JSONObject();
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		JSONArray title = new JSONArray();
		col1.put("label","상품명");//key,value
		col1.put("type","string");
		col2.put("label","갯수");//컬럼 이름
		col2.put("type","number");//컬럼 자료형
		title.add(col1);
		title.add(col2);
		data.put("cols",title);//컬럼 객체 추가
		
		JSONArray body = new JSONArray();//실제 데이터
		for(OrdersDTO dto : list){
			JSONObject name = new JSONObject();
			name.put("v",dto.getProduct_name());
			JSONObject count = new JSONObject();
			count.put("v",dto.getCount());
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(count);
			JSONObject cell = new JSONObject();
			cell.put("c",row);//셀 추가
			body.add(cell);//row 
		}
		data.put("rows",body);
		return data;
		
	}

	@Override
	public JSONObject getOrdersMoney(String option,int number) {
		List<OrdersDTO> list = ordersService.ordersMoney(option,number);
		logger.info("ordersMoney list = " + list.toString());
		
		JSONObject data = new JSONObject();
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		JSONArray title = new JSONArray();
		col1.put("label","상품명");//key,value
		col1.put("type","string");
		col2.put("label","money");//컬럼 이름
		col2.put("type","number");//컬럼 자료형
		title.add(col1);
		title.add(col2);
		data.put("cols",title);//컬럼 객체 추가
		
		JSONArray body = new JSONArray();//실제 데이터
		for(OrdersDTO dto : list){
			JSONObject name = new JSONObject();
			name.put("v",dto.getProduct_name());
			JSONObject money = new JSONObject();
			money.put("v",dto.getMoney());
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(money);
			JSONObject cell = new JSONObject();
			cell.put("c",row);//셀 추가
			body.add(cell);//row 
		}
		data.put("rows",body);
		return data;
	}
	
	

}
