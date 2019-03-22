package edu.autocar.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostVO {
	private long blogId;
	private String memberId;
	private long postId;
	private String title;
	private String content;
	private int readCnt;
	private String regDate;
	private String updateDate;
	
}
