package com.xin.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	  @GetMapping("/")
	  public String inde() {
		  return "index";
	  }
}
