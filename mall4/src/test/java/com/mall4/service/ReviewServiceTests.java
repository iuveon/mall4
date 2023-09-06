package com.mall4.service;

import static org.junit.Assert.assertNotNull;

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
public class ReviewServiceTests {

	@Setter(onMethod_ = @Autowired)
	private ReviewService service;
	
	@Test
	public void testExist() {
		
		log.info("====== service.testExist() 결과 ======");
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testRegister() {
		ReviewVO board = new ReviewVO();
		board.setB_title("service.testRegister() 테스트 제목");
		board.setB_content("service.testRegister() 테스트 내용");
		board.setB_writer("id3");
		
		service.register(board);
		
		log.info("====== service.testRegister() 결과 ======");
		log.info("생성된 게시물 번호 -> " + board.getB_num());
	}
	
	@Test
	public void testGet() {
		log.info("====== service.testGet() 결과 ======");
		log.info(service.get(2L));
	}
	
	@Test
	public void testUpdate() {
		ReviewVO board = service.get(2L);
		
		if(board == null) return;
		
		board.setB_title("service.testUpdate() 테스트 제목");
		
		log.info("====== service.testUpdate() 결과 ======");
		log.info("게시글 수정 성공시 결과값 true -> " + service.modify(board));
	}
	
	@Test
	public void testDelete() {
		log.info("게시글 삭제 성공시 결과값 true -> " + service.remove(7L));
	}
	
}
