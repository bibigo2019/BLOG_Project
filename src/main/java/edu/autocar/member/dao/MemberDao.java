package edu.autocar.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.autocar.member.model.MemberVO;

public interface MemberDao {
	int count() throws Exception;
	List<MemberVO> getPage(@Param("start") int start,	@Param("end") int end) throws Exception;
	MemberVO findById(String memberId) throws Exception;
	int insert(MemberVO member) throws Exception;
	int update(MemberVO member) throws Exception;
	int delete(String memberId) throws Exception;
	int updateByAdmin(MemberVO member) throws Exception;
}
