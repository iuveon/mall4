package com.mall4.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.mall4.domain.BagProductVO;


public interface BagProductMapper {

	
	public List<BagProductVO> getList(); //상품목록 조회(R)
	
	public void insert(BagProductVO bagProductVO); //bagProductVO객체를 이용한 상품추가(C)
	
	public void insertSelectKey(BagProductVO bagProductVO); //bagProductVO객체를 이용한 상품추가(C)
	
	public BagProductVO read(int p_num); //시퀀스 번호를 이용해서 상품 조회하기(R)
	
	public int delete(int p_num); //시퀀스 번호를 이용해 상품삭제(D)
	
	public int update(BagProductVO bagProductVO); //상품수정(U)
	
	
}
