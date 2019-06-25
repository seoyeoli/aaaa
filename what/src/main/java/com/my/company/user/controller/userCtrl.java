package com.my.company.user.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.company.common.service.commonService;
import com.my.company.common.util.SHA256Password;
import com.my.company.schedule.service.scheduleService;
import com.my.company.schedule.vo.scheduleVO;
import com.my.company.user.service.userService;
import com.my.company.user.vo.userVO;

@Controller
public class userCtrl {
	
	private static final Logger logger = LoggerFactory.getLogger(userCtrl.class);
	
	@Resource(name="userservice")
	private userService userservice;
	
	@Resource(name="commonservice")
	private commonService commonservice;
	
	@Resource(name = "scheduleservice")
	scheduleService scheduleservice;
	
	
	@RequestMapping("/user/signin.do")
	public ModelAndView signin(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("/user/signin");
		return mv;
	}
	
	
	@RequestMapping("/user/loginPage.do")
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/user/loginPage");
		String url = request.getParameter("url") == null ? "/common/main.do" : request.getParameter("url");
		mv.addObject("url", url);
		return mv;
	}
	
	@RequestMapping("/user/login.do")
	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession(true);
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String loc = request.getParameter("loc");
		String url = request.getParameter("url");
		logger.debug("\t url ==> "+url);
		
		logger.debug("\n\n입력값\n"+user_id+"\n"+user_pw+"\n\n");
		SHA256Password ecd= new SHA256Password(); 
		String ecdpw = ecd.LockPassword(user_pw);
		
		userVO uservo = new userVO();
		uservo.setUser_id(user_id);
		uservo.setUser_pw(ecdpw);
		
		try {
			logger.debug("\n\n검색값\n"+uservo.toString()+"\n");
			if(userservice.loginUser(uservo)){
				uservo = userservice.selectUser(uservo);
				
				//스케줄 겁색
				String sch_day = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				scheduleVO schvo = new scheduleVO();
				schvo.setUser_id(user_id);
				schvo.setSch_day(sch_day);
				List<Map<String, Object>> scheduleList = scheduleservice.scheduleList(schvo);
				
				
				logger.debug(uservo.toString());
				request.setAttribute("uservo", uservo);
				session.setAttribute("user_id", uservo.getUser_id());
				session.setAttribute("user_name", uservo.getUser_name());
				session.setAttribute("uservo", uservo);
				session.setAttribute("scheList", scheduleList);
				response.sendRedirect(url);
			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>alert('아이디랑 비밀번호를 다시 확인해주세요.'); location.href='"+loc+"' </script>");
				return;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/user/logout.do")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		session.invalidate(); //session clear
		
		//한글 깨짐
		//request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('로그아웃되었습니다.'); location.href='/common/main.do';</script>");
	}
	
	
	
	@RequestMapping("/user/userInfo.do")
	public ModelAndView userInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String user_id = request.getParameter("user_id");
		userVO uservo = new userVO();
		uservo.setUser_id(user_id);
		uservo = userservice.selectUser(uservo);
		logger.debug(uservo.toString());
		
		ModelAndView mv = new ModelAndView("/user/userInfo");
		mv.addObject("uservo", uservo);
		
		return mv;
	}
	
}
