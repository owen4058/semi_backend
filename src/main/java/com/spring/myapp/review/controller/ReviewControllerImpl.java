package com.spring.myapp.review.controller;

import java.awt.PageAttributes.MediaType;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.myapp.review.Review;
import com.spring.myapp.review.Reviewlikeinp;
import com.spring.myapp.review.Reviewplus;
import com.spring.myapp.review.service.ReviewService;
import com.spring.myapp.reviewlike.Reviewlike;
import com.spring.myapp.reviewlike.Reviewlikeres;
import com.spring.myapp.reviewlike.service.ReviewlikeService;
import com.spring.myapp.review.delReview;

@Controller("reviewController")
public class ReviewControllerImpl implements ReviewController {
	@Autowired
	ReviewService reviewService;
	@Autowired
	ReviewlikeService reviewlikeService;
	

	@GetMapping("/review")
	@Override
	public ResponseEntity<List<Reviewplus>> getReviews(@ModelAttribute Reviewlikeinp reviewlikeinp,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("리뷰 조회 컨트롤러");
		List<Reviewplus> reviewlikeList = reviewService.reviewListplus(reviewlikeinp);
        return new ResponseEntity<List<Reviewplus>>(reviewlikeList, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/review" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	@Override
	public ResponseEntity<?> save(@Valid @RequestBody Review review, BindingResult bindingResult,
	        HttpServletRequest request, HttpServletResponse response) throws Exception {
	    System.out.println("리뷰 저장 컨트롤러 ");
	    if (bindingResult.hasErrors()) {
			return new ResponseEntity<>("텍스트 양이 너무 많습니다.", HttpStatus.NOT_FOUND);
		}
	    List<Review> reviews10 = reviewService.addReview(review);
	    return new ResponseEntity<>(reviews10, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/review", produces = "application/json; charset=utf8",method =RequestMethod.PUT)
	@Override
	public ResponseEntity<?> edit(@Valid @RequestBody Review review,BindingResult bindingResult,
	        HttpServletRequest request, HttpServletResponse response) throws Exception {
	    System.out.println("리뷰 업데이트 컨트롤러 ");
	    if (bindingResult.hasErrors()) {
			return new ResponseEntity<>("텍스트 양이 너무 많습니다.", HttpStatus.NOT_FOUND);
		}
	    List<Review> reviews10 = reviewService.updateReview(review);
	    return new ResponseEntity<>(reviews10, HttpStatus.OK);
	}
	
	@DeleteMapping("/review")
	public ResponseEntity<List<Review>> delete(@RequestParam int reviewid, @RequestBody delReview delReview,
	        HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("리뷰 삭제 컨트롤러 ");
			List<Review> reviews10 = reviewService.removeReview(reviewid, delReview.getMovie_id(), delReview.getUseraccount());
	        return new ResponseEntity<>(reviews10, HttpStatus.OK);
	}
	
	
	
	
	
}
