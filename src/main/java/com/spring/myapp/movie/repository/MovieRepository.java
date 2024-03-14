package com.spring.myapp.movie.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.member.idValidate;
import com.spring.myapp.movie.MovieID;
import com.spring.myapp.movie.MovieItem;

public interface MovieRepository {
	public List selectAllMovieList() throws DataAccessException;
	
	public int insertMovie(MovieItem movieItem) throws DataAccessException ;
	 
	public int updateMovie(MovieItem movieItem) throws DataAccessException;

	public List selectAllMovie(MovieID movieID) throws DataAccessException;
	

}
