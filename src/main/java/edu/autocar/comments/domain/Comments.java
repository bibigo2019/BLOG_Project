package edu.autocar.comments.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
	private int cmtId;
	private int paCmtId;
	private int blogId;
	private int postId;
	private int depth;
	private String memberId;
	private String content;
	private String regDate;
	private String sysDate;
}
