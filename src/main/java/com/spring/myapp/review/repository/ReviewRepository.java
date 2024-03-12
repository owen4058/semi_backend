package com.spring.myapp.review.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.review.Review;

public interface ReviewRepository {
	public List<Review> selectAllReviewList() throws DataAccessException;
	public int insertReview(Review review) throws DataAccessException;
	public int updateReview(Review review) throws DataAccessException;
	public int deleteReview(Review review) throws DataAccessException;
}
