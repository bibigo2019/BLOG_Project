package edu.autocar.member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.autocar.cmmn.domain.PageInfo;
import edu.autocar.member.model.MemberVO;
import edu.autocar.member.model.ResultMsg;
import edu.autocar.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminMemberController {
	@Autowired
	MemberService service;
	
	@GetMapping("/list")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "1") int page) throws Exception{
		PageInfo<MemberVO> pi = service.getPage(page);
		log.info(pi.toString());
		model.addAttribute("pi", pi);
		
		return "admin/list";
	}
	
	@GetMapping("/view/{memberId}")
	public String view(@PathVariable String memberId, Model model) throws Exception {
		MemberVO memberVO = service.getMember(memberId);
		model.addAttribute("memberVO",memberVO);
		
		return "admin/view";
	}
	
	@GetMapping("/edit/{memberId}")
	public String getEdit(@PathVariable String memberId, Model model) throws Exception {
		MemberVO memberVO = service.getMember(memberId);
		model.addAttribute("memberVO",memberVO);
		return "admin/edit";
	}
	
	@PostMapping("/edit/{memberId}")
	public String postEdit(@RequestParam(value = "page") int page, 
						@Valid MemberVO memberVO, BindingResult result, 
						@RequestParam("avataImage") MultipartFile file, 
						Model model) throws Exception {
		if(result.hasErrors()) {
			return "admin/edit";
		}
		
		if(service.updateByAdmin(memberVO, file)) {
			return "redirect:/admin/view/" + memberVO.getMemberId() + "?page=" + page;
		} else {
			FieldError fieldError = new FieldError("memberVO", "password", "비밀번호가 일치하지 않습니다.");
			result.addError(fieldError);
			return "admin/edit";
		}
	}
	
	@GetMapping("/create")
	public String getCreate(MemberVO memberVO, Model model) throws Exception {
		return "admin/create";
	}

	@PostMapping("/create")
	public String postCreate(@Valid MemberVO memberVO, BindingResult result, 
						@RequestParam("avataImage") MultipartFile file,
						@RequestParam("title") String title,
						Model model) throws Exception {
		log.info(memberVO.toString());
		
		if(result.hasErrors()) {
			log.info("유효성 검증 실패");
			return "admin/create";
		}
		
		service.insert(memberVO, file, title);
		return "redirect:list";
	}

	
	@GetMapping("/id-check/{memberId}")
	@ResponseBody
	public ResponseEntity<ResultMsg> checkId(@PathVariable String memberId) throws Exception {
		if(service.getMember(memberId)==null) {
			return ResultMsg.response("ok", "사용가능한 ID 입니다.");
		} else {
			return ResultMsg.response("duplicate","이미 사용중인 ID 입니다.");
		}
	}
	
	@DeleteMapping("/delete/{memberId}")
	@ResponseBody
	public ResponseEntity<ResultMsg> delete(
				@PathVariable String memberId,
				@RequestParam(value = "password") String password) throws Exception {
		System.out.println(memberId);
		if(service.delete(memberId, password)) {
			return ResultMsg.response("success", "삭제했습니다.");
		} else {
			return ResultMsg.response("fail", "비밀번호가 일치하지 않습니다.");
		}
	}
	
}
