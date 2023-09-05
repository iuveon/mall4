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
values (seq_seq_p_num.nextval, )