package com.mall4.service;

import java.util.List;

import com.mall4.domain.MemberVO;

public interface MemberService {
	
	public List<MemberVO> getList(); // 회원 전체 리스트 가져오기
	
	public MemberVO info(String m_id); // id를 이용하여 일치하는 회원 찾기 (마이페이지)
	
	public void insert(MemberVO member); // 회원 가입
	
	public int update(MemberVO member); // 회원 정보 수정
	
	public int delete(MemberVO member); // 회원 탈퇴

}
