package edu.autocar.post.service;

import edu.autocar.post.model.PostVO;

public interface PostService {
	
	PostVO selectPost(int blogId, int postId) throws Exception;
	
	int insertPost(PostVO postVO) throws Exception;
	
	
}
