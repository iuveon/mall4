package com.mall4.mapper;

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
public class BagProductMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BagProductMapper bagProMapper;

	@Test // 전체목록 조회
	public void testGetList() {
		bagProMapper.getList().forEach(board -> log.info(board));
	}
	

	@Test// 인덱스 번호로 상품조회
	public void testRead() {
		BagProductVO bagProductVO1 = bagProMapper.read(21);
		BagProductVO bagProductVO2 = bagProMapper.read(25);
		log.info(bagProductVO1);
		log.info(bagProductVO2);
	}

	@Test
	public void testInsert() {

		BagProductVO bagProductVO = new BagProductVO();

		bagProductVO.setP_name("샤인머스캣백팩");
		bagProductVO.setP_price(28000);
		bagProductVO.setP_quantity(4);
		bagProductVO.setP_cate("백백");
		bagProductVO.setP_size("L");
		bagProductVO.setP_desc("방울방울");
		bagProductVO.setP_color("연두");

		bagProMapper.insert(bagProductVO);
		log.info(bagProductVO);
	}// 상품추가
	@Test
	public void testInsertSelectKey() {

		BagProductVO bagProductVO = new BagProductVO();

		bagProductVO.setP_name("포도미니백");
		bagProductVO.setP_price(15000);
		bagProductVO.setP_quantity(8);
		bagProductVO.setP_cate("미니백");
		bagProductVO.setP_size("S");
		bagProductVO.setP_desc("데일리로 매칭하기 좋은 베이직템");
		bagProductVO.setP_color("보라");

		bagProMapper.insertSelectKey(bagProductVO);
		log.info(bagProductVO);
	}// 상품추가

	@Test
	public void testUpdate() {

		BagProductVO bagProductVO = new BagProductVO();
		bagProductVO.setP_num(21);
		bagProductVO.setP_quantity(10);
		bagProductVO.setP_color("노랑주황");
		bagProductVO.setP_price(18000);

		int count = bagProMapper.update(bagProductVO);
		log.info("업데이트된 상품개수: " + count);
	}// 상품수정

	@Test
	public void testDelete() {

		log.info("삭제된 상품 개수: " + bagProMapper.delete(28));

	}// 상품삭제
}
