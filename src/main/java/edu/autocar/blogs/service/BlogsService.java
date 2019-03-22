package edu.autocar.blogs.service;

import edu.autocar.blogs.model.BlogsVO;
import edu.autocar.blogs.model.PageInfo;

public interface BlogsService {
	PageInfo<BlogsVO> getPage(int page) throws Exception;
}
