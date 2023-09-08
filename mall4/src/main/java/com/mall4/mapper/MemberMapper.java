package com.mall4.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mall4.domain.MemberVO;

public interface MemberMapper {
	
	public List<MemberVO> getList(); // 회원 전체 리스트 가져오기
	
	public MemberVO info(String m_id); // id를 이용하여 일치하는 회원 찾기 (마이페이지)
	
	public void insert(MemberVO member); // 회원 가입
	
	public int update(MemberVO member); // 회원 정보 수정
	
	public int delete(MemberVO member); // 회원 탈퇴
	
	// public MemberVO login(@Param("m_id") String m_id, @Param("m_pw") String m_pw); // 로그인
	// 파라미터 값을 여러 개 받기 때문에 @Param 어노테이션을 이용하여 mapping

}
