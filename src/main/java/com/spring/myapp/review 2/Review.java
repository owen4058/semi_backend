package com.spring.myapp.review;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("review")
@Data
public class Review {
	private int movie_id;
	@NotEmpty
	private int reviewid;
	@NotEmpty
	private int userid;
	@NotEmpty
	private String content;
	@NotEmpty
	private Date creationdate;
	@NotEmpty
	private Date editdate;
	
	private int rating;
	
	private int likes;
	

}
