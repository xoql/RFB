package com.javalec.tea_pjt.model.coupon.dao;

import java.util.ArrayList;

import com.javalec.tea_pjt.model.coupon.dto.CouponDTO;

public interface CouponDAO {
	//쿠폰 생성
	public int cInsert(String user_id, String cName, String cSale, String cEx);
	
	//쿠폰 개수 확인
	public int cCount(String user_id);
	
	//쿠폰 내용 가져오기
	public ArrayList<CouponDTO> cGet(String user_id);
}
