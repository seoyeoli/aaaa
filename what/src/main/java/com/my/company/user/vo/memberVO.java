package com.my.company.user.vo;

public class memberVO {
	//DB칼럼
	String mem_id; //멤버쉽id
	String user_num; //회원번호
	String mem_strday; //회원권시작일
	String mem_endday; //회원권종료일
	String mem_exp; //회원파기여부
	String mem_allpt; //전체pt수
	String mem_usept; //사용pt수
	String trainer_id; //pt트레이너id
	
	//가공데이터
	String mem_day; //회원권남은일수
	String mem_pt; //남은pt수
	
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getUser_num() {
		return user_num;
	}
	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}
	public String getMem_strday() {
		return mem_strday;
	}
	public void setMem_strday(String mem_strday) {
		this.mem_strday = mem_strday;
	}
	public String getMem_endday() {
		return mem_endday;
	}
	public void setMem_endday(String mem_endday) {
		this.mem_endday = mem_endday;
	}
	public String getMem_exp() {
		return mem_exp;
	}
	public void setMem_exp(String mem_exp) {
		this.mem_exp = mem_exp;
	}
	public String getMem_allpt() {
		return mem_allpt;
	}
	public void setMem_allpt(String mem_allpt) {
		this.mem_allpt = mem_allpt;
	}
	public String getMem_usept() {
		return mem_usept;
	}
	public void setMem_usept(String mem_usept) {
		this.mem_usept = mem_usept;
	}
	public String getTrainer_id() {
		return trainer_id;
	}
	public void setTrainer_id(String trainer_id) {
		this.trainer_id = trainer_id;
	}
	public String getMem_day() {
		return mem_day;
	}
	public void setMem_day(String mem_day) {
		this.mem_day = mem_day;
	}
	public String getMem_pt() {
		return mem_pt;
	}
	public void setMem_pt(String mem_pt) {
		this.mem_pt = mem_pt;
	}
	
	@Override
	public String toString() {
		return "memberVO [mem_id=" + mem_id + ", user_num=" + user_num + ", mem_strday=" + mem_strday + ", mem_endday="
				+ mem_endday + ", mem_exp=" + mem_exp + ", mem_allpt=" + mem_allpt + ", mem_usept=" + mem_usept
				+ ", trainer_id=" + trainer_id + ", mem_day=" + mem_day + ", mem_pt=" + mem_pt + "]";
	}
	
	
}
