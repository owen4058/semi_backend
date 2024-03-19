package com.spring.myapp.reviewlike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.myapp.review.Review;
import com.spring.myapp.review.repository.ReviewRepository;
import com.spring.myapp.reviewlike.Reviewlike;
import com.spring.myapp.reviewlike.Reviewlikeres;
import com.spring.myapp.reviewlike.repository.ReviewlikeRepository;

@Service("reviewlikeService")
@Transactional(propagation = Propagation.REQUIRED)
public class ReviewlikeServiceImpl implements ReviewlikeService {
	@Autowired
	private ReviewlikeRepository reviewlikeRepository;
	
	
	@Override
	public boolean reviewlike(Reviewlikeres reviewlikeres) {
		Reviewlike vo = reviewlikeRepository.selectAllReviewList(reviewlikeres);
		if (vo==null) {
			return false;
		}else {
			return true;
		}
		
	}
	@Override
	public boolean reviewlikeone(Reviewlikeres reviewlikeres) {
		Reviewlike vo = reviewlikeRepository.Reviewlike(reviewlikeres);
		if (vo==null) {
			return false;
		}else {
			return true;
		}
		
	}
	

}
