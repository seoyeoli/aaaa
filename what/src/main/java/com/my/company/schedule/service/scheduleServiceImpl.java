package com.my.company.schedule.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.my.company.schedule.dao.scheduleDAO;
import com.my.company.schedule.vo.scheduleVO;

@Service("scheduleservice")
public class scheduleServiceImpl implements scheduleService{

	@Resource(name = "scheduledao")
	scheduleDAO scheduledao;
	
	public List<Map<String,Object>> scheduleList(scheduleVO schedulevo){
		return (List<Map<String,Object>>)scheduledao.scheduleList(schedulevo);
	}
	
	public List<HashMap<String, Object>> daySchedule(String user_id){
		return (List<HashMap<String, Object>>)scheduledao.daySchedule(user_id);
	}
}
