package com.my.company.common.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service("commonservice")
public class commonServiceImpl implements commonService{

	@Override
	public boolean chkSession(HttpServletRequest request, HttpServletResponse response, String loc){
		
		if (request.getSession(false) != null) {
			return true;
		}else {
			PrintWriter out = null;
			try {
				out = response.getWriter();
			}catch (Exception e) {
			}
			out.println("<script>alert('세션이 끊어졌습니다. 재 로그인 해 주시기 바랍니다.'); location.href='"+loc+"';</script>");
			return false;
		}
	}
	
	
}
