package com.javalec.tea_pjt.controller.menu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.tea_pjt.controller.member.MemberController;
import com.javalec.tea_pjt.model.attendance.dto.AttendanceDTO;
import com.javalec.tea_pjt.model.member.dto.MemberDTO;
import com.javalec.tea_pjt.service.attendance.AttendanceService;
import com.javalec.tea_pjt.service.coupon.CouponService;
import com.javalec.tea_pjt.service.member.MemberService;

@Controller
@RequestMapping("/menu/*")
public class MenuController {

	private static final Logger logger
	=LoggerFactory.getLogger(MenuController.class);
	
	@Inject
	AttendanceService aService;
	@Inject
	MemberService mService;
	@Inject
	CouponService cService;
	
	@RequestMapping("introduceGongcha.do")
	public String IntroduceGongcha() {
		return "/menu/introduceGongcha";
	}
	
	@RequestMapping("attendanceGo.do")
	public String AttendanceGo(HttpSession session, Model model) {
		MemberDTO mDto = (MemberDTO) session.getAttribute("user");
		String user_id = mDto.getUser_id();
		if(user_id==null) {
			return "/member/login";
		}else {
			ArrayList<AttendanceDTO> uaa = aService.userAllAttendance(user_id);
			Calendar cal = Calendar.getInstance();
			int intMonth = cal.get(Calendar.MONTH)+1;
			String month = null;
			ArrayList<String> dateList = new ArrayList<>();
			if(intMonth<10) {//10미만인 월에 0붙이기(db값과 비교를 위해)
				month = "0"+String.valueOf(intMonth);
			}else {
				month = String.valueOf(intMonth);
			}
			for(int i=0; i<uaa.size(); i++) {
				if(String.valueOf(uaa.get(i).getAtMonth()).equals(month)) {//월 비교
					String getDate = uaa.get(i).getAtDate();
					System.out.println("getDate확인: "+getDate);
					dateList.add(getDate);
				}
			}
			String msg = (String) session.getAttribute("msg");
			model.addAttribute("msg", msg);
			System.out.println("dateList확인: "+dateList);
			model.addAttribute("dateList", dateList);
			return "/menu/attendance";
		}
	}
	
	@RequestMapping("attendance.do")
	public String attendance(HttpServletRequest request, HttpSession session, Model model) {
		String atYear = (String) session.getAttribute("mYear");
		String atMonth = (String) session.getAttribute("mMonth");
		String atDate = (String) session.getAttribute("mDate");
		System.out.println("출석11"+atYear+", "+atMonth+", "+atDate);//값 받아와 짐
		MemberDTO mDto = (MemberDTO) session.getAttribute("user");
		String user_id = mDto.getUser_id();
		int atChk = aService.atChk(user_id, atYear, atMonth, atDate);
		System.out.println("출석33: "+atChk);
		if(atChk>=1) {
			//이미 같은 날짜에 있을 때(년, 월, 일로 구분)
			//session.setAttribute("msg", "오늘은 이미 출석하셨습니다!");
			//model.addAttribute("msg", "오늘은 이미 출석하셨습니다!");
			System.out.println("이미 같은 날짜가 있음");
			return "redirect:/menu/attendanceGo.do";
		}else {
			int reAt = aService.attendance(user_id);
			if(reAt>=1) {
				model.addAttribute("msg","출석 추가 성공");
				System.out.println("출석 추가 성공");//성공됨
				
				int monthCount = aService.atCount(user_id, atYear, atMonth);
				if(monthCount==1) {
					model.addAttribute("msg", "축하합니다! 1회 이상 출석 쿠폰을 발급받으셨습니다! 쿠폰함을 확인해주세요!");
					String cName = "1회이상 출석 쿠폰";
					String cSale = "1000";
					String cEx = "월 1회출석으로 발급한 쿠폰입니다.";
					int insertCoupon = cService.cInsert(user_id, cName, cSale, cEx);
					System.out.println("쿠폰발급확인:"+insertCoupon);
				}else {}
				if(monthCount==3) {
					model.addAttribute("msg", "축하합니다! 3회 이상 출석 쿠폰을 발급받으셨습니다! 쿠폰함을 확인해주세요!");
					String cName = "3회이상 출석 쿠폰";
					String cSale = "3000";
					String cEx = "월 3회출석으로 발급한 쿠폰입니다.";
					int insertCoupon = cService.cInsert(user_id, cName, cSale, cEx);
				}
				//return "redirect:/menu/attendanceGo.do";
			}else {
				session.setAttribute("msg", "출석 추가 실페");
				model.addAttribute("msg","출석 추가 실패");
				System.out.println("출석 추가 실패");
				return "redirect:/menu/attendanceGo.do";
			}
		}
		return "/menu/attendance";
	}
	
	
	/*@RequestMapping("attendance.do")
	public ModelAndView Attendance(ModelAndView mav, HttpSession session){
		MemberDTO mDto = (MemberDTO) session.getAttribute("user");
		String user_id = mDto.getUser_id();
		System.out.println("유저아이디 확인: "+user_id);//OK
		int result = aService.attendance(user_id);//DB에 출석 추가
		System.out.println("디비에 출석 추가: "+result);
		//mav.setViewName("/menu/event/attendance");
		if(result>=1) {//DB에 출석 추가 성공하면
			System.out.println("엥 여기 안돼?");
			AttendanceDTO aDto = aService.userAllAttendance(user_id);
			String atYear = aDto.getAtYear();
			String atMonth = aDto.getAtMonth();
			System.out.println("호호잇 atYear: "+atYear+", atMonth: "+atMonth);
			aDto= aService.monthAttendance(user_id, atYear, atMonth);
			int atCount = aService.atCount(user_id, );
			if(atCount>=1) {
				mav.addObject("msg", "축하합니다! 이번달 쿠폰을 발급받으셨습니다.");
				//mav.setViewName("/menu/event/attendance");
			}	
			int userCount = aService.userCount(user_id);
			if(userCount>=3) {
				mav.addObject("msg", "축하합니다! 회원님의 누적 출석 3회 기념 쿠폰 발급해드립니다.");
				//mav.setViewName("/menu/event/attendance");
			}
			int allCount = aService.allCount();
			if(allCount>=4) {
				mav.addObject("msg", "축하합니다! 전체 회원 누적 출석 4번째 주인공이 되었습니다.");
				//mav.setViewName("/menu/event/attendance");
			}
		}
		return mav;
	}*/
}
