package edu.autocar.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.autocar.blogs.dao.BlogsDao;
import edu.autocar.blogs.model.BlogPostVO;
import edu.autocar.blogs.model.BlogsVO;
import edu.autocar.cmmn.domain.PageInfo;
import lombok.extern.slf4j.Slf4j;


@Repository
@Slf4j
public class BlogsServiceImpl implements BlogsService {

	final static private int PER_PAEGE_COUNT = 3;
	
	@Autowired
	BlogsDao dao;
	
	@Override
	public PageInfo<BlogsVO> getPage(int page) throws Exception {
		int start = (page-1)*PER_PAEGE_COUNT;
		int end = start + PER_PAEGE_COUNT;
		int totalCount = dao.count();
		List<BlogsVO> list = dao.getPage(start, end);
		
		return new PageInfo<>(
				totalCount,
				(int)Math.ceil(totalCount/(double)PER_PAEGE_COUNT),
				page, PER_PAEGE_COUNT, list);
	}
	
	@Override
	@Transactional
	public void insertBlogs(BlogsVO blogsVO) throws Exception {
		dao.insertBlogs(blogsVO);
	}

	@Override
	public List<BlogPostVO> selectRandomPosts(int num) throws Exception {
		return dao.selectRandomPosts(num);
	}
	
	@Override
	public List<BlogPostVO> selectRandomBlogs() throws Exception {
		return dao.selectRandomBlogs();
	}

	@Override
	public BlogsVO selectBlogInfo(int blogId) throws Exception {
		return dao.selectBlogs(blogId);
	}
	
	

}
