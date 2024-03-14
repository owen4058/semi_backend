package com.spring.myapp.movie.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.member.idValidate;
import com.spring.myapp.movie.MovieItem;
import com.spring.myapp.movie.MovieID;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<MovieItem> selectAllMovieList() throws DataAccessException {
		return sqlSession.selectList("mapper.movie.selectAllMovieList");
	}
	@Override
	public List<MovieItem> selectAllMovie(MovieID movieID) throws DataAccessException {
		return sqlSession.selectList("mapper.movie.selectMovie",movieID);
	}

	@Override
	public int insertMovie(MovieItem movieItem) throws DataAccessException {
		return sqlSession.insert("mapper.movie.insertMovie",movieItem);
	}


	@Override
	public int updateMovie(MovieItem movieItem) throws DataAccessException {
		return sqlSession.update("mapper.movie.updateMovie",movieItem);
	}


}
