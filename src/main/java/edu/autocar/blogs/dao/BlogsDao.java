package edu.autocar.blogs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.autocar.blogs.model.BlogsVO;

public interface BlogsDao {
	BlogsVO selectBlogs(int blogId) throws Exception;

	int insertBlogs(BlogsVO blogsVO) throws Exception;

	int updateBlogs(BlogsVO blogsVO) throws Exception;

	//블로그와 조인되어있는 포스트 먼저 삭제하는 기능 필요함
	int deleteBlogs(int blogId) throws Exception;

	int count() throws Exception;

	List<BlogsVO> getPage(@Param("start") int start, @Param("end") int end) throws Exception;
}
