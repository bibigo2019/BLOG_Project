package edu.autocar.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.autocar.blogs.dao.BlogsDao;
import edu.autocar.blogs.model.BlogsVO;
import edu.autocar.blogs.model.PageInfo;
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

}
