package edu.autocar.blogs.service;

import edu.autocar.blogs.model.BlogsVO;
import edu.autocar.cmmn.domain.PageInfo;

public interface BlogsService {
	PageInfo<BlogsVO> getPage(int page) throws Exception;
	void insertBlogs(BlogsVO blogsVO) throws Exception;
}
