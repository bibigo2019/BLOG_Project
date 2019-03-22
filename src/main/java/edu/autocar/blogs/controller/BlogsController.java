package edu.autocar.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BlogsController {
	/*
	 * @Autowired SampleService service;
	 */
	@GetMapping("/")
	public String main(Model model) throws Exception {
		return "blogs/list";
	}
	
	@GetMapping("/{userId}/list")
	public String list(Model model) throws Exception {
		return "blogs/view";
	}
}
