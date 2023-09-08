package com.mall4.mapper;

import java.util.List;



import com.mall4.domain.QnAVO;



public interface QnAMapper {
	
	/* @Select("select * from QnA_board") */
		public List<QnAVO> getList();//sql을 이용하여 List반환용
		
		public void insert(QnAVO board);
		/* public void insertSelectKey(QnAVO board); */

		public QnAVO read(Long b_num); // 번호를 이용하여 게시물 찾기 
		public int delete(Long b_num); 
		public int update(QnAVO board); 

	}



