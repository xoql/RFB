package com.javalec.tea_pjt.model.coupon.dto;

import java.util.Date;

public class CouponDTO {
	private String user_id;
	private String cName;
	private String cSale;
	private String cEx;
	private Date cDate;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcSale() {
		return cSale;
	}
	public void setcSale(String cSale) {
		this.cSale = cSale;
	}
	public String getcEx() {
		return cEx;
	}
	public void setcEx(String cEx) {
		this.cEx = cEx;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
}
