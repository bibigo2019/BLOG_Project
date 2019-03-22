package edu.autocar.blogs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.autocar.blogs.model.BlogsVO;

public interface BlogsDao {
	int count() throws Exception;
	List<BlogsVO> getPage(@Param("start") int start, 
					@Param("end") int end) throws Exception;
}
