package edu.autocar.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/blogs")
public class BlogsController {
	/*
	 * @Autowired SampleService service;
	 */
	@GetMapping("/")
	public String main(Model model) throws Exception {
		return "blogs/main";
	}
	
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		return "blogs/list";
	}

}
