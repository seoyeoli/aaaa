package com.my.company.program.controller;

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
import com.my.company.program.service.programService;
import com.my.company.program.vo.programVO;

@Controller
public class programCtrl {

	
	@Resource(name = "programservice")
	programService programservice;
	
	private static final Logger logger = LoggerFactory.getLogger(programCtrl.class);
	
	@RequestMapping("/program/programList.do")
	public ModelAndView progList(HttpServletRequest request, HttpServletResponse response) {
//		String user_id = request.getParameter("user_id"); 
		
		programVO programvo = new programVO(); 
		List<Map<String, Object>> progList = programservice.programList(programvo);
		
		ModelAndView mv = new ModelAndView("/program/programList");
		mv.addObject("progList", progList);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/program/registProgList.do",produces="application/json;charset=utf8")
	public String registProgList(@RequestBody Map<String, Object> param){
		String user_id = (String)param.get("user_id");
		
		List<Map<String, Object>> progList = programservice.registProgList(user_id);
		logger.debug(progList.toString());
		return new Gson().toJson(progList);
	}
}
