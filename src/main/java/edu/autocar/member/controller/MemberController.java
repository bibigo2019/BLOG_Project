package edu.autocar.member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.autocar.blogs.service.BlogsService;
import edu.autocar.member.model.MemberVO;
import edu.autocar.member.model.ResultMsg;
import edu.autocar.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	@Autowired
	MemberService service;

	@Autowired
	BlogsService blogsService;

	@GetMapping("/join")
	public String getJoin(MemberVO memberVO) throws Exception {
		return "member/join";
	}

	@PostMapping("/join")
	public String postJoin(@Valid MemberVO memberVO, BindingResult result, 
			@RequestParam("avataImage") MultipartFile file, @RequestParam("title") String title,
			RedirectAttributes ra) throws Exception {
		if (result.hasErrors()) {
			return "member/join";
		}

		service.insert(memberVO, file, title);
		
		ra.addFlashAttribute("memberVO", memberVO);

		return "redirect:/join_success";
	}
	
	@GetMapping("/id-check/{memberId}")
	@ResponseBody
	public ResponseEntity<ResultMsg> checkId(@PathVariable String memberId) throws Exception {
		if (service.getMember(memberId) == null) {
			return ResultMsg.response("ok", "사용가능한 ID 입니다.");
		} else {
			return ResultMsg.response("duplicate", "이미 사용중인 ID 입니다.");
		}
	}

	@GetMapping("/join_success")
	public String joinSuccess() {
		return "member/join_success";
	}
	
	@GetMapping("/avata/{memberId}")
	@ResponseBody
	public ResponseEntity<byte[]> getAvata(@PathVariable String memberId) throws Exception {
		byte[] images = null;
		HttpStatus status = HttpStatus.OK;

		try {
			MemberVO memberVO = service.getMember(memberId);
			images = memberVO.getAvata();
		} catch (Exception e) {
			status = HttpStatus.NOT_FOUND;
		}
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(images, headers, status);
	}

}
