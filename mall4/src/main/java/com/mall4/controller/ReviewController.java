package com.mall4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mall4.domain.Criteria;
import com.mall4.domain.PageDTO;
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
//	@GetMapping("/list")
//	public void list(Model model) {
//		model.addAttribute("list", service.getList());
//	}
	
	// 전체 게시글 목록 조회 (페이징)
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 146));
	}
	
	// 새 게시글 추가 (페이지 확인용)
	@GetMapping("/register")
	public void register() {
		
	}
	
	// 새 게시글 추가
	@PostMapping("/register")
	public String register(ReviewVO review, RedirectAttributes rttr) {
		service.register(review);
		rttr.addFlashAttribute("result", "새 게시글 번호" + review.getB_num());	// 등록된 게시글 번호를 함께 전달
		
		return "redirect:/review/list";
	}
	
	// 게시글 내용 조회
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("b_num") Long b_num, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("review", service.get(b_num));
	}
	
	// 게시글 수정
	@PostMapping("/modify")
	public String modify(ReviewVO review, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("수정할 게시글 내용 -> " + review);
		
		if(service.modify(review)) {
			rttr.addAttribute("result", "게시글 내용 수정 성공");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/review/list";
	}
	
	// 게시글 삭제
	@PostMapping("/remove")
	public String remove(@RequestParam("b_num") Long b_num, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("삭제할 게시글 번호 -> " + b_num);
		
		if(service.remove(b_num)) {
			rttr.addFlashAttribute("result", "게시글 내용 삭제 성공");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/review/list";
	}
}
