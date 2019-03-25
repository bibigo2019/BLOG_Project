package edu.autocar.comments.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.autocar.comments.domain.Comments;

public interface CommentsDao {
	List<Comments> getCommentsByPostId(int postId) throws Exception;
	int count(int postId) throws Exception;
	int deleteComments(@Param("cmtId") Integer cmtId) throws Exception;
}
