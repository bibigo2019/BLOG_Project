package edu.autocar.comments.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
	private int cmtId;
	private int pCmtId;
	private int blogId;
	private int postId;
	private int depth;
	private String memberId;
	private String content;
	private Date regDate;
	private Date sysDate;
}
