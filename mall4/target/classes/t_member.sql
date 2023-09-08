create sequence seq_member_num;

create table t_member(
	m_num number(20),
	m_id varchar2(30) not null unique,
	m_pw varchar2(30) not null,
	m_name varchar2(30) not null,
	m_email1 varchar2(30) not null,
	m_email2 varchar2(30) not null,
	m_phone varchar2(13) not null unique,
	m_birth varchar2(8),
	m_zipcode varchar2(5),
	m_address1 varchar2(100),				-- 도로명 주소
	m_address2 varchar2(100),				-- 지번 주소
	m_restAddress varchar2(100),			-- 나머지 주소(상세 주소)
	m_regdate date default sysdate not null	-- 가입일
);

alter table t_member add constraint pk_member primary key (m_num);

drop table t_member;

insert into t_member(m_num, m_id, m_pw, m_name, m_email1, m_email2, m_phone) 
	 values (seq_member_num.nextval, 'id1', 'pw1', 'name1', 'email1', 'naver.com', '010-0001-0001');
	 
insert into t_member(m_num, m_id, m_pw, m_name, m_email1, m_email2, m_phone) 
	 values (seq_member_num.nextval, 'id2', 'pw2', 'name2', 'email2', 'naver.com', '010-0001-0002');
	 
insert into t_member(m_num, m_id, m_pw, m_name, m_email1, m_email2, m_phone) 
	 values (seq_member_num.nextval, 'id3', 'pw3', 'name3', 'email3', 'naver.com', '010-0001-0003');

select * from t_member;
