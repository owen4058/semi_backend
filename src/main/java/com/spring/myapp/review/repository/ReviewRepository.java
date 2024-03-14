package com.spring.myapp.review.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.review.Review;

public interface ReviewRepository {
	public int validateReview() throws DataAccessException;
	public List<Review> selectAllReviewList(int movie_id) throws DataAccessException;
	public int insertReview(Review review) throws DataAccessException;
	public int updateReview(Review review) throws DataAccessException;
	public int deleteReview(int reviewid, String useraccount, int movieid) throws DataAccessException;
}
