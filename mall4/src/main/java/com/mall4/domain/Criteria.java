package com.mall4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {

	private int pageNum;	// 현재 페이지 번호
	private int amount;		// 한 페이지당 보여줄 게시글 개수
	
	public Criteria() {
		this(1, 10);		// 기본값 : 1페이지, 페이지당 게시글 10개
	}
}
