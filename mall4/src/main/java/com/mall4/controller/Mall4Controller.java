package com.mall4.controller;

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
import com.mall4.domain.ProductVO;
import com.mall4.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/product/*")
@AllArgsConstructor
public class Mall4Controller {
	
	private ProductService service;
	
	
	
	
	@GetMapping("/list")
	public void list(Model model) {
		
		log.info("list");
		model.addAttribute("list", service.getList());
	}//전체목록
	
	
	
	
/*	@GetMapping("/get")
	public void get(@RequestParam("p_num") int p_num, Model model) {
		
		log.info("/get");
		model.addAttribute("productVO", service.get(p_num));
	}//선택목록
*/
	
	
/*	@GetMapping("/list")
	public void list(Criteria cri, Model model) {

		log.info("list: " + cri);
		model.addAttribute("list", service.getList(cri));
		// model.addAttribute("pageMaker", new PageDTO(cri, 123));

		int total = service.getTotal(cri);

		log.info("total: " + total);

		model.addAttribute("pageMaker", new PageDTO(cri, total));

	}
*/	
	
	
	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("p_num") int p_num, Model model) {

		log.info("/get or modify");
		model.addAttribute("productVO", service.get(p_num));
	}
	
	
	@PostMapping("/modify")
	public String modify(ProductVO productVO, RedirectAttributes rttr) {
		
		log.info("수정메서드" +productVO);
		
		if(service.modify(productVO)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/product/list";
	}//상품수정

	
	
	@PostMapping("/remove")
	public  String remove(@RequestParam("p_num") int p_num, RedirectAttributes rttr) {
		
		log.info("remove메서드"+p_num);
		
		if(service.remove(p_num)) {
			rttr.addAttribute("result", "success");
		}
		return "redirect:/product/list";
	}//상품 삭제
	
	@GetMapping("/remove")
	public void remove() {
		
	}
	
	
	
	@PostMapping("/register")
	public String register(ProductVO productVO, RedirectAttributes rttr) {

		log.info("register: " + productVO);

		service.register(productVO);

		rttr.addFlashAttribute("result", productVO.getP_num());

		return "redirect:/product/list";
	}//상품추가
	
	@GetMapping("/register")
	public void register() {
		
	}

	
}
