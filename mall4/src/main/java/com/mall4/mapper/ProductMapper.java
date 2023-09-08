package com.mall4.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.mall4.domain.Criteria;
import com.mall4.domain.ProductVO;

public interface ProductMapper {

	
	public List<ProductVO> getList(); //상품목록 조회(R)
	
//	public List<ProductVO> getListWithPaging(Criteria cri);
	
	public void insert(ProductVO productVO); //productvo객체를 이용한 상품추가(C)
	
	public Integer insertSelectKey(ProductVO productVO);
	
	public ProductVO read(int p_num); //시퀀스 번호를 이용해서 상품 조회하기(R)
	
	public int delete(int p_num); //시퀀스 번호를 이용해 상품삭제(D)
	
	public int update(ProductVO productVO); //상품수정(U)
	
//	public int getTotalCount(Criteria cri);
	
	
}