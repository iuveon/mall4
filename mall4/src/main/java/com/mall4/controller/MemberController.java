package com.mall4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mall4.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Controller // 컨트롤러 역할임을 명시 (servlet-context.xml)
@Log4j2
@RequestMapping(value="/member") // http://localhost/member/메소드 처리 담당
public class MemberController {
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	@GetMapping("/list") // http://localhost/member/list
	public void list(Model model) {
		log.info("========== Controller.list ==========");
		model.addAttribute("list", service.getList());
		// MemberService의 getList() 메소드 실행 결과를 model 영역에 'list' 라는 이름으로 추가함
	} // list() 메소드 종료
	
} // class 종료