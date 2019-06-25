package com.my.company.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.my.company.user.dao.userDAO;
import com.my.company.user.vo.userVO;

@Service("userservice")
public class userServiceImpl implements userService {
	
	@Resource(name="userDAO")
	userDAO userdao;
	
	@Override
	public userVO selectUser(userVO uservo) throws Exception {
		return userdao.selectUser(uservo);
	}

	@Override
	public boolean loginUser(userVO uservo) throws Exception {
		return userdao.loginUser(uservo);
	}
}
