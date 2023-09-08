package com.mall4.service;

import java.util.List;

import com.mall4.domain.QnAVO;

public interface QnAService {
	
	//전체 게시글 목록 조회
	   public List<QnAVO> getList();
	   
	   
	   // 새 게시글 추가
	   public void register(QnAVO review);
	   
	   // 게시글 내용 조회
	   public QnAVO get(Long b_num);
	   
	   // 게시글 수정
	   public boolean modify(QnAVO review);
	   
	   // 게시글 삭제
	   public boolean remove(Long b_num);


}
