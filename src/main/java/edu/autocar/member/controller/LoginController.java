package edu.autocar.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.autocar.member.model.LoginInfo;
import edu.autocar.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	@Autowired
	MemberService service;

	/*
	 * @GetMapping("/login") public String login(LoginInfo
	 * loginInfo, @ModelAttribute("target") String target,
	 * 
	 * @ModelAttribute("reason") String reason) { loginInfo.setTarget(target);
	 * loginInfo.setReason(reason); return "member/login"; }
	 */
}
