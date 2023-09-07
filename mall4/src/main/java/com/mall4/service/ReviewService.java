package com.mall4.service;

import java.util.List;

import com.mall4.domain.Criteria;
import com.mall4.domain.ReviewVO;

public interface ReviewService {
	
	// 전체 게시글 목록 조회
	// public List<ReviewVO> getList();
	
	// 전체 게시글 목록 조회 (페이징)
	public List<ReviewVO> getList(Criteria cri);

	// 새 게시글 추가
	public void register(ReviewVO review);
	
	// 게시글 내용 조회
	public ReviewVO get(Long b_num);
	
	// 게시글 수정
	public boolean modify(ReviewVO review);
	
	// 게시글 삭제
	public boolean remove(Long b_num);

}
