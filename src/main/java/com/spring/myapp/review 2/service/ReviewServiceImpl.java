package com.spring.myapp.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.myapp.review.Review;
import com.spring.myapp.review.repository.ReviewRepository;

@Service("reviewService")
@Transactional(propagation = Propagation.REQUIRED)
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Override 
	public int isReview() throws DataAccessException {
		return reviewRepository.validateReview();
	}
	
	
	@Override
	public List reviewList(int movie_id) {
		return reviewRepository.selectAllReviewList(movie_id);
	}
	
//	@Override
//    public List addReview(Review review) throws DataAccessException {
//        reviewRepository.insertReview(review);
//        return reviewRepository.selectAllReviewList();
//    }
//
//    @Override
//    public List updateReview(Review review) throws DataAccessException {
//        reviewRepository.updateReview(review);
//        return reviewRepository.selectAllReviewList();
//    }
//
//    @Override
//    public List removeReview(int reviewId) throws DataAccessException {
//        reviewRepository.deleteReview(reviewId);
//        return reviewRepository.selectAllReviewList();
//    }

}
