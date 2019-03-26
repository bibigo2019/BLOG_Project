package edu.autocar.blogs.controller;

import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.autocar.blogs.model.BlogPostVO;
import edu.autocar.blogs.model.BlogsVO;
import edu.autocar.blogs.service.BlogsService;
import edu.autocar.cmmn.domain.PageInfo;
import edu.autocar.cmmn.util.ImageUtil;
import edu.autocar.member.model.MemberVO;
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
		BlogsVO blogsVO = service.selectBlogInfo(blogId);
		PageInfo<PostVO> pi = postService.getPage(blogId, page);
		List<PostVO> recommend = postService.selectTopPost(blogId, 2);
		log.info(pi.toString());
		model.addAttribute("blogsVO", blogsVO);
		model.addAttribute("pi",pi);
		model.addAttribute("recommend", recommend);
		
		return "blogs/view";
	}
	
	@GetMapping("/editBlog")
	public String getEdit(Model model, HttpSession session) throws Exception{
		MemberVO user = (MemberVO) session.getAttribute("USER");
		BlogsVO blogsVO = service.selectBlogInfo(user.getBlogId());
		model.addAttribute("blogsVO", blogsVO);
		return "blogs/edit";
	}
	
	@PostMapping("/editBlog")
	public String postEdit(@Valid BlogsVO blogsVO, BindingResult result, 
			@RequestParam("blogImage") MultipartFile file) throws Exception {
		if (result.hasErrors())
			return "blogs/edit";
		
		service.updateBlogs(blogsVO, file);
		return "redirect:/";
	}

	
}
