package com.spring.myapp.movie.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.member.service.MemberService;
import com.spring.myapp.movie.MovieItem;
import com.spring.myapp.movie.service.MovieService;
import com.spring.myapp.review.Review;
import com.spring.myapp.review.service.ReviewService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class MovieControllerImpl implements MovieController {
	
	@Autowired
	MovieService movieService;
	@Autowired
	ReviewService reviewService;
	
	@PostConstruct
	public void init() {
	        // 여기에 서버 시작시 실행할 작업을 작성합니다.
		
		int mov = -1;
		double count = 0;
		double result = 0;
		List<Review> ss = reviewService.reviewAll();
		for (Review rv : ss) {  
	        if (mov != rv.getMovie_id()) { 
	            if (mov != -1) { 
	                System.out.println("평균 : " +mov+" : "+ result / count);
	                movieService.setrating(mov, result / count);
	            }
	            mov = rv.getMovie_id();
	            result = 0;
	            count = 0;
	        }
	        count++;
	        result += rv.getRating();
	    }
	   
	    if (mov != -1) { 
	        System.out.println("평균 : " +mov+" : "+ result / count);
	        movieService.setrating(mov, result / count);
	    }
	}
	
	@Override
	@GetMapping("/movie")
	public ResponseEntity<List<?>> movie(@RequestParam int movie_id, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("영화 목록 호출");
		List movieItem = movieService.Movie(movie_id);		
		 if (movieItem == null) {
	            return  new ResponseEntity<>(movieItem, HttpStatus.NOT_FOUND);
	        }
		
		
		return new ResponseEntity<>(movieItem, HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/movieList")
	public ResponseEntity<List<?>> movieList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List movieItem = movieService.listMovies();
		
		if (movieItem == null) {
            return  new ResponseEntity<>(movieItem, HttpStatus.NOT_FOUND);
        }
		
		
		return new ResponseEntity<>(movieItem, HttpStatus.OK);
	}
	
	@Override
	@PostMapping("/addmovie")
	public ResponseEntity<String> addmovie(@RequestBody MovieItem movieItem, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int vo = movieService.addMovie(movieItem);
		
		if (vo != 1) {
            return  new ResponseEntity<>("bad", HttpStatus.NOT_FOUND);
        }
		
		
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}
	
	@Override
	@PostMapping("/editmovie")
	public ResponseEntity<String> editmovie(@RequestBody MovieItem movieItem,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int vo = movieService.updateMovie(movieItem);
		
		if (vo != 1) {
            return  new ResponseEntity<>("bad", HttpStatus.NOT_FOUND);
        }
		
		
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}
	


}
