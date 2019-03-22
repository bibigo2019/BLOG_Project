package edu.autocar.post.service;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.autocar.post.dao.PostDao;
import edu.autocar.post.model.PostVO;
import oracle.sql.CLOB;

@Repository
public class PostServiceImpl implements PostService {

	@Autowired
	PostDao dao;

	@Override
	public PostVO selectPost(int blogId, int postId) throws Exception {
		return dao.selectPost(blogId,postId);
	}
	
	public static String extractClob(CLOB clob) throws SQLException {

		final int length = (int) ((CLOB) clob).length();
		final char[] buffer = new char[length];
		int charactersRead;
		try {
			charactersRead = clob.getCharacterStream().read(buffer, 0, length);
		} catch (IOException e) {
			throw new RuntimeException("CLOB를 읽는데 문제가 발생했습니다:", e);
		}
		return new String(buffer, 0, charactersRead);
	}
	

	@Override
	public int insertPost(PostVO postVO) throws Exception {
		return dao.insertPost(postVO);
	}

}