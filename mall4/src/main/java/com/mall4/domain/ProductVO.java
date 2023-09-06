package com.mall4.domain;

public class ProductVO {
	
	//field
	private String p_name;//상품명 // 당근숄더백/오이버킷백/호박쇼퍼백/귤미니백/가지크로스백
	private int p_price;//가격 //10000/15000/20000/25000/30000/35000
	private String p_quantity; // 수량/3
	private String p_cate; //카테고리 숄더백/버킷백/쇼퍼백/토드백/미니백/크로스백
	private String p_size;//사이즈/s/m/l
	private String p_desc;//상품설명 // 귀여운 당근모양 숄더백/ 오이그림 버킷백/ 호박처럼 큰 쇼퍼백/ 앙증맞은 귤미니백/ 길고 수납공간 좋은 가지크로스백
	private String p_color;//색상 // 주황/초록/주황/노랑/보라
	
	
	//constructor
	public ProductVO() {
		
	}//basic constructor
	
	
	//method
	//getter
	public String getP_name() {return p_name;}
	public int getP_price() {return p_price;}
	public String getP_quantity() {return p_quantity;}
	public String getP_cate() {return p_cate;}
	public String getP_size() {return p_size;}
	public String getP_desc() {return p_desc;}
	public String getP_color() {return p_color;}
	
	
	//setter
	public void setP_name(String p_name) {this.p_name = p_name;}
	public void setP_price(int p_price) {this.p_price = p_price;}
	public void setP_quantity(String p_quantity) {this.p_quantity = p_quantity;}
	public void setP_cate(String p_cate) {this.p_cate = p_cate;}
	public void setP_size(String p_size) {this.p_size = p_size;}
	public void setP_desc(String p_desc) {this.p_desc = p_desc;}
	public void setP_color(String p_color) {this.p_color = p_color;}
	
	
	
}
