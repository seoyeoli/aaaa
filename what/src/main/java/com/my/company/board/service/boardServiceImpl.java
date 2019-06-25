package com.my.company.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.my.company.board.dao.boardDAO;
import com.my.company.board.vo.boardVO;

@Service("boardservice")
public class boardServiceImpl implements boardService{
	
	@Resource(name = "boardDAO")
	boardDAO boardDao;

	@Override
	public List<Map<String, Object>> noticeList(boardVO boardvo) {
		// TODO Auto-generated method stub
		return boardDao.selectBoardList(boardvo);
	}

	@Override
	public List<Map<String, Object>> boardList(boardVO boardvo) {
		// TODO Auto-generated method stub
		return boardDao.selectBoardList(boardvo);
	}
	
	@Override
	public void saveBoard(boardVO boardvo) {
		boardDao.saveBoard(boardvo);
	}
	
	@Override
	public boardVO selectBoard(String board_id) {
		return boardDao.selectBoard(board_id);
	}
	
}
