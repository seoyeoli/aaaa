package com.my.company.board.service;

import java.util.List;
import java.util.Map;

import com.my.company.board.vo.boardVO;

public interface boardService {
	public List<Map<String,Object>> noticeList(boardVO boardvo);
	public List<Map<String,Object>> boardList(boardVO boardvo);
	public void saveBoard(boardVO boardvo);
	public boardVO selectBoard(String board_id);
}
