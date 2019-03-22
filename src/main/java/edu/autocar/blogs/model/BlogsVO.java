package edu.autocar.blogs.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogsVO {
	private int blogId;
	private String title;
	private Date regDate;
	private Date updateDate;	
}
