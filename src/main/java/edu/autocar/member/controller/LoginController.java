package edu.autocar.member.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.autocar.member.model.LoginInfo;
import edu.autocar.member.model.MemberVO;
import edu.autocar.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	@Autowired
	MemberService service;

	@GetMapping("/login")
	public String login(LoginInfo loginInfo, @ModelAttribute("target") String target,
			@ModelAttribute("reason") String reason) {
		loginInfo.setTarget(target);
		loginInfo.setReason(reason);
		return "member/login";
	}
	
	@PostMapping("/login")
	public String postLogin(@Valid LoginInfo loginInfo, BindingResult result, HttpSession session) throws Exception {
		if (result.hasErrors())
			return "member/login";
		MemberVO memberVO = service.checkPassword(loginInfo.getMemberId(), loginInfo.getPassword());
		if (memberVO != null) {
			session.setAttribute("USER", memberVO);
			String target = loginInfo.getTarget();
			if (target != null && !target.isEmpty())
				return "redirect:" + target;
			
			if (memberVO.adminIs()) {
				return "redirect:/admin/list";
			} else {
				return "redirect:/";
			}
		} else {
			result.reject("fail", "사용자 ID 또는 비밀번호가 일치하지 않습니다.");
			return "member/login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
