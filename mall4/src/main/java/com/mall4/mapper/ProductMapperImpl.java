package com.mall4.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mall4.domain.ProductVO;


public class ProductMapperImpl implements ProductMapper{
	
	
	@Override
	/*
	 * public List<ProductVO> getList() {
	 * 
	 * //List<ProductVO> cartList
	 * =(List)sqlSession.selectList("mapper.product.selectProductList",ProductVO);
	 * //return cartList; }
	 */

	@Override
	public void insert(ProductVO productVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductVO read(int p_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int p_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ProductVO productVO) {
		sqlSession.delete("mapper.product.deleteProduct",p_id);
	}

}
