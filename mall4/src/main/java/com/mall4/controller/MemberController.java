package com.mall4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mall4.domain.MemberVO;
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
	
	/*
	@GetMapping("/info") // http://localhost/member/info
	public void info(@RequestParam("m_id") String m_id, Model model) {
		log.info("========== Controller.info ==========");
		model.addAttribute("info", service.info(m_id));
	}
	*/
	
	@GetMapping({"/info", "/update"}) // http://localhost/board/info?m_id=*
	public void info(@RequestParam("m_id") String m_id, Model model) {
		log.info("======= get/update 메소드 호출 =======");
		model.addAttribute("member", service.info(m_id));
	}
	
	@PostMapping("/insert") // http://localhost/member/insert
	public String insert(MemberVO vo, RedirectAttributes rttr) {
		// String으로 반환 타입을 지정하면 반환 값을 View name으로 간주
		log.info("========== Controller.insert ==========");
		service.insert(vo);
		rttr.addFlashAttribute("message", "회원 가입을 축하합니다.");
		
		return "redirect:/main"; // 처리 후 main 페이지로 이동
		// redirect 접두어를 사용하여 response.sendRedirect() 처리
	}
	
	@PostMapping("/update") // http://localhost/member/update
	public String update(MemberVO vo, RedirectAttributes rttr) {
		log.info("========== Controller.update ==========");
		if(service.update(vo)) { // service.update(vo) 처리 결과가 boolean 타입이므로
			// true 일 때 = 회원 정보 수정 성공
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/member/list"; // 처리 후 list(회원 정보) 페이지로 이동
	}
	
	@PostMapping("/delete") // http://localhost/member/delete
	public String delete(MemberVO vo, RedirectAttributes rttr) {
		log.info("========== Controller.delete ==========");
		if(service.delete(vo)) { // true일 때 = 회원 탈퇴 성공
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/member/list"; // 처리 후 list(회원 정보) 페이지로 이동
	}
	
} // class 종료