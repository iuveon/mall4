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
	public List<MemberVO> getList() { // 회원 전체 리스트 가져오기
		log.info("========== ServiceImpl.getList ==========");
		return mapper.getList();
	}

	@Override
	public MemberVO info(String m_id) { // id를 이용하여 일치하는 회원 찾기 (마이페이지)
		log.info("========== ServiceImpl.info ==========");
		return mapper.info(m_id);
	}

	@Override
	public void insert(MemberVO member) { // 회원 가입
		log.info("========== ServiceImpl.insert ==========");
		mapper.insert(member);
	}

	@Override
	public boolean update(MemberVO member) { // 회원 정보 수정
		log.info("========== ServiceImpl.update ==========");
		return mapper.update(member) == 1;
	}

	@Override
	public boolean delete(MemberVO member) { // 회원 탈퇴
		log.info("========== ServiceImpl.delete ==========");
		return mapper.delete(member) == 1;
	}

	/*
	@Override
	public MemberVO login(String m_id, String m_pw) { // 로그인
		log.info("========== ServiceImpl.login ==========");
		return mapper.login(m_id, m_pw);
	}
	*/

}
