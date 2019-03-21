package edu.autocar.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.autocar.sample.service.SampleService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SampleController {
	@Autowired
	SampleService service;
	
	@GetMapping("/sample")
	public String view(Model model) throws Exception {
		return "sample/sample";
	}
}
