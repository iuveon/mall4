package com.mall4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall4.domain.MemberVO;
import com.mall4.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2 // 콘솔 로그 출력용
@Service // Service 계층을 명시적으로 나타냄
public class MemberServiceImpl implements MemberService { // MemberService 인터페이스의 구현 클래스
	
	// 필드
	@Setter(onMethod_ = @Autowired) // 생성자 주입
	private MemberMapper mapper; // 객체 생성
	
	// 메소드
	@Override
	public List<MemberVO> getList() {
		log.info("========== ServiceImpl.getList ==========");
		return mapper.getList();
	}

	@Override
	public MemberVO info(String m_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(MemberVO member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}

}
