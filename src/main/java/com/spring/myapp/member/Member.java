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
	
	private String useraccount;
	
	private String password;
	
	private String email;

}
