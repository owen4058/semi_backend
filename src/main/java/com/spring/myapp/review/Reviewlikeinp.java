package com.spring.myapp.review;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component("revielike")
@Getter @Setter
public class Reviewlikeinp {
	private int movie_id;
	
	private String likeuseraccount;
	


	
}
