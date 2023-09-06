package com.mall4.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mall4.domain.ProductVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ProductMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}//전체목록 조회
	
	@Test
	public void testRead() {
		
		ProductVO productVO = mapper.read(3);
		log.info(productVO);
	}//인덱스 번호로 상품조회
	
	@Test
	public void testInsert() {
		
		ProductVO productVO = new ProductVO();
		
		productVO.setP_name("반팔티");
		productVO.setP_price(9000);
		productVO.setP_quantity(2);
		productVO.setP_cate("top");
		productVO.setP_size("free");
		productVO.setP_desc("데일리로 매칭하기 좋은 베이직템");
		productVO.setP_color("네이비");
		
		mapper.insert(productVO);
		log.info(productVO);
	}//상품추가
	
	
	@Test
	public void testUpdate() {
		
		ProductVO productVO = new ProductVO();
		productVO.setP_num(5);
		productVO.setP_quantity(10);
		productVO.setP_color("레드");
		productVO.setP_price(18000);
		
		int count = mapper.update(productVO);
		log.info("업데이트된 상품개수: "+count);
	}//상품수정
	
	
	@Test
	public void testDelete() {
		
		log.info("삭제된 상품 개수: "+mapper.delete(2));
		
	}//상품삭제
}
