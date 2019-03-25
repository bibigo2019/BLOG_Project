package edu.autocar.post.service;

import edu.autocar.cmmn.domain.PageInfo;
import edu.autocar.post.model.PostVO;

public interface PostService {
	
	PostVO selectPost(int blogId, int postId) throws Exception;
	int insertPost(PostVO postVO) throws Exception;
	int updatePost(PostVO postVO) throws Exception;
	int deletePost(int blogId, int postId) throws Exception;
	
	PageInfo<PostVO> getPage(int page) throws Exception;
}
