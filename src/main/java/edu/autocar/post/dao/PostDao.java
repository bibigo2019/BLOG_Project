package edu.autocar.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.autocar.post.model.PostVO;

public interface PostDao {
	PostVO selectPost(@Param("blogId") int blogId, @Param("postId") int postId) throws Exception;
	
	int insertPost(PostVO postVO) throws Exception;
	int updatePost(PostVO postVO) throws Exception;
	int deletePost(@Param("blogId") int blogId, @Param("postId") int postId) throws Exception;
	
	//페이지네이션에 필요한 메서드
	int count() throws Exception;
	List<PostVO> getPage(@Param("blogId") int blogId, @Param("start") int start, @Param("end") int end) throws Exception;
}
