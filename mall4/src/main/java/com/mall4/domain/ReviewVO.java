package com.mall4.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {

	private Long b_num;
	private String b_title;
	private String b_content;
	private String b_writer;
	private Date b_regdate;
	private Date b_editdate;
}
