create sequence seq_review_num;

create table t_review(
	b_num number(20),
	b_title varchar2(100) not null,
	b_content varchar2(2000) not null,
	b_writer varchar2(30) not null,
	b_regdate date default sysdate not null,
	b_editdate date default sysdate not null
);

alter table t_review add constraint pk_review primary key (b_num);

alter table t_review drop constraint pk_review;

alter table t_review add constraint review_fk_member foreign key (b_writer) references t_member (m_id);

select /*+INDEX_DESC(t_review pk_review) */ * from t_review;

select * from all_constraints where table_name = 'T_REVIEW';

insert into t_review(b_num, b_title, b_content, b_writer)
	 values (seq_review_num.nextval, '테스트제목', '테스트내용', 'id1');
	 
insert into t_review(b_num, b_title, b_content, b_writer)
	 values (seq_review_num.nextval, '테스트제목', '테스트내용', 'id2');
	 
insert into t_review(b_num, b_title, b_content, b_writer)
	 values (seq_review_num.nextval, '검색테스트', '검색테스트', 'id3');