package com.mall4.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mall4.domain.BagProductVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BagProductServiceTests {
	@Setter(onMethod_ = @Autowired)
	private BagProductServiceImpl bagProductService;
	
	
	@Test // 전체목록 조회
	public void testGetList() {
		bagProductService.getList().forEach(board -> log.info(board));
	}
	
	
	@Test // 신규 상품등록
	public void testRegister() {
		BagProductVO bagProductVO = new BagProductVO();

		bagProductVO.setP_name("망고미니백");
		bagProductVO.setP_price(9000);
		bagProductVO.setP_quantity(2);
		bagProductVO.setP_cate("미니백");
		bagProductVO.setP_size("S");
		bagProductVO.setP_desc("상큼컬러 망고백!");
		bagProductVO.setP_color("노랑");
		
		bagProductService.register(bagProductVO);
		log.info(bagProductVO);
	}
	
	@Test
	public void testGet() {
		log.info(bagProductService.get(1));
	}
	
	@Test
	public void testModify() {
		BagProductVO bagProductVO = bagProductService.get(1);
		if(bagProductVO == null) {
			return;
		}
		bagProductVO.setP_quantity(10);
		bagProductVO.setP_price(35800);
		bagProductVO.setP_color("색상수정");
		log.info("modify result : " + bagProductService.modify(bagProductVO));	
	}
	
	@Test
	public void testDelete() {
		// 게시물 번호의 존재 여부 확인후 테스트필요
		log.info("remove result : " + bagProductService.remove(10));
	}
	

}
