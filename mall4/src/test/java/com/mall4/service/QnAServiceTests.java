package com.mall4.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2

public class QnAServiceTests {
	
	   @Setter(onMethod_ = @Autowired)
	   private QnAService service; 
	   
	   @Test
	   public void testExist() {
		      
		      log.info("====== service.testExist() 결과 ======");
		      log.info(service);
		      assertNotNull(service);
		   }
	   
	   @Test
	   public void testGetList() {
	       service.getList().forEach(review -> log.info(review));
	      //service.getList(new Criteria(2, 10)).forEach(review -> log.info(review));
	   }



}
