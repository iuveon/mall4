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
import org.springframework.web.context.WebApplicationContext;


import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j2
public class BagProductControllerTests {
	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	//가짜 mvc임 - 가짜로 url과 파라미터등을 브라우저에서
	//사용하는것처럼 만들어서 controller를 실행해 볼 수 있음
	
	/*
	 * @Before // Before - 모든 테스트전에 매번 실행되는 메서드임 public void setsup() { //import시
	 * JUnit이용해야함 this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build(); }
	 */
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception{
		//MockMvcRequestBuilders를 이용해 get방식을 호출
		// 이후 BagProductController의 getlist()에서 반환된 결과를 이용해서
		//model에 어떤 데이터들이 담겨잇는지 확인
		// tocat을 통해 실행되는 방식이 아니므로 기존의 테스트코드를 실행하는것과 동일하게 실행함
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/bag/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	@Test
	public void testGet() throws Exception{
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/bag/get")
						.param("p_num", "11"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	@Test
	public void testRegister() throws Exception{
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/bag/register")
				.param("p_name", "아스파라거스백")
				.param("p_price", "15000")
				.param("p_quantity","1" )
				.param("p_cate", "슬링백")
				.param("p_size", "L")
				.param("p_desc", "샐러드가 생각나는 초록초록 여름한정판")
				.param("p_color", "초록")
				).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	
	@Test
	public void testModify() throws Exception{
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/bag/modify")
				.param("p_num", "11")
				.param("p_price", "15000")
				.param("p_quantity","1" )
				.param("p_color", "초록test")
				).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	
	@Test
	public void testRemove() throws Exception{
		//삭제 전 게시물번호 존재여부 확인필요
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/bag/remove")
				.param("p_num", "12")
				).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	
	
	
}
