package com.spring.myapp.review.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("reviewRepository")
public class ReviewRepositoryImpl implements ReviewRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Review> selectAllReviewList() throws DataAccessException;

}
