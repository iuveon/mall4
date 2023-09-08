package com.mall4.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

	private int startPage;		// 현재 화면에서 시작 페이지
	private int endPage;		// 현재 화면에서 마지막 페이지
	private boolean prev, next;	// 이전 페이지, 다음 페이지
	
	private int total;			// 총 게시글 개수
	private Criteria cri;		// pageNum : 현재 페이지 번호, amount : 한 페이지당 보여줄 게시글 개수
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;
		
		// realEnd : 총 페이지의 마지막 페이지 번호
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
		// if(실제 총 페이지의 마지막 페이지 번호 < 현재 화면에서 마지막 페이지(10개 번호 단위))
		//	현재 화면에서 마지막 페이지 = 총 페이지의 마지막 페이지 번호;
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		// 이전 페이지 : 현재 화면에서 시작 페이지가 1보다 클 경우(11, 21, ...) 생성
		this.prev = this.startPage > 1;
		
		// 다음 페이지 : '현재 화면에서 마지막 페이지(10개 번호 단위) < 총 페이지의 마지막 페이지 번호' 일 경우 생성
		this.next = this.endPage < realEnd;
	}
	
}
