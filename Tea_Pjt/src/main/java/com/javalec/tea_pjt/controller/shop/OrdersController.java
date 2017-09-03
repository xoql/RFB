package com.javalec.tea_pjt.controller.shop;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.tea_pjt.model.member.dto.MemberDTO;
import com.javalec.tea_pjt.model.shop.dto.CartDTO;
import com.javalec.tea_pjt.model.shop.dto.OrdersDTO;
import com.javalec.tea_pjt.service.shop.CartService;
import com.javalec.tea_pjt.service.shop.OrdersService;

@Controller
@RequestMapping("/shop/order/")
public class OrdersController {
	
	private static final Logger logger
	=LoggerFactory.getLogger(OrdersController.class);
	
	@Inject
	OrdersService orderService;
	
	@Inject
	CartService cartService;
	
	@RequestMapping("order_page.do")
	public String orderPage(){
		
		return "shop/order_page";
	}

	@RequestMapping(value="order_history.do",method=RequestMethod.GET)
	public String orderedpage(HttpSession session,Model model){
		
		MemberDTO udto = (MemberDTO) session.getAttribute("user");
		String userid = udto.getUser_id();
		
		model.addAttribute("dto",orderService.order_history(userid));
		return "shop/order_history";
	}
	
	@RequestMapping("order_cart.do")
	@Transactional
	public ModelAndView order_cart(HttpSession session,ModelAndView mav){
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		String userid=dto.getUser_id();

		if(userid !=null){
		List<CartDTO> list = cartService.listCart(userid);
		int sumMoney = cartService.sumMoney(userid);
		int free =sumMoney>=30000?0:2500;
		
		int rownum=orderService.selectRownum();
		int sum=0;
		OrdersDTO dto2 = null;
		
	
		for(int i=0; i<list.size(); i++){
			int price = list.get(i).getPrice();
			dto2 = new OrdersDTO();
			dto2.setProduct_id(list.get(i).getProduct_id());
			dto2.setOrder_id(rownum);
			dto2.setAmount(list.get(i).getAmount());
			dto2.setOrder_total(price*list.get(i).getAmount());
			orderService.insert_order(dto2);
			sum+=price*list.get(i).getAmount();
		}
		dto2.setUserid(userid);
		dto2.setOrdered_total(sum+free);
		dto2.setFree(free);
		orderService.insert_orders_detail(dto2);
		cartService.deleteAll(userid);
		mav.setViewName("home");
		return mav;
		}else 
			return new ModelAndView("member/login","",null);		
	}



}
