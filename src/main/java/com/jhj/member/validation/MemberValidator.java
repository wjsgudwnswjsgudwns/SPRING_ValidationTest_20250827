package com.jhj.member.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jhj.member.dto.MemberDto;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return MemberDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		MemberDto memberDto = (MemberDto)target;
		String id = memberDto.getId();
		String password = memberDto.getPassword();
		String confirmPassword = memberDto.getConfirmPassword();
		String name = memberDto.getName();
		String email = memberDto.getEmail();
		int age = memberDto.getAge();
		
		//아이디가 공란인지 확인
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.empty","아이디는 필수 입력사항입니다.");
		
		//아이디 길이 확인
		if(id != null && id.length()<=3 && id.length()>=17) { // ID가 3글자 이하 17글자 이상이면 error
			errors.rejectValue("id","id.short","아이디는 4자 이상 16자 이하입니다");
		}
		
		//비밀번호 확인
		if(password != null && !password.equals(confirmPassword)) { // 비밀번호 확인 실패
			errors.rejectValue("confirmPassword","pw.mismatch","비밀번호가 일치하지 않습니다");
		}
	}

}
