package com.my.company.program.service;

import java.util.List;
import java.util.Map;

import com.my.company.program.vo.programVO;

public interface programService {

	
	public List<Map<String, Object>> programList(programVO programvo);
	
	public List<Map<String, Object>> registProgList(String user_id);
	
	
}