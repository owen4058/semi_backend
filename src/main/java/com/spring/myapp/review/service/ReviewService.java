package com.spring.myapp.review.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.review.Review;

public interface ReviewService {
	public int isReview() throws DataAccessException;
	public List reviewList(int movie_id) throws DataAccessException;
	public List addReview(Review reviewVO) throws DataAccessException;
	public List updateReview(Review reviewVO) throws DataAccessException;
	public List removeReview(int reviewid, int movie_id, String useraccount) throws DataAccessException;
}
