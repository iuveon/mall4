package com.mall4.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	
	   private Long m_num;				// Member 번호 (seq_member_num 시퀀스 사용)
	   private String m_id;					// 아이디
	   private String m_pw;				// 비밀번호
	   private String m_name;				// 이름
	   private String m_email1;			// 메일주소(아이디)
	   private String m_email2;			// 메일주소(도메인)
	   private String m_phone;			// 연락처
	   private String m_birth;				// 생년월일
	   private String m_zipcode;			// 우편번호
	   private String m_address1;		// 도로명 주소
	   private String m_address2;		// 지번 주소
	   private String m_restAddress;		// 상세 주소
	   private Date m_regdate;			// 가입일

}
