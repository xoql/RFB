package com.javalec.tea_pjt.service.admin;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.javalec.tea_pjt.model.member.dao.MemberDAO;
import com.javalec.tea_pjt.model.member.dto.MemberDTO;
import com.javalec.tea_pjt.service.chart.GoogleChartService;

@Repository
public class AdminServiceImpl implements AdminService{
	
	@Inject
	MemberDAO memberDAO;
	
	@Override
	public List<MemberDTO> selectUser(String option) {
		return memberDAO.selectUser(option);
	}

	@Override
	public int modifyUser(MemberDTO dto) {
		return memberDAO.modifyUser(dto);
	}
	
	

}
