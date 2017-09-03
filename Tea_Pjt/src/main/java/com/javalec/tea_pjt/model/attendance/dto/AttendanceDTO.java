package com.javalec.tea_pjt.model.attendance.dto;

import java.util.Date;

public class AttendanceDTO {
	private String user_id;
	private Date atSysdate;
	private String atYear;
	private String atMonth;
	private String atDate;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getAtSysdate() {
		return atSysdate;
	}
	public void setAtSysdate(Date atSysdate) {
		this.atSysdate = atSysdate;
	}
	public String getAtYear() {
		return atYear;
	}
	public void setAtYear(String atYear) {
		this.atYear = atYear;
	}
	public String getAtMonth() {
		return atMonth;
	}
	public void setAtMonth(String atMonth) {
		this.atMonth = atMonth;
	}
	public String getAtDate() {
		return atDate;
	}
	public void setAtDate(String atDate) {
		this.atDate = atDate;
	}
}
