package edu.autocar.comments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.autocar.comments.dao.CommentsDao;
import edu.autocar.comments.domain.Comments;
import edu.autocar.comments.domain.CommentsInfo;

@Repository
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	CommentsDao dao;

	@Transactional
	@Override
	public int create(Comments comments) throws Exception {
		return dao.insert(comments);
	}
	

	@Override
	public CommentsInfo<Comments> getCommentsByPostId(int postId) throws Exception {
		int totalCount = dao.count(postId);
		List<Comments> list = dao.getCommentsByPostId(postId);
		return new CommentsInfo<>(totalCount, list);
	}

	/*
	@Transactional
	@Override
	public boolean update(Comments comments) throws Exception {
		return dao.update(comments) == 1;
	}
	*/
	
	@Transactional
	@Override
	public boolean deleteComments(int cmtId) throws Exception {
		return dao.deleteComments(cmtId) == 1;
	}
}

