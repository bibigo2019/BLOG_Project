package edu.autocar.comments.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsInfo<T> {
	int totalCount;		//총 댓글 수 
	List<T> list;		//해당 댓글 목록
}
