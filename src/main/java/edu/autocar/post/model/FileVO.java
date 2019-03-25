package edu.autocar.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileVO {
	private long fileId;
	private long postId;
	private String type;
	private String name;
	private byte[] content;
	private String regDate;
	private String updateDate;
	
}
