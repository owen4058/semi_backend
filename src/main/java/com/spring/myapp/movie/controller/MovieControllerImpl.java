package com.spring.myapp.movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.spring.myapp.member.idValidate;
import com.spring.myapp.member.service.MemberService;
import com.spring.myapp.movie.MovieID;
import com.spring.myapp.movie.MovieItem;
import com.spring.myapp.movie.service.MovieService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class MovieControllerImpl implements MovieController {
	
	@Autowired
	MovieService movieService;

	@Override
	@GetMapping("/movie")
	public ResponseEntity<List<?>> movie(@ModelAttribute MovieID movieID, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("호출");
		List movieItem = movieService.Movie(movieID);		
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
