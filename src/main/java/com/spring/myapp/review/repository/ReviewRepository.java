package com.spring.myapp.review.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.review.Review;
import com.spring.myapp.review.Reviewlikeinp;
import com.spring.myapp.review.Reviewplus;
import com.spring.myapp.reviewlike.Reviewlike;

public interface ReviewRepository {
	public int validateReview() throws DataAccessException;
	public List<Review> selectAllReviewList(int movie_id) throws DataAccessException;
	public int insertReview(Review review) throws DataAccessException;
	public int updateReview(Review review) throws DataAccessException;
	public int deleteReview(int reviewid, String useraccount) throws DataAccessException;
	public List<Reviewplus> ReviewListplus(Reviewlikeinp reviewlikeinp) throws DataAccessException;
	public List<Review> selectAllReview() throws DataAccessException;
}
