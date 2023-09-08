package com.mall4.service;

import java.util.List;

import com.mall4.domain.BagProductVO;

public interface BagProductService {
	public void register(BagProductVO bagProductVO); // 게시물추가
	public BagProductVO get(int p_num); // 특정 게시물가져오기
	public boolean modify(BagProductVO bagProductVO); //수정
	public boolean remove(int p_num); //삭제
	public List<BagProductVO> getList(); // 전체리스트
}
