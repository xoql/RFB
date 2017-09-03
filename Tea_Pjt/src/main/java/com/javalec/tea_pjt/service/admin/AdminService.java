package com.javalec.tea_pjt.service.admin;

import java.util.List;

import com.javalec.tea_pjt.model.member.dto.MemberDTO;

public interface AdminService {
	
	public List<MemberDTO> selectUser(String option);
	public int modifyUser(MemberDTO dto);

}
