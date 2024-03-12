package com.spring.myapp.review.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.myapp.review.Review;

@Controller("reviewController")
public class ReviewControllerImpl implements ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/review")
	@Override
	public ResponseEntity<List<Review>> getReviews(@RequestParam String movieId, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("isLogOn", true); // 어떤 역할인지??
		System.out.println("리뷰 조회 컨트롤러 ");
		
	}

}
