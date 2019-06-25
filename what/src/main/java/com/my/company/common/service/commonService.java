package com.my.company.common.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface commonService {
	
	public boolean chkSession(HttpServletRequest request, HttpServletResponse response, String loc) ;
	
}
