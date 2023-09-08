package com.mall4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall4.domain.QnAVO;
import com.mall4.mapper.QnAMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2

public class QnAServiceImpl implements QnAService{
	
	@Setter(onMethod_ = @Autowired)
	   private QnAMapper mapper;

	
	
	
	@Override
	public List<QnAVO> getList() {
		 return mapper.getList();
	}

	@Override
	public void register(QnAVO review) {
		 mapper.insert(review);
		
	}

	@Override
	public QnAVO get(Long b_num) {
		 return mapper.read(b_num);
}

	@Override
	public boolean modify(QnAVO review) {
		 return mapper.update(review) == 1;

	}

	@Override
	public boolean remove(Long b_num) {
		 return mapper.delete(b_num) == 1;

	}
	
	

}
