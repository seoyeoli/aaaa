package com.my.company.user.dao;

import org.springframework.stereotype.Repository;

import com.my.company.common.dao.AbstractDAO;
import com.my.company.user.vo.userVO;

@Repository("userDAO")
public class userDAO extends AbstractDAO{
	
	public userVO selectUser(userVO uservo) {
		return (userVO)selectOne("usersql.selectUser", uservo);
	}
	
	public boolean loginUser(userVO uservo) {
		return selectOne("usersql.loginUser", uservo) != null;
	}
}
