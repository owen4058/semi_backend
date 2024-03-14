package com.spring.myapp.member;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component("member")
@Data
public class Member {
	@NotEmpty
	private String useraccount;
	@NotEmpty
	private String password;
	@NotEmpty
	private String email;
//	@NotEmpty
//	private String username;
}
