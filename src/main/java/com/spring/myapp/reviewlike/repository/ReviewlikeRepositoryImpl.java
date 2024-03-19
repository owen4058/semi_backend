package com.spring.myapp.reviewlike.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.myapp.member.Member;
import com.spring.myapp.member.ResMember;
import com.spring.myapp.review.Review;
import com.spring.myapp.reviewlike.Reviewlike;
import com.spring.myapp.reviewlike.Reviewlikeres;

@Repository("reviewlikeRepository")
public class ReviewlikeRepositoryImpl implements ReviewlikeRepository {
	
	@Autowired
	private SqlSession sqlSession;
	

	
	@Override
	public Reviewlike selectAllReviewList(Reviewlikeres reviewlikeres) throws DataAccessException {
	
		if (sqlSession.selectOne("mapper.reviewlike.selectReviewlike",reviewlikeres) != null) {
			sqlSession.delete("mapper.reviewlike.deleteReviewlike",reviewlikeres);
			
			sqlSession.update("mapper.reviewlike.updatelikemi",reviewlikeres);
			
		}else {
			sqlSession.insert("mapper.reviewlike.insertReviewlike",reviewlikeres);
			
			sqlSession.update("mapper.reviewlike.updatelikepl",reviewlikeres);
		}
		return sqlSession.selectOne("mapper.reviewlike.selectReviewlike",reviewlikeres);
	}
	
	@Override
	public Reviewlike Reviewlike(Reviewlikeres reviewlikeres) throws DataAccessException {
		return sqlSession.selectOne("mapper.reviewlike.selectReviewlike",reviewlikeres);
	}

}
