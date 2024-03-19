package com.spring.myapp.member;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Component("loginForm")
@Data
public class LoginForm {
	private String useraccount;
	private String password;
////
}
