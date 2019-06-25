package com.my.company.schedule.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.my.company.common.dao.AbstractDAO;
import com.my.company.schedule.vo.scheduleVO;

@Repository("scheduledao")
public class scheduleDAO extends AbstractDAO{
	
	public List<Map<String, Object>> scheduleList (scheduleVO schedulevo){
		return (List<Map<String, Object>>) selectList("schedulesql.scheduleList", schedulevo);
	}
	
	public List<HashMap<String, Object>> daySchedule (String user_id){
		return (List<HashMap<String,Object>>) selectList("schedulesql.daySchedule",user_id);
	}
}
