package com.my.company.user.service;

import com.my.company.user.vo.userVO;

public interface userService {
	
	public userVO selectUser(userVO uservo) throws Exception ;
	public boolean loginUser(userVO uservo) throws Exception ;
	
}
