package com.mall4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall4.domain.BagProductVO;
import com.mall4.mapper.BagProductMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service // 비지니스영역을 담당하는 객체임을 표시
@AllArgsConstructor
public class BagProductServiceImpl implements BagProductService{
	
	
	private BagProductMapper bagProductMapper;
	
	@Override
	public void register(BagProductVO bagProductVO) {
		// 게시물추가 
		log.info("register.." + bagProductVO );
		bagProductMapper.insertSelectKey(bagProductVO);
		
	}

	@Override
	public BagProductVO get(int p_num) {
		// 특정 게시물가져오기
		log.info("get" + p_num);
		return bagProductMapper.read(p_num);
		
	}

	@Override
	public boolean modify(BagProductVO bagProductVO) {
		// 수정
		log.info("modify.." + bagProductVO );
		return bagProductMapper.update(bagProductVO) == 1;
	}

	@Override
	public boolean remove(int p_num) {
		// 삭제
		log.info("remove.." + p_num );
		return bagProductMapper.delete(p_num) == 1;
	}

	@Override
	public List<BagProductVO> getList() {
		// 전체리스트
		log.info("getList");
		return bagProductMapper.getList();
	}

}
