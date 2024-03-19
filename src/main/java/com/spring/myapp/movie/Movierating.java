package com.spring.myapp.movie;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.spring.myapp.member.Member;

import lombok.Data;
@Component("movierating")
@Data
public class Movierating {

	private int movie_id;

    private double averagerating;

	public Movierating(int movie_id, double averagerating) {
		super();
		this.movie_id = movie_id;
		this.averagerating = averagerating;
	}

	public Movierating() {
		super();
	}
    
    

}
