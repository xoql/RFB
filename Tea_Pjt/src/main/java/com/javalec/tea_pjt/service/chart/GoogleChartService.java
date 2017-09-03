package com.javalec.tea_pjt.service.chart;

import org.json.simple.JSONObject;

public interface GoogleChartService {
	
	public JSONObject getChartData();
	public JSONObject getOrdersCount(String option,int number);
	public JSONObject getOrdersMoney(String option,int number);

}
