package com.mall4.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mall4.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class) // 실행 테스트 클래스 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 참고할 설정 파일(<mybatis-spring:scan base-package="com.mall4.mapper"/>)
@Log4j2 // 신형 Log 사용
public class MemberServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	@Test
	public void testGetList() { // 회원 전체 리스트 가져오기
		service.getList().forEach(member -> log.info(member)); // 람다식을 이용하여 로그에 정보 출력
	}
	
	@Test
	public void testInfo() { // id를 이용하여 일치하는 회원 찾기 (마이페이지)
		service.info("testid4");
	}
	
	@Test
	public void testInsert() { // 회원 가입
		MemberVO vo = new MemberVO();
		vo.setM_id("testid13");
		vo.setM_pw("1234");
		vo.setM_name("테스터조");
		vo.setM_email1("testerzo");
		vo.setM_email2("ez.com");
		vo.setM_phone("010-0000-0013");
		vo.setM_birth("20000304");
		vo.setM_zipcode("");
		vo.setM_address1("");
		vo.setM_address2("");
		vo.setM_restAddress("");
		
		service.insert(vo);
	}
	
	@Test
	public void testUpdate() { // 회원 정보 수정
		String m_id = "testid2";
		MemberVO vo = service.info(m_id);
		vo.setM_birth("20200202");
		vo.setM_zipcode("11111");
		vo.setM_address1("경기도 수원시 매산로");
		vo.setM_address2("경기도 수원시 매산동");
		vo.setM_restAddress("EZ304");
		vo.setM_id(m_id);
		
		log.info("========== Service.update ========== " + service.update(vo));
	}
	
	@Test
	public void testDelete() { // 회원 탈퇴
		String m_id = "testid4";
		MemberVO vo = service.info(m_id);
		log.info("========== Service.delete ========== " + service.delete(vo));
	}
	
	/*
	@Test
	public void testLogin() { // 로그인
		service.login("testid11", "1234");
	}
	*/

}
