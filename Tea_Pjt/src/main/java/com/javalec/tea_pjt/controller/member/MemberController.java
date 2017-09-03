package com.javalec.tea_pjt.controller.member;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.tea_pjt.model.coupon.dto.CouponDTO;
import com.javalec.tea_pjt.model.member.dto.MemberDTO;
import com.javalec.tea_pjt.service.coupon.CouponService;
import com.javalec.tea_pjt.service.member.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
		
	private static final Logger logger
	=LoggerFactory.getLogger(MemberController.class);
		
	@Inject
	MemberService mService; //new생성안하고 spring에서 관리해주기 때문에 바로 사용 가능
							//싱글톤(하나의 객체를 만들어 계속 사용)
	@Inject
	CouponService cService;
	
	@RequestMapping(value="signup.do",method=RequestMethod.GET)
	public String signup(){//회원가입페이지 이동
		return "/member/signalToDE";
	}
	
	@RequestMapping(value="signup.do" ,method=RequestMethod.POST)
	public String signup(MemberDTO member , Model model, HttpServletRequest request) throws ParseException{
		int result = mService.signup(member, request);
		if(result >= 1){
			model.addAttribute("msg","회원가입이 완료. 로그인하세요");
			return "/member/login";
		}else{
			model.addAttribute("msg","회원가입 실패.");
			return "/home";
		}
	}
	
	@RequestMapping("searchId.do")
	public ResponseEntity<String> searchId(String user_id) {
		
		ResponseEntity<String> entity = null;
		
		int result = mService.searchId(user_id);
		if(result>=1) {
			entity = new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST.OK);
		}else {
			entity = new ResponseEntity<String>("success",HttpStatus.BAD_REQUEST.OK);
		}
		return entity;
	}
	
	
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String login(){//로그인페이지 이동
		return "/member/login";
	}
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public ModelAndView login(String user_id, String password, HttpSession session, ModelAndView mav){
		
		MemberDTO dto = mService.login(user_id, password);
		
		if(dto==null){
			mav.addObject("msg", "아이디가 없거나 패스워드가 일치 하지않습니다.");
		}else{
			session.setAttribute("user",dto);
			mav.setViewName("/home");
		}
		
		return mav;
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		mService.logout(session);
		return "/home";
	}
	
	@RequestMapping(value="updateUser.do", method=RequestMethod.GET)
	public String updateUser(){//회원 정보 수정 페이지 이동
		return "/member/updateUser";
	}
	
	@RequestMapping("updateGo.do")
	public String updateGo() {
		return "/member/updateGo";
	}
	
	@RequestMapping("updateGoResult.do")
	public String updateGoResult(HttpServletRequest request, HttpSession session) {
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		String password = dto.getPassword();
		String inputPassword = request.getParameter("inputPassword");
		if(password.equals(inputPassword)) {
			return "/member/updateUser";
		}else {
			return "/member/updateGo";
		}
	}
	
	@RequestMapping(value="updateUser.do", method=RequestMethod.POST)
	public String updateUser(MemberDTO member, HttpServletRequest session){
		int result = mService.updateUser(member);
		if(result >= 1){//회원 정보 수정 성공
			return "/home";
		}else{
			return "/member/updateUser";
		}
	}
	
	@RequestMapping("deleteGo.do")
	public String deleteGo() {
		return "/member/deleteGo";
	}
	
	@RequestMapping("deleteUser.do")
	public ModelAndView deleteUser(HttpSession session, String inputPassword, ModelAndView mav){
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		int result = mService.deleteUser(dto.getUser_id(), inputPassword);
		if(result >= 1){//회원 삭제 성공
			System.out.println("삭제 성공;");
			mav.addObject("msg", "회원 삭제 성공");
			mav.setViewName("/member/login");
		}else{
			System.out.println("삭제 실패;;");
			mav.addObject("msg", "회원 삭제 실패");
			mav.setViewName("/home");
		}
		return mav;
	}
	
	@RequestMapping(value="userInfo.do", method=RequestMethod.GET)
	public String userInfo(HttpSession session){
		return "/member/userInfo";
	}
	
	@RequestMapping("searchPassword.do")
	public String searchPassword(HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		String inputPassword = request.getParameter("updateChk");
		System.out.println("user_id: "+user_id);
		System.out.println("updateChk: "+inputPassword);
		String rPassword = mService.searchPassword(user_id);
		if(inputPassword == rPassword) {
			return "/member/updateUser";
		}else {
			return "/member/userInfo";
		}
	}
	
	@RequestMapping("couponGo.do")
	public String couponGo(HttpSession session, Model model) {
		MemberDTO mDto = (MemberDTO) session.getAttribute("user");
		String user_id = mDto.getUser_id();
		if(user_id==null) {
			return "/member/login";
		}else {
			System.out.println("유저아이디확인: "+user_id);
			int cCount = cService.cCount(user_id);
			System.out.println("cCount확인: "+cCount);
			session.setAttribute("cCount", cCount);//tr의 개수를 위한 cCount
			ArrayList<CouponDTO> cDto = cService.cGet(user_id);
			System.out.println("cDto리스트 확인: "+cDto.size());
			System.out.println("cDto리스트 확인: "+cDto.get(0).getcName());
			session.setAttribute("cDto", cDto);

			return "/member/coupon";
		}
	}
}
