package com.my.company.board.vo;

public class boardVO {
	
	//DB 존재
	String board_id ;
	String user_id ;
	String board_title ;
	String board_body ;
	String board_wrt_date;
	String board_del_yn;
	String board_old_id;
	String board_notice;

	// 필요할것같아서
	String row_num;
	String user_name;
	String user_num;
	public String getBoard_id() {
		return board_id;
	}
	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_body() {
		return board_body;
	}
	public void setBoard_body(String board_body) {
		this.board_body = board_body;
	}
	public String getBoard_wrt_date() {
		return board_wrt_date;
	}
	public void setBoard_wrt_date(String board_wrt_date) {
		this.board_wrt_date = board_wrt_date;
	}
	public String getBoard_del_yn() {
		return board_del_yn;
	}
	public void setBoard_del_yn(String board_del_yn) {
		this.board_del_yn = board_del_yn;
	}
	public String getBoard_old_id() {
		return board_old_id;
	}
	public void setBoard_old_id(String board_old_id) {
		this.board_old_id = board_old_id;
	}
	public String getBoard_notice() {
		return board_notice;
	}
	public void setBoard_notice(String board_notice) {
		this.board_notice = board_notice;
	}
	public String getRow_num() {
		return row_num;
	}
	public void setRow_num(String row_num) {
		this.row_num = row_num;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_num() {
		return user_num;
	}
	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}
	@Override
	public String toString() {
		return "boardVO [board_id=" + board_id + ", user_id=" + user_id + ", board_title=" + board_title
				+ ", board_body=" + board_body + ", board_wrt_date=" + board_wrt_date + ", board_del_yn=" + board_del_yn
				+ ", board_old_id=" + board_old_id + ", board_notice=" + board_notice + ", row_num=" + row_num
				+ ", user_name=" + user_name + ", user_num=" + user_num + "]";
	}
	
	
	
	
}
