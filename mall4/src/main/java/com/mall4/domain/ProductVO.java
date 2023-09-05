package com.mall4.domain;

import lombok.Data;

@Data
public class ProductVO {

	private Long p_num;
	private String p_name;
	private Long p_price;
	private Long p_quantity;
	private String p_cate;
	private String p_size;
	private String p_desc;
	private String p_color;
}
