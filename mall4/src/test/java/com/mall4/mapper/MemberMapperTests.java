package com.mall4.mapper;

import java.util.List;

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
public class MemberMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Test // Junit의 테스트 메소드임을 명시
	public void testList() { // 회원 전체 리스트 가져오기
		List<MemberVO> list = mapper.getList();
		list.forEach(member -> log.info(member));
	}

	@Test
	public void testInfo() { // id를 이용하여 일치하는 회원 찾기 (마이페이지)
		String m_id = "testid9";
		MemberVO vo = mapper.info(m_id);
		log.info(vo);
	}
	
	@Test
	public void testInsert() { // 회원 가입
		MemberVO vo = new MemberVO();
		vo.setM_id("testid12");
		vo.setM_pw("1234");
		vo.setM_name("테스터조");
		vo.setM_email1("testerjo");
		vo.setM_email2("ez.com");
		vo.setM_phone("010-0000-0012");
		vo.setM_birth("");
		vo.setM_zipcode("");
		vo.setM_address1("");
		vo.setM_address2("");
		vo.setM_restAddress("");
		
		mapper.insert(vo);
	}
	
	@Test
	public void testUpdate() { // 회원 정보 수정
		String m_id = "testid10";
		MemberVO vo = mapper.info(m_id);
		vo.setM_birth("19910522");
		vo.setM_zipcode("12321");
		vo.setM_address1("경기도 수원시 매산로");
		vo.setM_address2("경기도 수원시 매산동");
		vo.setM_restAddress("EZ304");
		vo.setM_id(m_id);
		
		int count = mapper.update(vo);
		log.info("========== Mapper Test Update ==========" + count);
	}
	
	@Test
	public void testDelete() { // 회원 탈퇴
		String m_id = "testid8";
		MemberVO vo = mapper.info(m_id);
		mapper.delete(vo);
	}
	
	/*
	@Test
	public void testLogin() {
		String m_id = "testid11";
		String m_pw = "1234";
		MemberVO vo = mapper.login(m_id, m_pw);
		log.info(vo);
	}
	*/
	
}
