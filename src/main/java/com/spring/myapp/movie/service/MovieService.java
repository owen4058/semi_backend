package com.spring.myapp.movie.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.member.idValidate;
import com.spring.myapp.movie.MovieID;
import com.spring.myapp.movie.MovieItem;

public interface MovieService {
	 public List listMovies() throws DataAccessException;
	 public List Movie(MovieID movieID) throws DataAccessException;
	 public int addMovie(MovieItem movieItem) throws DataAccessException;
	 int updateMovie(MovieItem movieItem) throws DataAccessException;
}
