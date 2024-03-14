package com.spring.myapp.review.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.myapp.review.Review;
import com.spring.myapp.review.service.ReviewService;

@Controller("reviewController")
public class ReviewControllerImpl implements ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/review")
	@Override
	public ResponseEntity<List<Review>> getReviews(@RequestParam int movie_id, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("리뷰 조회 컨트롤러 ");
		List<Review> reviewList = reviewService.reviewList(movie_id);
		
        return new ResponseEntity<List<Review>>(reviewList, HttpStatus.OK);
	}
	
//	@PostMapping("/review")
//	@Override
//	public ResponseEntity<List<Review>> save(@RequestBody Review review,
//	        HttpServletRequest request, HttpServletResponse response) throws Exception {
//	    reviewService.addReview(review);
//	    System.out.println("리뷰 저장 컨트롤러 ");
//	    List<Review> reviews10 = reviewService.reviewList(review.getMovie_id());
//	    return new ResponseEntity<>(reviews10, HttpStatus.CREATED);
//	}
//	
//	@PutMapping("/review")
//	@Override
//	public ResponseEntity<List<Review>> edit(@RequestBody Review review,
//	        HttpServletRequest request, HttpServletResponse response) throws Exception {
//	    reviewService.updateReview(review);
//	    System.out.println("리뷰 업데이트 컨트롤러 ");
//	    List<Review> reviews10 = reviewService.reviewList(review.getMovie_id());
//	    return new ResponseEntity<>(reviews10, HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/review")
//	public ResponseEntity<List<Review>> delete(@RequestParam int reviewId, @RequestBody String userAccount,
//	        HttpServletRequest request, HttpServletResponse response) throws Exception {
//	    if (reviewService.isReview() != 0) {
//	    	reviewService.removeReview(reviewId);
//	    	List<Review> reviews10 = reviewService.reviewList(reviewId);
//	    	System.out.println("리뷰 삭제 컨트롤러 ");
//	        return new ResponseEntity<>(reviews10, HttpStatus.OK);
//	    } else {
//	    	System.out.println("리뷰 삭제 실패 ");
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	}
	
	
	
	
	
	
	
	
	
	
	
	
}
