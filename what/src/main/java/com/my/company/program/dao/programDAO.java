package com.my.company.program.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.my.company.common.dao.AbstractDAO;
import com.my.company.program.vo.programVO;

@Repository("programdao")
public class programDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> programList (programVO programvo){
		return (List<Map<String, Object>> ) selectList("programsql.programList", programvo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> registProgList (String user_id){
		return (List<Map<String, Object>> ) selectList("programsql.registProgList", user_id);
	}
}
