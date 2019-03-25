package edu.autocar.comments.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.autocar.comments.domain.Comments;
import edu.autocar.comments.domain.CommentsInfo;
import edu.autocar.comments.service.CommentsService;

@Controller
public class CommentsController {
	@Autowired
	CommentsService service;
	
	@GetMapping("/{blogId}/comments/{postId}")
	public String list(Model model, @PathVariable int postId) throws Exception {
		CommentsInfo<Comments> ci = service.getCommentsByPostId(postId);
		model.addAttribute("ci", ci);
		//return "comments/list";
		return "comments/list2";
	}
	
	
	@DeleteMapping("/{blogId}/comments/{postId}/delete/{cmtId}")
	@ResponseBody
	public ResponseEntity<Map<String, String>> delete(@PathVariable int cmtId) 
			throws Exception {
		Map<String, String> map = new HashMap<>();
		if (service.deleteComments(cmtId)) {
			map.put("result", "success");
		} else {
			map.put("result", "비밀번호가 일치하지 않습니다.");
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		return new ResponseEntity<Map<String, String>>(map, headers, HttpStatus.OK);
	}
	
}
