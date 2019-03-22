package edu.autocar.post.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.autocar.post.model.PostVO;
import edu.autocar.post.service.PostService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PostController {
	@Autowired
	PostService service;
	
	@GetMapping("/{blogId}/view/{postId}")
	public String view(HttpServletRequest request, @PathVariable int blogId, @PathVariable int postId, Model model) throws Exception {
		
		PostVO vo = service.selectPost(blogId,postId);
		
		
		model.addAttribute("post",vo);
		model.addAttribute("blogId",blogId);
		model.addAttribute("postId",postId);
		log.debug("get post");
		return "post/view";
	}
	
	@GetMapping("/{blogId}/write")
	public String write(PostVO postVO, @PathVariable int blogId, Model model) throws Exception {
		return "post/write";
	}
	
	@PostMapping("/{blogId}/write")
	public String create( @PathVariable int blogId, @Valid PostVO postVO, BindingResult result) throws Exception {
		
		postVO.setBlogId(blogId);
		
		if(result.hasErrors()) {
			log.info("Fail to bind a result.");
			return "post/write";
		}
		service.insertPost(postVO);
		
		long postId = postVO.getPostId();
		
		return "redirect:/{blogId}/view/"+postId;
	}
	
	@GetMapping("/{blogId}/edit/{postId}")
	public String edit(PostVO postVO, @PathVariable int blogId, @PathVariable int postId, Model model) throws Exception {
		
		postVO = service.selectPost(blogId,postId);
		model.addAttribute("post",postVO);
		
		return "post/edit";
	}
	
	@PostMapping("/{blogId}/edit/{postId}")
	public String edit( @PathVariable int blogId, @PathVariable int postId, @Valid PostVO postVO, BindingResult result) throws Exception {
		
		postVO.setBlogId(blogId);
		if(result.hasErrors()) {
			log.info("Fail to bind a result.");
			return "post/edit";
		}
		service.updatePost(postVO);
		
		return "redirect:/{blogId}/view/"+postId;
	}
	
	@GetMapping("/{blogId}/delete/{postId}")
	public String delete( @PathVariable int blogId, @PathVariable int postId) throws Exception {
		
		service.deletePost(blogId, postId);
		
		return "redirect:/";
	}
	
}
