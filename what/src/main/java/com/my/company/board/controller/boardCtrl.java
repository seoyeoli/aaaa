package com.my.company.board.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.company.board.service.boardService;
import com.my.company.board.vo.boardVO;


@Controller
public class boardCtrl {
	
	@Resource(name = "boardservice")
	boardService boardservice;
	
	private static final Logger logger = LoggerFactory.getLogger(boardCtrl.class);
	
	@RequestMapping("/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		boardVO boardvo1 = new boardVO();
		boardVO boardvo2 = new boardVO();
		
		//공지사항
		boardvo1.setBoard_notice("Y");
		List<Map<String, Object>> noticeList = boardservice.noticeList(boardvo1); 
		
		//최신글
		boardvo2.setBoard_notice("N");
		List<Map<String, Object>> boardList = boardservice.boardList(boardvo2);
		
		ModelAndView mv = new ModelAndView("/board/boardList");
		mv.addObject("noticeList", noticeList);
		mv.addObject("boardList", boardList);

		logger.debug("\n\n\t noticeList"+noticeList+"\n\n");
		logger.debug("\n\n\t boardList"+boardList+"\n\n");
		return mv;
	}
	
	
	@RequestMapping("/board/boardWrite.do")
	public ModelAndView boardWrite() {
		return new ModelAndView("/board/boardWrite");
	}
	
	@RequestMapping("/board/boardSave.do")
	public void boardSave(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		boardVO boardvo = new boardVO();
		
		boardvo.setBoard_title(request.getParameter("board_title"));
		boardvo.setBoard_body(request.getParameter("board_body"));
		boardvo.setUser_id(request.getParameter("user_id"));
		boardvo.setBoard_old_id(request.getParameter("board_old_id"));
		
		boardservice.saveBoard(boardvo);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('저장되었습니다.'); location.href='/board/boardList.do' </script>");
		out.flush();
		return;
		
		//new ModelAndView("redirect:/board/boardList.do");
	}
	
	
	
	@RequestMapping("/board/boardInfo.do")
	public ModelAndView boardInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String board_id = request.getParameter("board_id");
		
		boardVO boardvo = new boardVO();
		boardvo = boardservice.selectBoard(board_id);
		logger.debug("\n\n조회된 board\n"+boardvo.toString());
		ModelAndView mv = new ModelAndView("/board/boardInfo");
		mv.addObject("boardvo", boardvo);
		
		return mv; 
	}
	
}
