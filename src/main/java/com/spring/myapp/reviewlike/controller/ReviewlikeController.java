package com.spring.myapp.reviewlike.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.myapp.review.Review;
import com.spring.myapp.reviewlike.Reviewlike;
import com.spring.myapp.reviewlike.Reviewlikeres;

public interface ReviewlikeController {
	public ResponseEntity<Boolean> getReviewlikes(@RequestBody Reviewlikeres reviewlikeres, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ResponseEntity<Boolean> getReviewlikeone(@RequestBody Reviewlikeres reviewlikeres, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;

}
