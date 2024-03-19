package com.spring.myapp.reviewlike.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.review.Review;
import com.spring.myapp.reviewlike.Reviewlike;
import com.spring.myapp.reviewlike.Reviewlikeres;

public interface ReviewlikeRepository {

	public Reviewlike selectAllReviewList(Reviewlikeres reviewlikeres) throws DataAccessException;
	
	public Reviewlike Reviewlike(Reviewlikeres reviewlikeres) throws DataAccessException;

}
