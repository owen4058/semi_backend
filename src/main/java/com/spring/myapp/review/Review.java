	package com.spring.myapp.review;

import java.sql.Timestamp;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("review")
@Data
public class Review {
	private int movie_id;

	private int reviewid;
	
	private String useraccount;
	
	@Size(max = 600, message = "리뷰 내용은 최대 600자까지 가능합니다.")
	private String content;

	private Timestamp creationdate;

	private Timestamp editdate;
	
	private double rating;
	
	private int likes;

}
