package com.spring.myapp.review;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("review")
@Data
public class Review {
	@NotEmpty
	private int movie_id;

	private int reviewid;
	@NotEmpty
	private String useraccount;
	@NotEmpty
	private String content;

	private Date creationdate;
	
	private boolean user_liked;
	
	private int rating;
	
	private int likes;
	

}
