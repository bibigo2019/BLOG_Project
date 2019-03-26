package edu.autocar.blogs.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.autocar.blogs.model.BlogPostVO;
import edu.autocar.blogs.model.BlogsVO;
import edu.autocar.cmmn.domain.PageInfo;

public interface BlogsService {
	PageInfo<BlogsVO> getPage(int page) throws Exception;
	void insertBlogs(BlogsVO blogsVO) throws Exception;
	
	List<BlogPostVO> selectRandomPosts(int num) throws Exception;
	List<BlogPostVO> selectRandomBlogs() throws Exception;
	BlogsVO selectBlogInfo(int blogId) throws Exception;
	
	boolean updateBlogs(BlogsVO blogsVO, MultipartFile file) throws Exception;
	
}
