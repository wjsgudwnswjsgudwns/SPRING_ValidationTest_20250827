package com.jhj.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
	private String name;
	private String email;
	private String grade;
}
