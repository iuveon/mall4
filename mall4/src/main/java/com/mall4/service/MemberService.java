package com.mall4.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mall4.domain.MemberVO;

public interface MemberService {
	
	public List<MemberVO> getList(); // 회원 전체 리스트 가져오기
	
	public MemberVO info(String m_id); // id를 이용하여 일치하는 회원 찾기 (마이페이지)
	
	public void insert(MemberVO member); // 회원 가입
	
	public boolean update(MemberVO member); // 회원 정보 수정
	
	public boolean delete(MemberVO member); // 회원 탈퇴
	
	// public MemberVO login(@Param("m_id") String m_id, @Param("m_pw") String m_pw); // 로그인

}
