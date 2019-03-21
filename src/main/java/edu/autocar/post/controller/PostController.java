package edu.autocar.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.autocar.sample.service.SampleService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PostController {
	@Autowired
	SampleService service;
	
	@GetMapping("/blogs/{userId}/view/{postId}")
	public String view(Model model) throws Exception {
		return "sample/sample";
	}
}
