create sequence seq_board_num;

create table QnA_board(
    b_num number(20), --게시물 번호(pk)
    b_item varchar2(100), --상품명 
	b_title varchar2(500) not null, --게시물 제목 
	b_writer varchar2(30) not null, --작성자(fk) 
	b_regdate date default sysdate not null --작성일 
	);

--drop table QnA_board;
	
alter table QnA_board add constraint pk_board primary key (b_num); --게시물번호에 기본키 부여 

alter table QnA_board add constraint board_fk_member foreign key (b_writer) references t_member (m_id); 
--t_member테이블의 m_id를 참조하는 외래키를 t_board의 b_writer 에게 부여 

--t_member테이블에 데이터 다시 넣으려고 제약조건 잠시 삭제 
alter table QnA_board drop constraint board_fk_member; 
--alter table t_board drop constraint pk_board;


select * from QnA_board;

--테이블에 테스트 글 추가 
insert into QnA_board(b_num, b_item, b_title, b_writer, b_regdate)
values(1, '하늘셔츠', '테스트글입니다.', '빨강', sysdate);
insert into QnA_board(b_num, b_item, b_title, b_writer, b_regdate)
values(2, '하늘셔츠', '안녕하세요.', '빨강', sysdate);
insert into QnA_board(b_num,  b_item, b_title, b_writer, b_regdate)
values(3, '하늘셔츠', '답변입니다.', '빨강', sysdate);
insert into QnA_board(b_num,  b_item, b_title, b_writer, b_regdate)
values(5, '검정셔츠', '답변입니다.', '초록', sysdate);
insert into QnA_board(b_num,  b_item, b_title, b_writer, b_regdate)
values(4, '하늘셔츠', '파랑입니다.', '파랑', sysdate);
insert into QnA_board(b_num,  b_item, b_title, b_writer, b_regdate)
values(6, '검정셔츠', '초록님의 상품사용후기를 올립니다.', '초록', sysdate);



       
