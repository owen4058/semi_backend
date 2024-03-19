package com.spring.myapp.review.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.myapp.review.Review;
import com.spring.myapp.review.Reviewlikeinp;
import com.spring.myapp.review.Reviewplus;
import com.spring.myapp.review.delReview;

public interface ReviewController {
	public ResponseEntity<List<Reviewplus>> getReviews(Reviewlikeinp reviewlikeinp,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity<?> save(@Valid @RequestBody Review review,BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity<?> edit(@Valid @RequestBody Review review,BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity<List<Review>> delete(@RequestParam int reviewId, @RequestBody delReview delReview,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
}
