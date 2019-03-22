package edu.autocar.blogs.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo<T> {
	int totalCount;	//총 데이터 건수
	int totalPage;	//총 페이지 수
	int page;		//현재 페이지 번호
	int perCount;	//한 페이지당 데이터 건수
	List<T> list;	//해당 페이지 목록
}
