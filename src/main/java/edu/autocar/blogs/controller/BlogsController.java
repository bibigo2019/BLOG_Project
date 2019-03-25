package edu.autocar.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import edu.autocar.blogs.model.BlogsVO;
import edu.autocar.blogs.service.BlogsService;
import edu.autocar.cmmn.domain.PageInfo;
import edu.autocar.post.model.PostVO;
import edu.autocar.post.service.PostService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BlogsController {
	
	@Autowired 
	BlogsService service;
	
	@Autowired
	PostService postService;
	 
	@GetMapping("/")
	public String list(Model model, @RequestParam(value="page", defaultValue="1") int page) throws Exception {
		PageInfo<BlogsVO> pi = service.getPage(page);
		log.info(pi.toString());
		model.addAttribute("pi",pi);
		
		return "blogs/list";
	}

	@GetMapping("/{blogId}/list")
	public String view(@PathVariable int blogId, Model model, @RequestParam(value="page", defaultValue="1") int page) throws Exception {
		PageInfo<PostVO> pi = postService.getPage(blogId, page);
		log.info(pi.toString());
		model.addAttribute("pi",pi);
		
		return "blogs/view";
	}
}
