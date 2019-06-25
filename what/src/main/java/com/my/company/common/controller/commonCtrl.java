package com.my.company.common.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.company.board.service.boardService;
import com.my.company.board.vo.boardVO;

@Controller
public class commonCtrl {
	
	private static final Logger logger = LoggerFactory.getLogger(commonCtrl.class);
	
	@Resource(name = "boardservice")
	boardService boardservice;
	
	@RequestMapping("/common/main")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		
		boardVO boardvo = new boardVO();
		boardvo.setBoard_notice("Y");
		List<Map<String, Object>> list = boardservice.boardList(boardvo);
		
		ModelAndView mv = new ModelAndView("/common/main");
		mv.addObject("list", list);
		return mv;
	}
	
	
}
