create sequence seq_board_num;

create table t_board(
	b_num number(20),
	b_title varchar2(100) not null,
	b_content varchar2(2000) not null,
	b_writer varchar2(30) not null,
	b_regdate date default sysdate not null,
	b_editdate date not null
);

alter table t_board add constraint pk_board primary key (b_num);

alter table t_board add constraint board_fk_member foreign key (b_writer) references t_member (m_id);