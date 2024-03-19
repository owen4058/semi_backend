package com.spring.myapp.reviewlike.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.review.Review;
import com.spring.myapp.reviewlike.Reviewlike;
import com.spring.myapp.reviewlike.Reviewlikeres;

public interface ReviewlikeService {
	public boolean reviewlike(Reviewlikeres reviewlikeres) throws DataAccessException;
	public boolean reviewlikeone(Reviewlikeres reviewlikeres);

}
