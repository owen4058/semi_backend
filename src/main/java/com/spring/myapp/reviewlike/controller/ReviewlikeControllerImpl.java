package com.spring.myapp.reviewlike.controller;

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
import com.spring.myapp.reviewlike.Reviewlike;
import com.spring.myapp.reviewlike.Reviewlikeres;
import com.spring.myapp.reviewlike.service.ReviewlikeService;

@Controller("reviewlikeController")
public class ReviewlikeControllerImpl implements ReviewlikeController {
	@Autowired
	ReviewlikeService reviewlikeService;
	
	@PostMapping("/reviewlike")
	@Override
	public ResponseEntity<Boolean> getReviewlikes(@RequestBody Reviewlikeres reviewlikeres, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		boolean bo = reviewlikeService.reviewlike(reviewlikeres);
		if (bo) {
			return new ResponseEntity<>(bo, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(bo, HttpStatus.OK);
		}
		
        
	}
	
	@PostMapping("/like")
	@Override
	public ResponseEntity<Boolean> getReviewlikeone(@RequestBody Reviewlikeres reviewlikeres, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		boolean bo = reviewlikeService.reviewlikeone(reviewlikeres);
		if (bo) {
			return new ResponseEntity<>(bo, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(bo, HttpStatus.OK);
		}
		
        
	}
	
}
