package com.spring.myapp.movie.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.movie.MovieItem;

public interface MovieController {

	public ResponseEntity<List<?>> movie(int movie_id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ResponseEntity<List<?>> movieList(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ResponseEntity<String> addmovie(MovieItem movieItem, HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ResponseEntity<String> editmovie(MovieItem movieItem, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	
	
}
