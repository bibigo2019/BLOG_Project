package edu.autocar.comments.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.autocar.comments.domain.Comments;

public interface CommentsDao {
	int insert(Comments comments) throws Exception;
	List<Comments> getCommentsByPostId(int postId) throws Exception;
	int count(int postId) throws Exception;
	int deleteComments(@Param("cmtId") Integer cmtId) throws Exception;
	void deleteChild(int cmtId);
	Comments getCommentsByCmtId(int cmtId) throws Exception;
}
