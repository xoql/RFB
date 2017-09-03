package com.javalec.tea_pjt.model.member.dao;

import java.util.List;

import com.javalec.tea_pjt.model.member.dto.MemberDTO;

public interface MemberDAO {
	
	public int signup(MemberDTO member);
	public MemberDTO login(String user_id, String password);
	public int searchId(String user_id);
	public MemberDTO userInfo(String user_id);
	public int updateUser(MemberDTO member);
	public int deleteUser(String user_id, String password);
	
	//email로 비밀번호 찾기
	public String searchPasswordFromEmail(MemberDTO member);
	
	//비밀번호 확인
	public String searchPassword(String user_id);
	
	//관리자
	public List<MemberDTO> selectUser(String option);
	public int modifyUser(MemberDTO dto);
}
