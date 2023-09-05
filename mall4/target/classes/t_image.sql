create sequence seq_img_id;

create table t_image(
	img_id number(20),
	img_num number(20),
	img_name varchar2(30) not null,
	img_type varchar2(30) not null
);

alter table t_image add constraint pk_image primary key (img_id);
alter table t_image add constraint imf_fk_product foreign key (img_id) references t_product (p_num);