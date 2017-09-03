package com.javalec.tea_pjt.controller.chart;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.tea_pjt.service.chart.GoogleChartService;

@RestController
@RequestMapping("/chart/*")
public class GoogleChartController {
	
	@Inject
	GoogleChartService googleChartService;
	
	@RequestMapping("chart1.do")
	public ModelAndView chart1(){
				
		return new ModelAndView("chart/chart01");
	}
	
	@RequestMapping("chart2.do")
	public ModelAndView chart2(){
		return new ModelAndView("chart/chart02");
	}
	
	@RequestMapping("chart_money_list.do")
	public JSONObject chart_money_list(){
		
		return googleChartService.getChartData();
	}
	
	@RequestMapping("chart3.do")
	public ModelAndView chart3(){
		return new ModelAndView("chart/chart03");
	}
	
	@RequestMapping("chart_orders_count.do")
	public JSONObject chart_orders_count(@RequestParam(defaultValue="up") String option,@RequestParam(defaultValue="5") int number){
		
		return googleChartService.getOrdersCount(option,number);
	}
	
	@RequestMapping("chart_orders_money.do")
	public JSONObject chart_orders_money(@RequestParam(defaultValue="up") String option,@RequestParam(defaultValue="5") int number){
		return googleChartService.getOrdersMoney(option,number);
	}

}
