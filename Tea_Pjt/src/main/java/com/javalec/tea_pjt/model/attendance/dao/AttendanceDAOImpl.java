package com.javalec.tea_pjt.model.attendance.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javalec.tea_pjt.model.attendance.dto.AttendanceDTO;

@Repository
public class AttendanceDAOImpl implements AttendanceDAO{
	
	@Inject
	SqlSession sqlSession;//DB접속처리

	@Override
	public int attendance(String user_id) {
		return sqlSession.insert("attendance.insert", user_id);
	}

	@Override
	public AttendanceDTO monthAttendance(String user_id, String atYear, String atMonth) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("user_id", user_id);
		m.put("atYear", atYear);
		m.put("atMonth", atMonth);
		return sqlSession.selectOne("attendance.monthAttendance", m);
	}
	
	@Override
	public int atCount(String user_id, String atYear, String atMonth) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("user_id", user_id);
		m.put("atYear", atYear);
		m.put("atMonth", atMonth);
		return sqlSession.selectOne("attendance.monthCount", m);
	}

	@Override
	public int userCount(String user_id) {
		return sqlSession.selectOne("attendance.userCount", user_id);
	}

	@Override
	public int allCount() {
		return sqlSession.selectOne("attendance.allCount");
	}

	@Override
	public ArrayList<AttendanceDTO> userAllAttendance(String user_id) {
		return (ArrayList) sqlSession.selectList("attendance.userAllAttendance", user_id);
	}

	@Override
	public AttendanceDTO dateMonth(String user_id, String atYear, String atMonth, String atDate) {
		Map<String, String> m = new HashMap<>();
		m.put("user_id", user_id);
		m.put("atYear", atYear);
		m.put("atMonth", atMonth);
		m.put("atDate", atDate);
		return sqlSession.selectOne("attendance.dateMonth", m);
	}

	@Override
	public int atChk(String user_id, String atYear, String atMonth, String atDate) {
		Map<String, String> m = new HashMap<>();
		m.put("user_id", user_id);
		m.put("atYear", atYear);
		m.put("atMonth", atMonth);
		m.put("atDate", atDate);
		return sqlSession.selectOne("attendance.atChk", m);
	}
	
}
