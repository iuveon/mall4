create sequence seq_p_num;
drop sequence seq_p_num;
drop table t_bag_product;

create table t_bag_product(
	p_num number(20),
	p_name varchar2(50) not null,
	p_price number(9) not null,
	p_quantity number(9) not null,
	p_cate varchar2(50) not null,
	p_size varchar2(50) not null,
	p_desc varchar2(1000) not null,
	p_color varchar2(50) not null
);

delete from t_bag_product
alter table t_bag_product add constraint pk_bag_product primary key (p_num);

insert into t_bag_product values (seq_p_num.nextval,'당근숄더백',10000,3,'숄더백','m','귀여운 당근모양 숄더백','주황' );
insert into t_bag_product values (seq_p_num.nextval,'오이버킷백',15000,4,'버킷백','s','오이그림 버킷백','초록' );
insert into t_bag_product values (seq_p_num.nextval,'호박쇼퍼백',20000,3,'쇼퍼백','m','호박처럼 큰 쇼퍼백','주황' );
insert into t_bag_product values (seq_p_num.nextval, '귤미니백', 30000, 3, '토드백', 'S', '앙증맞은 귤미니백', '노랑');
insert into t_bag_product values (seq_p_num.nextval, '가지크로스백',25000, 2, '미니백', 'S', '길고 수납공간 좋은 가지크로스백', '보라');
insert into t_bag_product values (seq_p_num.nextval, '수박백팩', 38000, 5, '크로스백', 'L', '수박같이 동글동글 백팩', '초록');


select * from t_bag_product;



