package com.my.company.common.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class echoHandler extends TextWebSocketHandler{
	
	private static final Logger logger = LoggerFactory.getLogger(echoHandler.class);
	
//	public echoHandler() {
//		super();
//		this.logger.info("create");
//	}
	
	/**
	 *  웹소켓 연결이 성사 되고 해야 할 일
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("{} 연결됨gg"+session.getId());
	}
	
	
	/**
	 * 웹소켓 서버단으로 메세지가 도착했을 때 해주어야 할 일들을 정의하는 메소드.
	 * 클라이언트가 웹소켓 서버로 메세지를 전송했을 때 실행되는 메소드
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info(" {} 로부터 받은 메세지 : {}", session.getId(), message.getPayload());
		
		//연결되어있는 모든 클라이언트들에게 메시지 전송 <- 채팅했을때인거같은데..
//		session.sendMessage(new TextMessage("echo:"+message.getPayload()));
		
		//쪽지의 알람 형식으로 할거라서
		//페이지 이동 시...?? 그냥 몇분마다..??? 새로수신된 쪽지 확인..
		session.sendMessage(new TextMessage(""));
		
	}
	
	/**
	 * 웹 소켓 연결이 종료되고 나서(클라이언트가 연결을 끊었을 때) 서버단에서 실행
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info("{} 연결 끊김 ",session.getId());
		super.afterConnectionClosed(session, status);
	}
	
}
