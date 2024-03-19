package com.spring.myapp.movie.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.member.repository.MemberRepository;
import com.spring.myapp.movie.MovieItem;
import com.spring.myapp.movie.repository.MovieRepository;



@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List listMovies() throws DataAccessException {
		List<MovieItem> movie = movieRepository.selectAllMovieList();
		
		return movie.stream().limit(8).collect(Collectors.toList());
		
	}

	@Override
	public List Movie(int movie_id) throws DataAccessException {
		return movieRepository.selectAllMovie(movie_id);
	}

	@Override
	public int addMovie(MovieItem movieItem) throws DataAccessException {
		return movieRepository.insertMovie(movieItem);
	}

	@Override
	public int updateMovie(MovieItem movieItem) throws DataAccessException {
		return movieRepository.updateMovie(movieItem);
	}
	@Override
	public int setrating(int movie_id, double averagerating) throws DataAccessException {
		return movieRepository.setrating(movie_id, averagerating);
	}
	
	
	


}
