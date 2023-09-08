package com.mall4.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {

	private int pageNum;	// 현재 페이지 번호
	private int amount;		// 한 페이지당 보여줄 게시글 개수
	
	private String type;	// 검색 유형 (T : title, C : content,  W : writer)
	private String keyword;	// 검색 내용
	
	public Criteria() {
		this(1, 10);		// 기본값 : 1페이지, 페이지당 게시글 10개
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	// 검색 조건을 배열로 만들어서 한번에 처리 (T, C, W)
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	// UriComponentsBuilder : 여러 개의 파라미터를 연결해서 URI로 만들어줌
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
			.queryParam("pageNum", this.pageNum)
			.queryParam("amount", this.getAmount())
			.queryParam("type", this.getType())
			.queryParam("keyword", this.getKeyword());
		
		return builder.toString();
	}
}