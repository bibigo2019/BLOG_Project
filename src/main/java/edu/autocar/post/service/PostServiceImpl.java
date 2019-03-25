package edu.autocar.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.autocar.blogs.model.BlogsVO;
import edu.autocar.cmmn.domain.PageInfo;
import edu.autocar.post.dao.PostDao;
import edu.autocar.post.model.PostVO;

@Repository
public class PostServiceImpl implements PostService {
	
	final static private int PER_PAEGE_COUNT = 10;
	
	@Autowired
	PostDao dao;
	
	@Override
	public PostVO selectPost(int blogId, int postId) throws Exception {
		return dao.selectPost(blogId,postId);
	}

	@Override
	public int insertPost(PostVO postVO) throws Exception {
		return dao.insertPost(postVO);
	}
	
	@Override
	public int updatePost(PostVO postVO) throws Exception {
		return dao.updatePost(postVO);
	}
	
	@Override
	public int deletePost(int blogId, int postId) throws Exception {
		return dao.deletePost(blogId,postId);
	}

	@Override
	public PageInfo<PostVO> getPage(int blogId, int page) throws Exception {
		int start = (page-1)*PER_PAEGE_COUNT;
		int end = start + PER_PAEGE_COUNT;
		int totalCount = dao.count();
		List<PostVO> list = dao.getPage(blogId, start, end);
		
		return new PageInfo<>(
				totalCount,
				(int)Math.ceil(totalCount/(double)PER_PAEGE_COUNT),
				page, PER_PAEGE_COUNT, list);
	}

}