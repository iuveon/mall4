package com.mall4.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mall4.domain.Criteria;
import com.mall4.domain.ReviewVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class ReviewMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ReviewMapper mapper;
	
	@Test
	public void testGetList() {
		
		mapper.getList().forEach(review -> log.info(review));
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(2);	// 2페이지
		cri.setAmount(10);	// 게시글 10개씩
		
		List<ReviewVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(review -> log.info(review));
	}
	
	@Test
	public void testInsert() {
		
		ReviewVO review = new ReviewVO();
		review.setB_title("mapper.testInsert() 테스트 제목");
		review.setB_content("mapper.testInsert() 테스트 내용");
		review.setB_writer("id3");
		
		mapper.insert(review);
		
		log.info("====== mapper.testInsert() 결과 ======");
		log.info(review);
	}
	
	@Test
	public void testRead() {
		
		ReviewVO review = mapper.read(5L);
		
		log.info("====== mapper.testRead() 결과 ======");
		log.info(review);
	}
	
	@Test
	public void testUpdate() {
		
		ReviewVO review = new ReviewVO();
		review.setB_num(5L);
		review.setB_title("mapper.testUpdate() 테스트 제목");
		review.setB_content("mapper.testUpdate() 테스트 내용");
		review.setB_writer("id1");
		
		log.info("====== mapper.testUpdate() 결과 ======");
		log.info("게시글 수정 성공시 결과값 1 -> " + mapper.update(review));
	}
	
	@Test
	public void testDelete() {
		
		log.info("====== mapper.testDelete() 결과 ======");
		log.info("게시글 삭제 성공시 결과값 1 -> " + mapper.delete(3L));
	}
}
