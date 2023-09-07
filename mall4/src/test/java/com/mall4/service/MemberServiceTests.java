package com.mall4.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class) // 실행 테스트 클래스 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 참고할 설정 파일(<mybatis-spring:scan base-package="com.mall4.mapper"/>)
@Log4j2 // 신형 Log 사용
public class MemberServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	@Test
	public void testGetList() {
		service.getList().forEach(member -> log.info(member)); // 람다식을 이용하여 로그에 정보 출력
	}

}
