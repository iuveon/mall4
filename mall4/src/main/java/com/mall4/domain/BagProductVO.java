package com.mall4.domain;

import lombok.Data;

@Data
public class BagProductVO {
	//field
	private int p_num;
	//상품번호(의류/가방 상품번호 통일시킴)
	private String p_name;
	//상품명 // 당근숄더백/오이버킷백/호박쇼퍼백/귤미니백/가지크로스백/수박백팩
	private int p_price;
	//가격 //10000/15000/20000/25000/30000/35000
	private int p_quantity; 
	// 수량/3
	private String p_cate;
	//카테고리 숄더백/버킷백/쇼퍼백/토드백/미니백/크로스백
	private String p_size;
	//사이즈/s/m/l
	private String p_desc;
//상품설명 // 귀여운 당근모양 숄더백/ 오이그림 버킷백/ 호박처럼 큰 쇼퍼백/ 앙증맞은 귤미니백/ 길고 수납공간 좋은 가지크로스백
	private String p_color;
	//색상 // 주황/초록/주황/노랑/보라
	
	
	
	
}
