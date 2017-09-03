package com.javalec.tea_pjt.service.member;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.javalec.tea_pjt.model.member.dto.MemberDTO;

public interface MemberService {
	
	public int signup(MemberDTO member, HttpServletRequest request) throws ParseException;
	public MemberDTO login(String user_id, String password);
	public int searchId(String user_id);
	public MemberDTO userInfo(String user_id);
	public int updateUser(MemberDTO member);
	public int deleteUser(String user_id, String password);
	public void logout(HttpSession session);
	//email로 비밀번호 찾기
	public String searchPasswordFromEmail(MemberDTO member);
	
	//비밀번호 확인
	public String searchPassword(String user_id);
}
