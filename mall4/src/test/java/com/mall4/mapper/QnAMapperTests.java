package com.mall4.mapper;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mall4.domain.QnAVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2

public class QnAMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private QnAMapper mapper;
	
	//테스트 메서드 
	@Test
	public void testGetList() {
		
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void TestInsert() {
		
		QnAVO board = new QnAVO();
		board.setB_item("새로운 상품");
		board.setB_title("새로 작성하는 글");
		board.setB_writer("새로운 작성자"); 
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	/*
	 * @Test public void TestInsertSelectKey() { QnAVO board = new QnAVO();
	 * board.setB_item("새로운 상품 select key"); board.setB_title("새로작성한 글 select key");
	 * board.setB_writer("새로운 작성자 ..");
	 * 
	 * mapper.insertSelectKey(board);
	 * 
	 * log.info(board); }
	 */
	@Test
	public void testRead() {
		
		QnAVO board = mapper.read(1L);
		
		log.info(board);
	}
	
	
	
	@Test
	public void testDelete() {
		log.info("삭제 개수 : " +mapper.delete(1L));
	}
	
	@Test
	public void testUpdate() {
		QnAVO board = new QnAVO();
		
		board.setB_num(2);
		board.setB_item("수정된 상품");
		board.setB_title("수정된 제목");
		board.setB_writer("수정한 사람");
		
		int count = mapper.update(board);
		log.info("수정된 게시물 수 : " +count );
	}
}
