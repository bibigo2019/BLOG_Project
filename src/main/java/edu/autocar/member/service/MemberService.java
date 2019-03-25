package edu.autocar.member.service;

import org.springframework.web.multipart.MultipartFile;

import edu.autocar.cmmn.domain.PageInfo;
import edu.autocar.member.model.MemberVO;

public interface MemberService {
	PageInfo<MemberVO> getPage(int page) throws Exception;
	MemberVO getMember(String memberId) throws Exception;
	void insert(MemberVO memberVO, MultipartFile file, String title) throws Exception;
	boolean update(MemberVO memberVO, MultipartFile file) throws Exception;
	boolean updateByAdmin(MemberVO memberVO, MultipartFile file)throws Exception;
	
	//관리자만 삭제 가능 - 비밀번호는 관리자의 비밀번호
	boolean delete(String memberId, String password) throws Exception;
	MemberVO checkPassword(String memberId, String password) throws Exception;
}
