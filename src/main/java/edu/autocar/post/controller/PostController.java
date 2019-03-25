package edu.autocar.post.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.autocar.cmmn.domain.FileInfo;
import edu.autocar.post.model.FileVO;
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
		
		FileVO file = service.selectFile(postId);
		
		model.addAttribute("file",file);
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
		
		return "post/edit.view";
	}
	
	@PostMapping("/{blogId}/edit/{postId}")
	public String edit( @PathVariable int blogId, @PathVariable int postId, @Valid PostVO postVO,
			@RequestParam("file") MultipartFile file,
			BindingResult result) throws Exception {
		
		postVO.setBlogId(blogId);
		if(result.hasErrors()) {
			log.info("Fail to bind a result.");
			return "post/edit";
		}
		service.updatePost(postVO);
		service.deleteFile(postId);
		
		FileVO vo = new FileVO(0, postId, "", file.getOriginalFilename(), file.getBytes(), null,null);
		service.insertFile(vo);
		
		return "redirect:/{blogId}/view/"+postId;
	}
	
	@ResponseBody
	@DeleteMapping("/{blogId}/delete/{postId}")
	public ResponseEntity<Map<String,String>> delete( @PathVariable int blogId, @PathVariable int postId) throws Exception {
		
		Map<String, String> map = new HashMap<>();
		
		int res = service.deletePost(blogId, postId);
		
		if(res > 0) {
			map.put("result","success");
		}
		else {
			map.put("result","fail");
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		return new ResponseEntity<Map<String, String>>(
		map, headers, HttpStatus.OK);
	}
	
	@GetMapping("/download/{postId}")
	public String download(@PathVariable int postId, Model model) throws Exception {
		//FileInfo fi = service.getFileInfo(imageId);
		//model.addAttribute("fileInfo", fi);
		return "download";
	}
	
	
}
