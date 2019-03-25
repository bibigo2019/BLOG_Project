package edu.autocar.comments.service;

import edu.autocar.comments.domain.Comments;
import edu.autocar.comments.domain.CommentsInfo;

public interface CommentsService {
	//void create(Comments comments) throws Exception;
	//boolean update(Comments comments) throws Exception;
	CommentsInfo<Comments> getCommentsByPostId(int page) throws Exception;
	boolean deleteComments(int cmtId) throws Exception;
}