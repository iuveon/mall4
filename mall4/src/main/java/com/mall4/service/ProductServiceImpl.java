package com.mall4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall4.domain.Criteria;
import com.mall4.domain.ProductVO;
import com.mall4.mapper.ProductMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	@Setter(onMethod_ = @Autowired)
	private ProductMapper mapper;

	
	@Override
	public ProductVO get(int p_num) {
		
		log.info("get메서드: " + p_num);
		
		return mapper.read(p_num);
	}//번호조회

	@Override
	public boolean modify(ProductVO productVO) {
		
		log.info("modify메서드: "+productVO);
		
		return mapper.update(productVO) == 1;
	}//수정

	@Override
	public boolean remove(int p_num) {
		
		log.info("remove메서드: "+ p_num);
		
		return mapper.delete(p_num) == 1;
	}//삭제

	
	
	@Override
	public List<ProductVO> getList() {
		
		log.info("getList메서드: ");
		
		return mapper.getList();
	}//전체조회

	
	
	
	@Override
	public void register(ProductVO productVO) {
		
		log.info("상품추가" + productVO);

		mapper.insertSelectKey(productVO);
		
	}//상품추가

/*	@Override
	public List<ProductVO> getList(Criteria cri) {
		
		log.info("get List with criteria"+ cri);
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		
		log.info("get total count");
		
		return mapper.getTotalCount(cri);
	}
*/	
	
	
}
