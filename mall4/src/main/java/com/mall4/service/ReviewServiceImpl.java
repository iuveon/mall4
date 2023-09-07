package com.mall4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall4.domain.Criteria;
import com.mall4.domain.ReviewVO;
import com.mall4.mapper.ReviewMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ReviewServiceImpl implements ReviewService {

	@Setter(onMethod_ = @Autowired)
	private ReviewMapper mapper;

//	@Override
//	public List<ReviewVO> getList() {
//		return mapper.getList();
//	}
	
	@Override
	public List<ReviewVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public void register(ReviewVO review) {
		mapper.insert(review);
	}

	@Override
	public ReviewVO get(Long b_num) {
		return mapper.read(b_num);
	}

	@Override
	public boolean modify(ReviewVO review) {
		return mapper.update(review) == 1;
	}

	@Override
	public boolean remove(Long b_num) {
		return mapper.delete(b_num) == 1;
	}
	
	
}
