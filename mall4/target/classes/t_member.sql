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
	m_address1 varchar2(100), -- 도로명 주소
	m_address2 varchar2(100), -- 지번 주소
	m_restAddress varchar2(100), -- 나머지 주소(상세 주소)
	m_regdate date default sysdate not null -- 가입일
);

alter table t_member add constraint pk_member primary key (m_num);

drop table t_member;

select * from T_MEMBER;

insert into t_member (m_num, m_id, m_pw, m_name, m_email1, m_email2, m_phone) values (seq_member_num.nextval, 'testid1', '1234', '테스터', 'tester', 'ez.com', '010-0000-0001');
insert into t_member (m_num, m_id, m_pw, m_name, m_email1, m_email2, m_phone) values (seq_member_num.nextval, 'testid2', '1234', '테스터', 'tester', 'ez.com', '010-0000-0002');
insert into t_member (m_num, m_id, m_pw, m_name, m_email1, m_email2, m_phone) values (seq_member_num.nextval, 'testid3', '1234', '테스터', 'tester', 'ez.com', '010-0000-0003');
insert into t_member (m_num, m_id, m_pw, m_name, m_email1, m_email2, m_phone) values (seq_member_num.nextval, 'testid4', '1234', '테스터', 'tester', 'ez.com', '010-0000-0004');
insert into t_member (m_num, m_id, m_pw, m_name, m_email1, m_email2, m_phone) values (seq_member_num.nextval, 'testid5', '1234', '테스터', 'tester', 'ez.com', '010-0000-0005');
insert into t_member (m_num, m_id, m_pw, m_name, m_email1, m_email2, m_phone) values (seq_member_num.nextval, 'testid6', '1234', '테스터', 'tester', 'ez.com', '010-0000-0006');
insert into t_member (m_num, m_id, m_pw, m_name, m_email1, m_email2, m_phone) values (seq_member_num.nextval, 'testid7', '1234', '테스터', 'tester', 'ez.com', '010-0000-0007');
insert into t_member (m_num, m_id, m_pw, m_name, m_email1, m_email2, m_phone) values (seq_member_num.nextval, 'testid8', '1234', '테스터', 'tester', 'ez.com', '010-0000-0008');
insert into t_member (m_num, m_id, m_pw, m_name, m_email1, m_email2, m_phone) values (seq_member_num.nextval, 'testid9', '1234', '테스터', 'tester', 'ez.com', '010-0000-0009');
insert into t_member (m_num, m_id, m_pw, m_name, m_email1, m_email2, m_phone) values (seq_member_num.nextval, 'testid10', '1234', '테스터', 'tester', 'ez.com', '010-0000-0010');
insert into t_member values (seq_member_num.nextval, 'testid11', '1234', '테스터', 'tester', 'ez.com', '010-0000-0011', '19920101', '12345', '경기도 수원시 매산로', '경기도 수원시 매산동', 'EZ304', sysdate);