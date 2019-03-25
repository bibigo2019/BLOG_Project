package edu.autocar.post.service;

import edu.autocar.cmmn.domain.PageInfo;
import edu.autocar.post.model.FileVO;
import edu.autocar.post.model.PostVO;

public interface PostService {
	
	PostVO selectPost(int blogId, int postId) throws Exception;
	int insertPost(PostVO postVO) throws Exception;
	int updatePost(PostVO postVO) throws Exception;
	int deletePost(int blogId, int postId) throws Exception;
	
	PageInfo<PostVO> getPage(int blogId, int page) throws Exception;
	
	FileVO selectFile(int postId) throws Exception;
	int insertFile(FileVO file) throws Exception;
	
	void deleteFile(int postId) throws Exception;
	
}
