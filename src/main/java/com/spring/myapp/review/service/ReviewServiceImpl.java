package com.spring.myapp.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.myapp.movie.repository.MovieRepository;
import com.spring.myapp.review.Review;
import com.spring.myapp.review.Reviewlikeinp;
import com.spring.myapp.review.repository.ReviewRepository;
import com.spring.myapp.reviewlike.Reviewlike;

@Service("reviewService")
@Transactional(propagation = Propagation.REQUIRED)
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public List reviewAll() {
		return reviewRepository.selectAllReview();
	}
	
	@Override
	public List reviewListplus(Reviewlikeinp reviewlikeinp) {
		return reviewRepository.ReviewListplus(reviewlikeinp);
	}
	
	@Override
    public List addReview(Review review) throws DataAccessException {
		reviewRepository.insertReview(review);
		double count = 0;
		double result = 0;
		int movie_id = review.getMovie_id();
		for (Review rv : reviewRepository.selectAllReviewList(movie_id)) {
			count++;
	        result += rv.getRating();
		}
		movieRepository.setrating(movie_id, result / count);
        return reviewRepository.selectAllReviewList(review.getMovie_id());
    }
	@Override
	public List updateReview(Review review) throws DataAccessException {
		reviewRepository.updateReview(review);
		double count = 0;
		double result = 0;
		int movie_id = review.getMovie_id();
		for (Review rv : reviewRepository.selectAllReviewList(movie_id)) {
			count++;
	        result += rv.getRating();
		}
		movieRepository.setrating(movie_id, result / count);
		
		
		return reviewRepository.selectAllReviewList(review.getMovie_id());
	}

	@Override
	public List removeReview(int reviewid, int movie_id, String useraccount) throws DataAccessException {
		reviewRepository.deleteReview(reviewid, useraccount);
		
		List<Review> reviews = reviewRepository.selectAllReviewList(movie_id);
		
		double count = 0;
		double result = 0;
		
		if (reviews.isEmpty()) {
			movieRepository.setrating(movie_id, 0);
		} else {
			for (Review review : reviewRepository.selectAllReviewList(movie_id)) {
				count++;
			       result += review.getRating();
			}
			
			movieRepository.setrating(movie_id, result / count);
		}
		
		
		return reviewRepository.selectAllReviewList(movie_id);
	}

}
