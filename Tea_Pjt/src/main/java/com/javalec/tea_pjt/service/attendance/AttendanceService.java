package com.javalec.tea_pjt.service.attendance;

import java.util.ArrayList;

import com.javalec.tea_pjt.model.attendance.dto.AttendanceDTO;

public interface AttendanceService {
	//출석클릭 시
		public int attendance(String user_id);
		
		//한달 이내의 출석 일
		public AttendanceDTO monthAttendance(String user_id, String atYear, String atMonth);
		
		//한달 이내 출석 수
		public int atCount(String user_id, String atYear, String atMonth);
		
		//유저의 총 출석 수
		public int userCount(String user_id);
		
		//전체 유저들의 총 출석 수
		public int allCount();
		
		//한 유저의 모든 출석정보
		public ArrayList<AttendanceDTO> userAllAttendance(String user_id);
		
		//해당 월(입력받아야 함)에서 이 날(atDate)에 출석 했는지
		public AttendanceDTO dateMonth(String user_id, String atYear, String atMonth, String atDate);
		
		//해당 월, 일에 출석 했는지 체크
		public int atChk(String user_id, String atYear, String atMonth, String atDate);
}
