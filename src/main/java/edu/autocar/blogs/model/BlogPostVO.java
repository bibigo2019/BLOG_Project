package edu.autocar.blogs.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostVO {
	private int blogId;
	private String postTitle;
	private String blogTitle;
	private String summary;
	private byte[] img;
	private long postId;
	private String content;
	private String memberId;
	private String name;
	private String email;
	private int readCnt;
	private Date regDate;
	private Date updateDate;
}
