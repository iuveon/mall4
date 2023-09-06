package com.mall4.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
		
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		
		ReviewVO board = new ReviewVO();
		board.setB_title("mapper.testInsert() 테스트 제목");
		board.setB_content("mapper.testInsert() 테스트 내용");
		board.setB_writer("id3");
		
		mapper.insert(board);
		
		log.info("====== mapper.testInsert() 결과 ======");
		log.info(board);
	}
	
	@Test
	public void testRead() {
		
		ReviewVO board = mapper.read(5L);
		
		log.info("====== mapper.testRead() 결과 ======");
		log.info(board);
	}
	
	@Test
	public void testUpdate() {
		
		ReviewVO board = new ReviewVO();
		board.setB_num(5L);
		board.setB_title("mapper.testUpdate() 테스트 제목");
		board.setB_content("mapper.testUpdate() 테스트 내용");
		board.setB_writer("id1");
		
		log.info("====== mapper.testUpdate() 결과 ======");
		log.info("게시글 수정 성공시 결과값 1 -> " + mapper.update(board));
	}
	
	@Test
	public void testDelete() {
		
		log.info("====== mapper.testDelete() 결과 ======");
		log.info("게시글 삭제 성공시 결과값 1 -> " + mapper.delete(3L));
	}
}
