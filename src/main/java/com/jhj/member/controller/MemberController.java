package com.jhj.member.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhj.member.dto.MemberDto;
import com.jhj.member.validation.MemberValidator;

@Controller
public class MemberController {

	@RequestMapping(value = "/memberJoin")
	public String memberJoin() {
		return "memberJoin";
	}
	
	@RequestMapping(value = "/memberJoinOk")
	public String memberJoinOk(@ModelAttribute("memberDto") MemberDto memberDto, Model model, BindingResult result) {
		
		MemberValidator memberValidator = new MemberValidator();
		memberValidator.validate(memberDto, result);
		
		if(result.hasErrors()) { // 에러 체크
			List<ObjectError> allErrors = result.getAllErrors(); // 모든 에러가 있음
			List<String> errorMsg = new ArrayList<String>();
			for(ObjectError error :allErrors) {
				errorMsg.add(error.getDefaultMessage()); //에러 메세지
			}
			
			model.addAttribute("signupError", "회원 가입에 실패하였습니다.");
			model.addAttribute("errorMsg", errorMsg);
			
			model.addAttribute("memberDto", memberDto);
			
			return "memberJoin";
		}
		model.addAttribute("memberDto", memberDto);
		return "memberJoinOk";
	}
}
