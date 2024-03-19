package com.spring.myapp.review;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component("delReview")
@Data
public class delReview {
	private String useraccount;
    private int movie_id;
}
