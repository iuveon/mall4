package com.mall4.domain;

import java.sql.Date;

public class QnAVO {
	//조회한 글을 저장하는 역할
	//vo는 값 그 자체의 의미를 가진 read-only 클래스(getter기능만 존재함)
	
	//필드
	
	private int b_num; //게시물 번호
	
	private String b_item;//상품명
	private String b_title;//게시글 제목
	private String b_writer;//작성자
	private Date b_regdate;//작성날짜 
	//생성자
	public QnAVO() {} //기본 생성자 
	//생성자 초기화 
	public QnAVO( int b_num, String b_item, String b_title,
			         String b_writer, Date b_regdate) {
		 
		this.b_num = b_num;
		
		this.b_item = b_item;
		this.b_title = b_title;
		this.b_writer = b_writer;
		this.b_regdate = b_regdate;
	}
	
	
	//메서드 
	
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	
	public String getB_item() {
		return b_item;
	}
	public void setB_item(String b_item) {
		this.b_item = b_item;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public Date getB_regdate() {
		return b_regdate;
	}
	public void setB_regdate(Date b_regdate) {
		this.b_regdate = b_regdate;
	}
	
	
	
	

}
