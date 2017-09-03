package com.javalec.tea_pjt.controller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.tea_pjt.controller.member.MemberController;
import com.javalec.tea_pjt.model.member.dto.MemberDTO;
import com.javalec.tea_pjt.model.shop.dto.CartDTO;
import com.javalec.tea_pjt.service.shop.CartService;

@Controller
@RequestMapping("/shop/cart/*")
public class CartController {
	
	private static final Logger logger
	=LoggerFactory.getLogger(CartController.class);
	
	@Inject
	CartService cartService;
	
	@RequestMapping("insert.do")
	public ResponseEntity<String> insert(@ModelAttribute CartDTO dto,HttpSession session){
		MemberDTO mdto = (MemberDTO) session.getAttribute("user");
		ResponseEntity<String> entity = null;
/*		if(mdto ==null){
			return "redirect:/member/login.do";
		}
*/		String userid=mdto.getUser_id();
		dto.setUserid(userid);
		cartService.insert(dto);
		entity = new ResponseEntity<String>("success",HttpStatus.OK);
		return entity;
/*		return "redirect:/shop/product/detail/"+dto.getProduct_id();
*/	}
	
	@RequestMapping("list.do")
	public ModelAndView list(HttpSession session,ModelAndView mav){
		Map<String,Object> map = new HashMap<>();
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		String userid=dto.getUser_id();

		
		if(userid !=null){
		List<CartDTO> list = cartService.listCart(userid);
		int sumMoney = cartService.sumMoney(userid);
		
		int free =sumMoney>=30000?0:2500;
		map.put("sumMoney",sumMoney);
		map.put("free",free);
		map.put("sum",sumMoney+free);
		map.put("list",list);
		map.put("count",list.size());
		mav.setViewName("shop/cart_list");
		mav.addObject("map",map);
		return mav;
		}else 
			return new ModelAndView("member/login","",null);
		
	}
	
	@RequestMapping("delete.do")
	public String delete(int cart_id){
		cartService.delete(cart_id);
		return "redirect:/shop/cart/list.do";
	}
	
	@RequestMapping("deleteAll.do")
	public String deleteAll(HttpSession session){
		
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		String userid=dto.getUser_id();
		cartService.deleteAll(userid);
		return "redirect:/shop/cart/list.do";
	}
	
	@RequestMapping("update.do")
	public String update(int[] amount,int[] product_id,HttpSession session){
		
		MemberDTO mdto = (MemberDTO) session.getAttribute("user");
		String userid=mdto.getUser_id();
		for(int i=0; i<product_id.length; i++){
			CartDTO dto = new CartDTO();
			dto.setUserid(userid);
			dto.setProduct_id(product_id[i]);
			dto.setAmount(amount[i]);
			cartService.modifyCart(dto);
		}
		
		return "redirect:/shop/cart/list.do";
	}
	
}
