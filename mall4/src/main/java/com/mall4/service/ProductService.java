package com.mall4.service;

import java.util.List;

import com.mall4.domain.Criteria;
import com.mall4.domain.ProductVO;

public interface ProductService {
	
	public void register(ProductVO productVO);
	
	public ProductVO get(int p_num);
	
	public boolean modify(ProductVO productVO);
	
	public boolean remove(int p_num);
	
	public List<ProductVO> getList();
	
//	public List<ProductVO> getList(Criteria cri);
	
//	public int getTotal(Criteria cri);
}
