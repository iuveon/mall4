package com.mall4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class HomeController {
	
	@RequestMapping(value = "/main") // http://localhost/main
	public String home() {
		log.info("========== main ==========");
		return "main"; // main 페이지로 접속
	}
	
}
