package com.javalec.tea_pjt.model.coupon.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javalec.tea_pjt.model.coupon.dto.CouponDTO;

@Repository
public class CouponDAOImpl implements CouponDAO{
	@Inject
	SqlSession sqlSession;//DB접속처리

	@Override
	public int cInsert(String user_id, String cName, String cSale, String cEx) {
		Map<String, String> map = new HashMap<>();
		map.put("user_id",  user_id);
		map.put("cName", cName);
		map.put("cSale", cSale);
		map.put("cEx", cEx);
		return sqlSession.insert("member.cInsert", map);
	}

	@Override
	public int cCount(String user_id) {
		Map<String, String> map = new HashMap<>();
		map.put("user_id", user_id);
		return sqlSession.selectOne("member.cCount", map);
	}

	@Override
	public ArrayList<CouponDTO> cGet(String user_id) {
		return (ArrayList)sqlSession.selectList("member.cGet", user_id);
	}
	
}
