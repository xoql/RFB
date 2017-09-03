package com.javalec.tea_pjt.controller.admin;




import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.tea_pjt.model.member.dto.MemberDTO;
import com.javalec.tea_pjt.service.admin.AdminService;


@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Inject
	AdminService adminService;
	
	@RequestMapping("adminPage.do")
	public String adminPage(){
		return "admin/adminPage";
	}
	
	@RequestMapping("selectUser.do")
	public ModelAndView userAll(ModelAndView mav,@RequestParam(defaultValue="user") String option){
		mav.addObject("selectUser",adminService.selectUser(option));
		mav.setViewName("admin/selectUser");
		return mav;
	}
	
/*	@RequestMapping("modifyUser.do")
	public ResponseEntity<String> modifyUser(MemberDTO dto){
		
		ResponseEntity<String> entity = null;
		int result = -1;
		
		result = adminService.modifyUser(dto);
		
		System.out.println("~~~~~~~~~~~~~~~result 값 : " + result);
		if(result >=1 ){
			entity = new ResponseEntity<String>("success", HttpStatus.OK);		
		}else{
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);		
		}
		
		return entity;
	}*/
	
	@RequestMapping("modifyUser.do")
	public String modifyUser(MemberDTO dto){
		adminService.modifyUser(dto);
		return "redirect:selectUser.do";
	}

	
}
