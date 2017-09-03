package com.javalec.tea_pjt.service.attendance;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.javalec.tea_pjt.model.attendance.dao.AttendanceDAO;
import com.javalec.tea_pjt.model.attendance.dto.AttendanceDTO;

@Service
public class AttendanceServiceImpl implements AttendanceService{
	
	@Inject
	AttendanceDAO aDao;

	@Override
	public int attendance(String user_id) {
		return aDao.attendance(user_id);
	}

	@Override
	public AttendanceDTO monthAttendance(String user_id, String atYear, String atMonth) {
		return aDao.monthAttendance(user_id, atYear, atMonth);
	}

	@Override
	public int atCount(String user_id, String atYear, String atMonth) {
		return aDao.atCount(user_id, atYear, atMonth);
	}

	@Override
	public int userCount(String user_id) {
		return aDao.userCount(user_id);
	}

	@Override
	public int allCount() {
		return aDao.allCount();
	}

	@Override
	public ArrayList<AttendanceDTO> userAllAttendance(String user_id) {
		return aDao.userAllAttendance(user_id);
	}

	@Override
	public AttendanceDTO dateMonth(String user_id, String atYear, String atMonth, String atDate) {
		return aDao.dateMonth(user_id, atYear, atMonth, atDate);
	}

	@Override
	public int atChk(String user_id, String atYear, String atMonth, String atDate) {
		return aDao.atChk(user_id, atYear, atMonth, atDate);
	}
}
