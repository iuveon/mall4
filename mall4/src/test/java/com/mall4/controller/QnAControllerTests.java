package com.mall4.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration   // 컨트롤러 테스트 어노테이션
@ContextConfiguration({
   "file:src/main/webapp/WEB-INF/spring/root-context.xml",               // 서비스 컴포넌트 스캔 경로
   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"   // 컨트롤러 컴포넌트 스캔 경로
   })
@Log4j2

public class QnAControllerTests {
	
	@Setter(onMethod_ = @Autowired)
	   private WebApplicationContext ctx;
	
	// 가상 MVC 변수 선언
	   private MockMvc mockMvc;
	   
	   @Before
	   public void setup() {
	      this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	   }
	   
	   
	   @Test
	   public void testList() throws Exception {
      log.info(
	         mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
	         .andReturn().getModelAndView().getModelMap());
	   }
	   
	   
	   
	   
	   
	   
	   @Test
	   public void testRegister() throws Exception {
	      
	      String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
	         .param("b_item", "controller.testRegister() 테스트 제목")
	         .param("b_title", "controller.testRegister() 테스트 내용")
	         .param("b_writer", "id1"))
	            .andReturn().getModelAndView().getViewName();
	      
	      log.info("====== controller.testRegister() 결과 ======");
	      log.info(resultPage);
	   }
	   
	   
	   @Test
	   public void testGet() throws Exception {
	      
	      ModelMap resultPage = mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
	            .param("b_num", "9"))
	            .andReturn().getModelAndView().getModelMap();
	      
	      log.info("====== controller.testGet() 결과 ======");
	      log.info(resultPage);
	   }
	   
	   @Test
	   public void testModify() throws Exception {
	      
	      String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
	            .param("b_num", "9")
	            .param("b_item", "controller.testModify() 테스트상품 ")
	            .param("b_title", "controller.testModify() 테스트제목")
	            .param("b_writer", "id1"))
	            .andReturn().getModelAndView().getViewName();
	      
	      log.info("====== controller.testModify() 결과 ======");
	      log.info(resultPage);
	   }
	   
	   @Test
	   public void testRemove() throws Exception {
	      String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
	            .param("b_num", "9"))
	            .andReturn().getModelAndView().getViewName();
	      
	      log.info("====== controller.testRemove() 결과 ======");
	      log.info(resultPage);
	   }



	 


}
