package com.mall4.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {

	private Long m_num;
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_email1;
	private String m_email2;
	private String m_phone;
	private String m_birth;
	private String m_zipcode;
	private String m_address1;
	private String m_address2;
	private String m_restAddress;
	private Date m_regdate;
}
