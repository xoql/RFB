package com.javalec.tea_pjt.model.member.dto;

import java.util.Date;

public class MemberDTO {  
		private String user_id;
		private String password;
		private String user_name;
		private String birth;
		private String gender;
		private int tel1, tel2, tel3;
		private String email1, email2;
		private String address1, address2, address3;
		private int user_level;//0:일반회원 / 1:매니저 / 2:관리자
		private Date user_join_date;//아이디 생성 날짜
		private String user_flag;//탈퇴 여부('Y'/'N')
		
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUser_name() {
			return user_name;
		}
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		public String getBirth() {
			return birth;
		}
		public void setBirth(String birth) {
			this.birth = birth;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getTel1() {
			return tel1;
		}
		public void setTel1(int tel1) {
			this.tel1 = tel1;
		}
		public int getTel2() {
			return tel2;
		}
		public void setTel2(int tel2) {
			this.tel2 = tel2;
		}
		public int getTel3() {
			return tel3;
		}
		public void setTel3(int tel3) {
			this.tel3 = tel3;
		}
		public String getEmail1() {
			return email1;
		}
		public void setEmail1(String email1) {
			this.email1 = email1;
		}
		public String getEmail2() {
			return email2;
		}
		public void setEmail2(String email2) {
			this.email2 = email2;
		}
		public String getAddress1() {
			return address1;
		}
		public void setAddress1(String address1) {
			this.address1 = address1;
		}
		public String getAddress2() {
			return address2;
		}
		public void setAddress2(String address2) {
			this.address2 = address2;
		}
		public String getAddress3() {
			return address3;
		}
		public void setAddress3(String address3) {
			this.address3 = address3;
		}
		public int getUser_level() {
			return user_level;
		}
		public void setUser_level(int user_level) {
			this.user_level = user_level;
		}
		public Date getUser_join_date() {
			return user_join_date;
		}
		public void setUser_join_date(Date user_join_date) {
			this.user_join_date = user_join_date;
		}
		public String getUser_flag() {
			return user_flag;
		}
		public void setUser_flag(String user_flag) {
			this.user_flag = user_flag;
		}
}
