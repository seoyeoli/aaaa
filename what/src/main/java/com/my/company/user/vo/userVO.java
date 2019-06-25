package com.my.company.user.vo;

public class userVO {
	String user_id;
	String user_num;
	String user_pw;
	String user_name;
	String user_birthday;
	String user_phone;
	String user_visit;
	String user_auth;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_num() {
		return user_num;
	}
	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_birthday() {
		return user_birthday;
	}
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_visit() {
		return user_visit;
	}
	public void setUser_visit(String user_visit) {
		this.user_visit = user_visit;
	}
	public String getUser_auth() {
		return user_auth;
	}
	public void setUser_auth(String user_auth) {
		this.user_auth = user_auth;
	}
	
	@Override
	public String toString() {
		return "userVO [user_id=" + user_id + ", user_num=" + user_num + ", user_pw=" + user_pw + ", user_name="
				+ user_name + ", user_birthday=" + user_birthday + ", user_phone=" + user_phone + ", user_visit="
				+ user_visit + ", user_auth=" + user_auth + "]";
	}
	
	
	
}
