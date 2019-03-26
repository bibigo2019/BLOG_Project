package edu.autocar.comments.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.autocar.blogs.model.BlogsVO;
import edu.autocar.comments.domain.Comments;
import edu.autocar.comments.service.CommentsService;
import edu.autocar.member.model.MemberVO;

@Controller
public class CommentsController {
	@Autowired
	CommentsService service;

	@PostMapping("/{blogId}/comments/{postId}")
	@ResponseBody
	public ResponseEntity<Map<String, String>> add(@PathVariable int blogId, @PathVariable int postId,
			@RequestParam("comment") String content, @RequestParam("depth") int depth,
			@RequestParam("pCmtId") int pCmtId, HttpSession session) throws Exception {
		Map<String, String> map = new HashMap<>();
		MemberVO member = (MemberVO) session.getAttribute("USER");

		Comments comments = new Comments(0, pCmtId, blogId, postId, depth, member.getMemberId(), content, "", "");
		if (service.create(comments) > 0) {
			map.put("result", "success");
		} else {
			map.put("result", "비밀번호가 일치하지 않습니다.");
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		return new ResponseEntity<Map<String, String>>(map, headers, HttpStatus.OK);
	}

	/*
	 * MemberVO user = (MemberVO) session.getAttribute("USER"); BlogsVO blogsVO =
	 * service.selectBlogInfo(user.getBlogId()); model.addAttribute("blogsVO",
	 * blogsVO); return "blogs/edit";
	 */

	// 0레벨 삭제기능
	@DeleteMapping("/{blogId}/deleteComments/{postId}/{cmtId}")
	@ResponseBody
	public ResponseEntity<Map<String, String>> delete(@PathVariable int cmtId, HttpSession session) throws Exception {
		Map<String, String> map = new HashMap<>();
		MemberVO user = (MemberVO) session.getAttribute("USER");
		if (user != null) {
			String id = user.getMemberId();
			Comments commentsVO = service.getCommentsByCmtId(cmtId);
			if (commentsVO.getMemberId().equals(id)) {
				if (service.deleteComments(cmtId)) {
					map.put("result", "success");
				} else {
					map.put("result", "fail");
				}
			} else {
				map.put("result", "permission");
			}

		} else {
			map.put("result", "login");
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");

		return new ResponseEntity<Map<String, String>>(map, headers, HttpStatus.OK);
	}

	// 1레벨 삭제기능
	@DeleteMapping("/{blogId}/deleteComments2/{postId}/{cmtId}")
	@ResponseBody
	public ResponseEntity<Map<String, String>> delete2(@PathVariable int cmtId, HttpSession session) throws Exception {
		Map<String, String> map = new HashMap<>();
		MemberVO user = (MemberVO) session.getAttribute("USER");
		if (user != null) {
			String id = user.getMemberId();
			Comments commentsVO = service.getCommentsByCmtId(cmtId);
			if (commentsVO.getMemberId().equals(id)) {
				if (service.deleteComments(cmtId)) {
					map.put("result", "success");
				} else {
					map.put("result", "fail");
				}
			} else {
				map.put("result", "permission");
			}

		} else {
			map.put("result", "login");
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");

		return new ResponseEntity<Map<String, String>>(map, headers, HttpStatus.OK);
	}
}
