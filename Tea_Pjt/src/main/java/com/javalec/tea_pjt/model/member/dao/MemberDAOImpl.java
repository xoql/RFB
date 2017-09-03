package com.javalec.tea_pjt.model.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javalec.tea_pjt.model.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	SqlSession sqlSession;//DB접속처리

	@Override
	public int signup(MemberDTO member) {
		return sqlSession.insert("member.insert", member);
	}

	@Override
	public MemberDTO login(String user_id, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("password", password);
		return sqlSession.selectOne("member.login", map);
		
	}

	@Override
	public int searchId(String user_id) {
		return sqlSession.selectOne("member.searchId", user_id);
	}

	@Override
	public MemberDTO userInfo(String user_id) {
		return (MemberDTO) sqlSession.selectList("member.userInfo", user_id);
	}
	
	@Override
	public int updateUser(MemberDTO member) {
		return sqlSession.update("member.updateUser", member);
	}

	@Override
	public int deleteUser(String user_id, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("password", password);
		return sqlSession.update("member.deleteUser", map);
	}

	@Override
	public String searchPasswordFromEmail(MemberDTO member) {
		return sqlSession.selectOne("member.searchPasswordFromEmail", member);
	}

	@Override
	public String searchPassword(String user_id) {
		return sqlSession.selectOne("member.searchPassword", user_id);
	}

	@Override
	public List<MemberDTO> selectUser(String option) {
		Map<String,String> map = new HashMap<>();
		map.put("option",option);
		return sqlSession.selectList("member.selectUser",map);
	}

	@Override
	public int modifyUser(MemberDTO dto) {
		return sqlSession.update("member.modifyUser",dto);
	}

	

}
