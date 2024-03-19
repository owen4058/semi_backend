package com.spring.myapp.review.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.review.Review;
import com.spring.myapp.review.Reviewlikeinp;
import com.spring.myapp.reviewlike.Reviewlike;

public interface ReviewService {
	public List addReview(Review reviewVO) throws DataAccessException;
	public List updateReview(Review reviewVO) throws DataAccessException;
	public List removeReview(int reviewid, int movie_id, String useraccount) throws DataAccessException;
	public List reviewListplus(Reviewlikeinp reviewlikeinp );
	public List reviewAll();
}
