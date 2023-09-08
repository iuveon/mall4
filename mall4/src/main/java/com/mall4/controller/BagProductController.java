package com.mall4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mall4.domain.BagProductVO;
import com.mall4.service.BagProductService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/bag/*")
@Log4j2
@AllArgsConstructor
public class BagProductController {
	
	private BagProductService bagProductService;   
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list",bagProductService.getList());
		
	}
	
	
	 @PostMapping("/register") public String register(BagProductVO
	 bagProductVO, RedirectAttributes rttr) { // 작업이 끝난후 다시 목록화면으로 이동하기 위해 //
	 //register()를 String 타입으로 지정 RedirectAttributes를 파라미터로 지정 // 추가적으로 새롭게 등록된 상품의
	 //번호를 같이 전달하기위해 RedirectAttributes를 이용 // 리턴시 redirect: 접두어 사용 - 스프링 mvc가 내부적으로
	 //response.sendRedirect()를 처리해주기때문에 log.info("register : " + bagProductVO);
	 bagProductService.register(bagProductVO);
	 rttr.addFlashAttribute("result",bagProductVO.getP_num() ); return
	 "redirect:/bag/list"; }
	 
	@GetMapping
	public void register() {
		
	}
	
	@GetMapping("/get")
	//p_num값을 명시적으로 처리하는 RequestParam을 이용해서 지정
	public void get(@RequestParam("p_num") Integer p_num, Model model) {
		log.info("get");
		model.addAttribute("bagProductVO",bagProductService.get(p_num));
	}
	
	@PostMapping("/modify")
	public String modify(BagProductVO bagProductVO, RedirectAttributes rttr) {
		log.info("modify"+bagProductVO);
		if(bagProductService.modify(bagProductVO)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/bag/modify";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("p_num") Integer p_num, RedirectAttributes rttr) {
		log.info("remove"+p_num);
		if(bagProductService.remove(p_num)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/bag/list";
	}
	
	
}
