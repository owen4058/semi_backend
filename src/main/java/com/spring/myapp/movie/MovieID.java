package com.spring.myapp.movie;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.spring.myapp.member.Member;

import lombok.Data;
@Component("movieID")
@Data
public class MovieID {

	private int movie_id;
	

}
