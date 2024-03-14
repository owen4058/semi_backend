package com.spring.myapp.review.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.myapp.review.Review;

@Repository("reviewRepository")
public class ReviewRepositoryImpl implements ReviewRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int validateReview() throws DataAccessException {
		return sqlSession.selectOne("mapper.review.selectReview");
	}
	
	@Override
	public List<Review> selectAllReviewList(int movie_id) throws DataAccessException {
		return sqlSession.selectList("mapper.review.selectAllReviewList",movie_id);
	}
	
	@Override
    public int insertReview(Review review) throws DataAccessException {
        int vo = sqlSession.insert("mapper.review.insertReview", review);
        return vo;
    }

	@Override
    public int deleteReview(int reviewId) throws DataAccessException {
    	int vo = sqlSession.delete("mapper.review.deleteReview", reviewId);
        return vo;
    }

    @Override
    public int updateReview(Review review) throws DataAccessException {
    	int vo = sqlSession.update("mapper.review.updateReview", review);
        return vo;
    }

}
