package com.spring.myapp.review.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.review.Review;

public interface ReviewService {
	public List listReviews() throws DataAccessException;
	public int addReview(Review reviewVO) throws DataAccessException;
	public int editReview(Review reviewVO) throws DataAccessException;
	public int removeReview(Review reviewVO) throws DataAccessException;
	
	

}
