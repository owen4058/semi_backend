package com.spring.myapp.review.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.myapp.review.Review;

public interface ReviewController {
	public ResponseEntity<List<Review>> getReviews(@RequestParam int movieId, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ResponseEntity<List<Review>> save(@RequestBody Review review,
//			HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ResponseEntity<List<Review>> edit(@RequestBody Review review,
//			HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ResponseEntity<List<Review>> delete(@RequestParam int reviewId, @RequestBody String useraccount,
//			HttpServletRequest request, HttpServletResponse response) throws Exception;
}
