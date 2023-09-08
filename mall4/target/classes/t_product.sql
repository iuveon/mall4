create sequence seq_p_num;

create table t_product(
	p_num number(20),
	p_name varchar2(50) not null,
	p_price number(9) not null,
	p_quantity number(9) not null,
	p_cate varchar2(50) not null,
	p_size varchar2(50) not null,
	p_desc varchar2(1000) not null,
	p_color varchar2(50) not null
);

alter table t_product add constraint pk_product primary key (p_num);

insert into T_PRODUCT(p_num, p_name, p_price, p_quantity, p_cate, p_size, p_desc, p_color)
values (seq_p_num.nextval, '스트레이트진', 30000, 3, '하의', 'L', '심플한 데일리용으로 활용도 good!', '블랙');
insert into T_PRODUCT(p_num, p_name, p_price, p_quantity, p_cate, p_size, p_desc, p_color)
values (seq_p_num.nextval, '테니스스커트', 25000, 2, '하의', 'S', '따듯한 봄부터 여름까지 예쁘게~!', '화이트');
insert into T_PRODUCT(p_num, p_name, p_price, p_quantity, p_cate, p_size, p_desc, p_color)
values (seq_p_num.nextval, '와이드팬츠', 38000, 5, '하의', 'M', '편하게 입고다니기 좋은 바지', '그레이');
insert into T_PRODUCT values (seq_p_num.nextval,'shirt','10500',3,'top','m','셔츠','pink' );
insert into T_PRODUCT values (seq_p_num.nextval,'cardigan','10500',3,'top','m','가디건','yellow' );
insert into T_PRODUCT values (seq_p_num.nextval,'blouse','10500',3,'top','m','블라우스','red' );

select * from T_PRODUCT where p_num > 0 ;