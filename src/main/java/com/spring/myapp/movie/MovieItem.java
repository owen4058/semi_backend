package com.spring.myapp.movie;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.spring.myapp.member.Member;

import lombok.Data;
@Component("movieItem")
@Data
public class MovieItem {
	
	private int movie_id;

	private String title;

	private String description;

	private String director;
	
	private String actors;
	
	private Date releasedate;
	
	private double averagerating;

	private String img_url;
;

}
