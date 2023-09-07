package com.mall4.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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
	
	@GetMapping("/info") // http://localhost/member/info
	public void info(@RequestParam("m_id") String m_id, Model model) {
		log.info("========== Controller.info ==========");
		model.addAttribute("info", service.info(m_id));
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
	
	/*
	@PostMapping("/login") // http://localhost/member/login
	public ModelAndView login(@RequestParam("m_id") String m_id, @RequestParam("m_pw") String m_pw, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// @ModelAttribute("member") MemberVO vo : 전송된 ID와 PW를 MemberVO 객체로 바인딩
		ModelAndView mav = new ModelAndView();
		
		vo = service.login(m_id, m_pw); // MemberVO 객체로 로그인 정보 저장
		
		if(vo != null) { // vo 객체가 null이 아니라면 (로그인 성공)
			HttpSession session = request.getSession();
			session.setAttribute("member", vo); // 세션 영역에 회원 정보 저장
			session.setAttribute("isLogOn", true); // 세션 영역에 로그인 상태를 true로 설정
			mav.setViewName("redirect:/main");
		} else { // 로그인 실패
			rAttr.addAttribute("result", "loginFailed"); // 실패 메세지 전달(key, value)
			mav.setViewName("redirect:/member/login"); // 다시 로그인 창으로 리다이렉트
		}
		
		return mav;
	}
	*/
	
} // class 종료