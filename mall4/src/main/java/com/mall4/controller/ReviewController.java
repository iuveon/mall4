package com.mall4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mall4.domain.ReviewVO;
import com.mall4.service.ReviewService;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/review/*")
public class ReviewController {

	@Setter(onMethod_ = @Autowired)
	private ReviewService service;
	
	// 전체 게시글 목록 조회
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", service.getList());
	}
	
	// 새 게시글 추가
	@PostMapping("/register")
	public String register(ReviewVO review, RedirectAttributes rttr) {
		service.register(review);
		rttr.addFlashAttribute("result", "새 게시글 번호" + review.getB_num());	// 등록된 게시글 번호를 함께 전달
		
		return "redirect:/review/list";
	}
	
	// 게시글 내용 조회
	@GetMapping("/get")
	public void get(@RequestParam("b_num") Long b_num, Model model) {
		model.addAttribute("review", service.get(b_num));
	}
	
	@PostMapping("/modify")
	public String modify(ReviewVO review, RedirectAttributes rttr) {
		log.info("게시글 수정 -> " + review);
		
		if(service.modify(review)) {
			rttr.addAttribute("result", "게시글 내용 수정");
		}
		
		return "redirect:/review/list";
	}
}
