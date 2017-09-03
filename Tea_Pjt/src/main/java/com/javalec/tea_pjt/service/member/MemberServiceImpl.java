package com.javalec.tea_pjt.service.member;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.javalec.tea_pjt.model.member.dao.MemberDAO;
import com.javalec.tea_pjt.model.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	MemberDAO mDao;

	@Override
	public int signup(MemberDTO member, HttpServletRequest request) throws ParseException {
			String birthY = request.getParameter("birthY");
			String birthM;
			String birthm = request.getParameter("birthM");
			String birthD;
			String birthd = request.getParameter("birthD");
			if(Integer.parseInt(birthm)<10) {
				birthM = "0"+birthm;
			}else {
				birthM = birthm;
			}
			if(Integer.parseInt(birthd)<10) {
				birthD = "0"+birthd;
			}else {
				birthD = birthd;
			}
		String birth = birthY+birthM+birthD;
		member.setBirth(birth);
		return mDao.signup(member);
	}

	@Override
	public MemberDTO login(String user_id, String password) {
		
		return mDao.login(user_id, password);
	}

	@Override
	public int searchId(String user_id) {
		return mDao.searchId(user_id);
	}

	@Override
	public MemberDTO userInfo(String user_id) {
		return mDao.userInfo(user_id);
	}
	
	@Override
	public int updateUser(MemberDTO member) {
		return mDao.updateUser(member);
	}

	@Override
	public int deleteUser(String user_id, String password) {
		return mDao.deleteUser(user_id, password);
	}

	@Override
	public String searchPasswordFromEmail(MemberDTO member) {
		return mDao.searchPasswordFromEmail(member);
	}

	@Override
	public String searchPassword(String user_id) {
		return mDao.searchPassword(user_id);
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	
}
