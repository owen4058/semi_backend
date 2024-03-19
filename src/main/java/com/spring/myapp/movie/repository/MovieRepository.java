package com.spring.myapp.movie.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.movie.MovieItem;

public interface MovieRepository {
	public List selectAllMovieList() throws DataAccessException;
	
	public int insertMovie(MovieItem movieItem) throws DataAccessException ;
	 
	public int updateMovie(MovieItem movieItem) throws DataAccessException;

	public List selectAllMovie(int movie_id) throws DataAccessException;

	public int setrating(int movie_id, double averagerating) throws DataAccessException;
	

}
