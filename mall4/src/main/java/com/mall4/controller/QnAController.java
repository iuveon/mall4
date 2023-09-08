package com.mall4.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mall4.domain.QnAVO;
import com.mall4.service.QnAService;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Controller
@Log4j2
@RequestMapping("/board/*")

	
	public class QnAController {
	@Setter(onMethod_ = @Autowired)
	   private QnAService service;
	
	
	// 전체 게시글 목록 조회
  @GetMapping("/list")
  public void list(Model model) {
     model.addAttribute("list", service.getList());
 }
  
  // 새 게시글 추가
  @PostMapping("/register")
  public String register(QnAVO review, RedirectAttributes rttr) {
     service.register(review);
     rttr.addFlashAttribute("result", "새 게시글 번호" + review.getB_num());   // 등록된 게시글 번호를 함께 전달
     
     return "redirect:/board/list";
  }
  
  
  // 게시글 내용 조회
  @GetMapping({"/get", "/modify"})
  public void get(@RequestParam("b_num") Long b_num,  Model model) {
     model.addAttribute("review", service.get(b_num));
  }
  
  // 게시글 수정
  @PostMapping("/modify")
  public String modify(QnAVO review,RedirectAttributes rttr) {
     log.info("수정할 게시글 내용 -> " + review);
     
     if(service.modify(review)) {
        rttr.addFlashAttribute("result", "게시글 내용 수정 성공");
     }
     
     
     return "redirect:/board/list" ;
  }
  
  // 게시글 삭제
  @PostMapping("/remove")
  public String remove(@RequestParam("b_num") Long b_num,  RedirectAttributes rttr) {
     log.info("삭제할 게시글 번호 -> " + b_num);
     
     if(service.remove(b_num)) {
        rttr.addFlashAttribute("result", "게시글 내용 삭제 성공");
     }
     
      return "redirect:/board/list" ;
  }

 
 
	   

	}

