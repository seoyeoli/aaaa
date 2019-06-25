package com.my.company.schedule.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.my.company.schedule.vo.scheduleVO;

public interface scheduleService {
	
	public List<Map<String,Object>> scheduleList(scheduleVO schedulevo);
	public List<HashMap<String,Object>> daySchedule(String user_id);
}
