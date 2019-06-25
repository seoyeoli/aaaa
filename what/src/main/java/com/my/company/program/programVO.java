package com.my.company.program;

public class programVO {
	String prog_id;
	String prog_type;
	String prog_name;
	String prog_trainer;
	String prog_remark;
	String prog_limit;
	
	String user_id;
	String user_name;
	String prog_trainer_name;
	String prog_type_name;
	
	public String getProg_id() {
		return prog_id;
	}
	public void setProg_id(String prog_id) {
		this.prog_id = prog_id;
	}
	public String getProg_type() {
		return prog_type;
	}
	public void setProg_type(String prog_type) {
		this.prog_type = prog_type;
	}
	public String getProg_name() {
		return prog_name;
	}
	public void setProg_name(String prog_name) {
		this.prog_name = prog_name;
	}
	public String getProg_trainer() {
		return prog_trainer;
	}
	public void setProg_trainer(String prog_trainer) {
		this.prog_trainer = prog_trainer;
	}
	public String getProg_remark() {
		return prog_remark;
	}
	public void setProg_remark(String prog_remark) {
		this.prog_remark = prog_remark;
	}
	public String getProg_limit() {
		return prog_limit;
	}
	public void setProg_limit(String prog_limit) {
		this.prog_limit = prog_limit;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getProg_trainer_name() {
		return prog_trainer_name;
	}
	public void setProg_trainer_name(String prog_trainer_name) {
		this.prog_trainer_name = prog_trainer_name;
	}
	public String getProg_type_name() {
		return prog_type_name;
	}
	public void setProg_type_name(String prog_type_name) {
		this.prog_type_name = prog_type_name;
	}
	
	@Override
	public String toString() {
		return "programVO [prog_id=" + prog_id + ", prog_type=" + prog_type + ", prog_name=" + prog_name
				+ ", prog_trainer=" + prog_trainer + ", prog_remark=" + prog_remark + ", prog_limit=" + prog_limit
				+ ", user_id=" + user_id + ", user_name=" + user_name + ", prog_trainer_name=" + prog_trainer_name
				+ ", prog_type_name=" + prog_type_name + "]";
	}
	
	
}
