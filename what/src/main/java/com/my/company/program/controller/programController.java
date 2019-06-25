package com.my.company.program.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class programController {

	@RequestMapping("/program/progList.do")
	public ModelAndView progList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/program/progList");
	}
}
