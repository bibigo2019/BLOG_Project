package edu.autocar.blogs.controller;

import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.autocar.blogs.model.BlogPostVO;
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
	
	@Autowired
	ServletContext context;
	
	@GetMapping("/")
	public String list(Model model, @RequestParam(value="page", defaultValue="1") int page) throws Exception {
		
		List<BlogPostVO> recommend = service.selectRandomPosts(5);
		List<BlogPostVO> blogs = service.selectRandomBlogs();
		
		model.addAttribute("recommend",recommend);
		model.addAttribute("blogs",blogs);
		
		return "blogs/list";
	}
	
	@GetMapping("/image/{blogId}")
	@ResponseBody
	public ResponseEntity<byte[]> getImage(@PathVariable int blogId) throws Exception {
		byte[] images = null;
		HttpStatus status = HttpStatus.OK;

		try {
			BlogsVO blog = service.selectBlogInfo(blogId);
			images = blog.getImg();
			
			if(images == null) {
				InputStream in = context.getResourceAsStream("resources/images/blog_default.jpg");
				images = IOUtils.toByteArray(in);
			}
			
		} catch (Exception e) {
			status = HttpStatus.NOT_FOUND;
			log.error("[ERROR]",e);
		}
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(images, headers, status);
	}

	@GetMapping("/{blogId}/list")
	public String view(@PathVariable int blogId, Model model, @RequestParam(value="page", defaultValue="1") int page) throws Exception {
		PageInfo<PostVO> pi = postService.getPage(blogId, page);
		List<PostVO> recommend = postService.selectTopPost(blogId, 2);
		log.info(pi.toString());
		model.addAttribute("pi",pi);
		model.addAttribute("recommend", recommend);
		
		return "blogs/view";
	}
}
