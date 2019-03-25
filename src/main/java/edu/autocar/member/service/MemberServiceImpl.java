package edu.autocar.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.autocar.blogs.dao.BlogsDao;
import edu.autocar.blogs.model.BlogsVO;
import edu.autocar.cmmn.domain.PageInfo;
import edu.autocar.cmmn.util.ImageUtil;
import edu.autocar.cmmn.util.SHA256Util;
import edu.autocar.member.dao.MemberDao;
import edu.autocar.member.model.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MemberServiceImpl implements MemberService {
	final static private int PER_PAEGE_COUNT = 10;
	
	@Autowired
	MemberDao dao;
	
	@Autowired
	BlogsDao blogsDao;
	
	@Override
	public MemberVO checkPassword(String memberId, String password) throws Exception {
		MemberVO user = dao.findById(memberId);
		if (user != null) { // 사용자 ID가 존재하는 경우
			password = SHA256Util.getEncrypt(password, user.getSalt());
			if (password.equals(user.getPassword()))
				return user;
		}
		// ID가 없거나 비밀번호가 다른 경우
		return null;
	}

	@Override
	@Transactional
	public void insert(MemberVO memberVO, MultipartFile file, String title) throws Exception {
		BlogsVO blogsVO = new BlogsVO();
		blogsVO.setTitle(title);
		
		blogsDao.insertBlogs(blogsVO);
		int blogId = blogsVO.getBlogId();
		String salt = SHA256Util.generateSalt();
		String encPassword = SHA256Util.getEncrypt(memberVO.getPassword(), salt);

		memberVO.setSalt(salt);
		memberVO.setPassword(encPassword);
		memberVO.setBlogId(blogId);
		
		if (!file.isEmpty()) {
			memberVO.setAvata(ImageUtil.thumb(file.getBytes()));
		}
		
		log.info(memberVO.toString());
		dao.insert(memberVO);
	}

	@Override
	public boolean delete(String memberId, String password) throws Exception {
		if (!checkAdminPassword(password))
			return false;
		int res = 0;
		int blogId = getMember(memberId).getBlogId();
		res += dao.deleteCmt(blogId);
		res += dao.deletePost(blogId);
		res += dao.delete(memberId);
		res += dao.deleteBlog(blogId);
		
		return res > 0;
	}
	
	@Override
	public MemberVO getMember(String memberId) throws Exception {
		return dao.findById(memberId);
	}
	
	@Override
	public PageInfo<MemberVO> getPage(int page) throws Exception {
		int start = (page-1)*PER_PAEGE_COUNT;
		int end = start + PER_PAEGE_COUNT;
		int totalCount = dao.count();
		List<MemberVO> list = dao.getPage(start, end);
		
		return new PageInfo<>(
				totalCount,
				(int)Math.ceil(totalCount/(double)PER_PAEGE_COUNT),
				page, PER_PAEGE_COUNT, list);
	}
	
	@Override
	@Transactional
	public boolean update(MemberVO memberVO, MultipartFile file) throws Exception {
		if(!checkUserPassword(memberVO))
			return false;
		
		if (!file.isEmpty()) {
			memberVO.setAvata(ImageUtil.thumb(file.getBytes()));
		}

		if(dao.update(memberVO) != 1) return false;
	
		return true;
	}
	
	private boolean checkUserPassword(MemberVO memberVO) throws Exception {
		MemberVO user = dao.findById(memberVO.getMemberId());
		String userPassword = user.getPassword();
		String password = memberVO.getPassword();
		password = SHA256Util.getEncrypt(password, user.getSalt());
		return userPassword.equals(password);
	}
	
	@Override
	@Transactional
	public boolean updateByAdmin(MemberVO memberVO, MultipartFile file) throws Exception {
		if (!checkAdminPassword(memberVO.getPassword()))
			return false;

		if (!file.isEmpty()) {
			memberVO.setAvata(ImageUtil.thumb(file.getBytes()));
		}
		
		if(dao.updateByAdmin(memberVO) != 1) return false;
	
		return true;
	}
	
	private boolean checkAdminPassword(String password) throws Exception {
		MemberVO admin = dao.findById("admin");

		String adminPassword = admin.getPassword();
		password = SHA256Util.getEncrypt(password, admin.getSalt());

		return adminPassword.equals(password);
	}

}
