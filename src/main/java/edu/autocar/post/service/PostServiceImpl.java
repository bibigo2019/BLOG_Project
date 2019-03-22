package edu.autocar.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.autocar.post.dao.PostDao;
import edu.autocar.post.model.PostVO;

@Repository
public class PostServiceImpl implements PostService {

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


}