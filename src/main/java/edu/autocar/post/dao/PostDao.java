package edu.autocar.post.dao;

import org.apache.ibatis.annotations.Param;

import edu.autocar.post.model.PostVO;

public interface PostDao {
	PostVO selectPost(@Param("blogId") int blogId, @Param("postId") int postId) throws Exception;
	
	int insertPost(PostVO postVO) throws Exception;
	int updatePost(PostVO postVO) throws Exception;
	int deletePost(@Param("blogId") int blogId, @Param("postId") int postId) throws Exception;
}
