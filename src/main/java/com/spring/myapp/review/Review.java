package com.spring.myapp.review;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("review")
@Data
public class Review {
	private String movieId;
	@NotEmpty
	private String reviewId;
	@NotEmpty
	private String userId;
	@NotEmpty
	private String content;
	@NotEmpty
	private Date postDate;
	@NotEmpty
	private Date editDate;
	@NotEmpty
	private int likes;
	

}
