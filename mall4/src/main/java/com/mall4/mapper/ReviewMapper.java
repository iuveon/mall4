package com.mall4.mapper;

import java.util.List;

import com.mall4.domain.Criteria;
import com.mall4.domain.ReviewVO;

public interface ReviewMapper {

	// 전체 게시글 목록 조회
	public List<ReviewVO> getList();
	
	// 전체 게시글 목록 조회(페이징)
	public List<ReviewVO> getListWithPaging(Criteria cri);
	
	// 새 게시글 추가
	public void insert(ReviewVO review);
	
	// 게시글 내용 조회
	public ReviewVO read(Long b_num);
	
	// 게시글 수정
	public int update(ReviewVO review);
	
	// 게시글 삭제
	public int delete(Long b_num);
	
	// 전체 게시글 개수
	public int getTotalCount(Criteria cri);
	
}
