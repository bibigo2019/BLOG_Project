package edu.autocar.comments.service;

import edu.autocar.comments.domain.Comments;
import edu.autocar.comments.domain.CommentsInfo;

public interface CommentsService {
	int create(Comments comments) throws Exception;
	CommentsInfo<Comments> getCommentsByPostId(int page) throws Exception;
	boolean deleteComments(int cmtId) throws Exception;
	boolean deleteComments2(int cmtId) throws Exception;
	Comments getCommentsByCmtId(int cmtId) throws Exception;
}