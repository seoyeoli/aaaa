package com.my.company.schedule.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.my.company.schedule.service.scheduleService;
import com.my.company.schedule.vo.scheduleVO;

@Controller
public class scheduleCtrl {
	
	@Resource(name = "scheduleservice")
	scheduleService scheduleservice;
	
	private static final Logger logger = LoggerFactory.getLogger(scheduleCtrl.class);
	
	@RequestMapping("/schedule/scheduleList.do")
	public ModelAndView scheduleList(HttpServletRequest request, HttpServletResponse response) {
		
		String user_id = request.getParameter("user_id") == null ? request.getParameter("uservo.user_id") : request.getParameter("user_id");
		logger.debug("\t user_id >>>>> "+user_id);
		
		//오늘 날짜의 스케줄을 가져오기 위해 날짜..세팅..
//		Date date = new Date();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
//		String sch_day = dateFormat.format(date);
		
		String sch_day = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		logger.debug("\t sch_day >>>>> "+sch_day);
		
		scheduleVO schvo = new scheduleVO();
		schvo.setUser_id(user_id);
		schvo.setSch_day(sch_day);
		
		List<Map<String, Object>> scheduleList = scheduleservice.scheduleList(schvo);
		
		logger.debug("schedulelist임.."+scheduleList.toString());
		
		ModelAndView mv = new ModelAndView("/schedule/scheduleList");
		String jsonData = new Gson().toJson(scheduleList);
		
		mv.addObject("scheduleList", scheduleList);
		mv.addObject("jsonData", jsonData);
		
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/schedule/daySchedule.do",produces="application/json;charset=utf8")
	public String daySchedule(@RequestBody Map<String, Object> param){
		
		String user_id = (String)param.get("user_id");
		String sch_day= (String)param.get("sch_day");
		
		logger.debug("\t daySchedule.do ==>> user_id ==>>>>"+user_id+"\n \t sch_day===>"+sch_day);
		
		scheduleVO schvo = new scheduleVO();
		schvo.setUser_id(user_id);
		schvo.setSch_day(sch_day);
		
		List<Map<String, Object>> list = scheduleservice.scheduleList(schvo);
		//List<HashMap<String, Object>> list = scheduleservice.daySchedule(user_id);
		logger.debug("\t list ==>>>"+list.toString());
		
		return new Gson().toJson(list);
	}
	
	
}
