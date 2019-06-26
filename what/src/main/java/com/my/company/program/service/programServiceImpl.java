package com.my.company.program.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.my.company.program.dao.programDAO;
import com.my.company.program.vo.programVO;

@Service("programservice")
public class programServiceImpl implements programService{
	
	@Resource(name ="programdao")
	programDAO programdao;

	@Override
	public List<Map<String, Object>> programList(programVO programvo) {
		return programdao.programList(programvo);
	}

	@Override
	public List<Map<String, Object>> registProgList(String user_id) {
		return programdao.registProgList(user_id);
	}
	
	
	
}
