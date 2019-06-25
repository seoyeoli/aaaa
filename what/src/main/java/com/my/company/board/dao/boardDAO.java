package com.my.company.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.my.company.board.vo.boardVO;
import com.my.company.common.dao.AbstractDAO;

@Repository("boardDAO")
public class boardDAO extends AbstractDAO{
	
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> selectBoardList(boardVO boardvo) {
		return (List<Map<String, Object>>)selectList("boardsql.selectBoardList", boardvo);
	}
	
	public void saveBoard(boardVO boardvo) {
		insert("boardsql.saveBoard", boardvo);
	}
	
	
	public boardVO selectBoard(String board_id) {
		return (boardVO)selectOne("boardsql.selectBoard", board_id);
	}
}
