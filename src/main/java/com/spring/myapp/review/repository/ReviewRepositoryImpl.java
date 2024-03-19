package com.spring.myapp.review.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.myapp.review.Review;
import com.spring.myapp.review.Reviewlikeinp;
import com.spring.myapp.review.Reviewplus;
import com.spring.myapp.reviewlike.Reviewlike;

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
	public List<Review> selectAllReview() throws DataAccessException {
		return sqlSession.selectList("mapper.review.selectAllReview");
	}
	
	@Override
	public List<Reviewplus> ReviewListplus(Reviewlikeinp reviewlikeinp) throws DataAccessException {
		return sqlSession.selectList("mapper.reviewlist.ReviewListplus",reviewlikeinp);
	}
	
	
	@Override
    public int insertReview(Review review) throws DataAccessException {
        int vo = sqlSession.insert("mapper.review.insertReview", review);
        return vo;
    }

	@Override
    public int deleteReview(int reviewid, String useraccount) throws DataAccessException {
		Map<String, Object> params = new HashMap<>();
	    params.put("reviewid", reviewid);
	    params.put("useraccount", useraccount);
    	int vo = sqlSession.delete("mapper.review.deleteReview", params);
        return vo;
    }

    @Override
    public int updateReview(Review review) throws DataAccessException {
    	int vo = sqlSession.update("mapper.review.updateReview", review);
        return vo;
    }
}
