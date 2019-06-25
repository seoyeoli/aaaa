create table just_user
(
    user_id varchar2(100) primary key,
    user_num varchar2(100),
    user_name varchar2(100),
    user_pw varchar2(2000),
    user_birthday varchar2(6),
    user_phone varchar2(11),
    user_visit date,
    user_auth char(2)
)

	insert into just_user(user_id, user_pw, user_name,user_auth)
	values('admin','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5','관리자','AD');


create table just_board
(
    board_id varchar2(100) primary key,
    user_NUM varchar2(100),
    board_title varchar2(1000),
    board_body varchar2(2000),
    board_wrt_date date default sysdate,
    board_del_yn char(1) default 'N',
    board_old_id varchar2(100),
    board_notice char(1) default 'N'
)


create table just_reple
(
    reple_id varchar2(100),
    board_id varchar2(100),
    reple_old_id varchar2(100),
    reple_body varchar2(2000),
    user_id varchar2(100),
    reple_wrt_date date,
    reple_del_yn char(1) default 'N'
)


create table just_member(
    mem_id varchar2(100) primary key,
    user_num varchar2(100),
    mem_strday date,
    mem_endday date,
    mem_exp char(1) default 'N',
    mem_allpt varchar2(100),
    mem_usept varchar2(100),
    trainer_id varchar2(100)
)


create table just_code
(
    code_id char(2),
    code_name varchar2(100),
    code_prog char(3) --어디서사용중인지
)

	insert into just_code( code_id , code_name, code_prog) values('PT', 'PT' ,'PRG');
	insert into just_code( code_id , code_name, code_prog) values('YO', 'YOGA', 'PRG');
	insert into just_code( code_id , code_name, code_prog) values('PI', '필라테스', 'PRG');
	insert into just_code( code_id , code_name, code_prog) values('DA', '댄스', 'PRG');
	
	insert into just_code( code_id , code_name, code_prog) values('TP', 'PT트레이너', 'USR');
	insert into just_code( code_id , code_name, code_prog) values('AD', '관리자', 'USR');
	
	insert into just_code( code_id , code_name, code_prog) values('01', '등록신청', 'SCH');
	insert into just_code( code_id , code_name, code_prog) values('02', '역요청', 'SCH');
	insert into just_code( code_id , code_name, code_prog) values('03', '신청완료', 'SCH');
	insert into just_code( code_id , code_name, code_prog) values('04', '취소', 'SCH');
	insert into just_code( code_id , code_name, code_prog) values('05', '완료', 'SCH');
	insert into just_code( code_id , code_name, code_prog) values('06', '미완료', 'SCH');
	                                                          


create table just_program(
    prog_id varchar2(100),
    prog_type char(2),
    prog_name varchar2(1000)
    prog_trainer varchar2(100),
    prog_remark varchar2(2000),
    prog_limit number(3),
)

	insert into just_program (
	    PROG_ID,
	    PROG_TYPE,
	    PROG_TRAINER,
	    PROG_REMARK,
	    PROG_LIMIT,
	    PROG_NAME)
	values(
	    'PT20190620000', --'PT'||to_char(sysdate,'yyyymmdd')||'000',
	    'PT',
	    'admin',
	    '관리자 트레이너의 PT수업',
	    '999',
	    '관리자 PT'
	)


create table just_prog_user
(
    prog_id varchar2(100),
    user_id varchar2(100)
)
--프로그램생성-> 유저할당(등록할 수 있는 스케줄 설정)-> 스케쥴생성

	insert into just_prog_user (prog_id, user_id)
	values('PT20190620000', 'admin');

create table just_schedule
(
    sch_id varchar2(100) primary key,
    user_id varchar2(100),
    sch_day varchar2(100),
    sch_time varchar2(100),
    prog_id varchar2(100),
    sch_wrt_user_id varchar2(100),
    sch_statue_code char(2) default '00'
)
--00 등록신청
--01 트레이너쪽에서 역요청
--02 신청완료
--03 취소
--04 완료
--05 미완료


	insert into just_schedule(
	    sch_id ,
	    user_id ,
	    sch_day ,
	    sch_time ,
	    prog_id ,
	    sch_wrt_user_id,
	    sch_statue_code
	)
	values(
	    to_char(sysdate,'yyyymmddhh24miss')||'000',
	    'admin',
	    '20190625',
	    '1400',
	    'PT20190620000',
	    'admin',
	    '02'
	);


