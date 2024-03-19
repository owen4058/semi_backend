package com.spring.myapp.review;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component("reviewplus")
@Getter @Setter
public class Reviewplus {
	private int movie_id;
	
	private int reviewid;
	
	private String useraccount;
	
	private String content;
	
	private Timestamp creationdate;
	
	private Timestamp editdate;
	
	private double rating;
	
	private int likes;
	
	private boolean user_liked;	
	public Reviewplus(int movie_id,  int reviewid,  String useraccount,  String content,
			Timestamp creationdate,  Timestamp editdate, int rating, int likes, boolean user_liked) {
		super();
		this.movie_id = movie_id;
		this.reviewid = reviewid;
		this.useraccount = useraccount;
		this.content = content;
		this.creationdate = creationdate;
		this.editdate = editdate;
		this.rating = rating;
		this.likes = likes;
		this.user_liked = user_liked;
	}

	public Reviewplus() {
		super();
	}

	
}
