package edu.autocar.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.autocar.post.model.FileVO;
import edu.autocar.post.model.PostVO;

public interface PostDao {
	PostVO selectPost(@Param("blogId") int blogId, @Param("postId") int postId) throws Exception;
	
	int insertPost(PostVO postVO) throws Exception;
	int updatePost(PostVO postVO) throws Exception;
	int deletePost(@Param("blogId") int blogId, @Param("postId") int postId) throws Exception;
	
	//페이지네이션에 필요한 메서드
	int count(int blogId) throws Exception;
	List<PostVO> getPage(@Param("blogId") int blogId, @Param("start") int start, @Param("end") int end) throws Exception;
	
	//조회수 증가 메서드
	int increaseReadCnt(int postId) throws Exception;
	
	//Top 2 포스트
	List<PostVO> selectTopPost(@Param("blogId") int blogId, @Param("num") int num) throws Exception;
	
	FileVO selectFile(@Param("postId") int postId) throws Exception;
	
	int insertFile(FileVO fileVO) throws Exception;
	
	void deleteFile(@Param("postId") int postId) throws Exception;
	
}
