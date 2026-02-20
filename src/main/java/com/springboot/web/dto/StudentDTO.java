package com.springboot.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {

	@NotBlank(message = "Name should not be empty")
	private String name;

	@Email(message = "Email is required")
	@NotBlank(message = "Email should not be empty")
	private String email;

	@Min(value = 18, message = "Age must be atleast 18")
	private int age;

	private String branch;
	private double percentage;
}
