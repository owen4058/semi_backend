package com.spring.myapp.member.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.member.idValidate;
@Repository("memberRepository")
public class MemberRepositoryImpl implements MemberRepository{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Member> selectAllMemberList() throws DataAccessException {
		
		return null;
	}

	@Override
	public int insertMember(Member member) throws DataAccessException {
		int vo = sqlSession.insert("mapper.member.insertMember",member);
		return vo;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		int vo = sqlSession.delete("mapper.member.deleteMember",id);
		return vo;
	}
	@Override
	public int updateMember(Member member) throws DataAccessException {
		int vo = sqlSession.update("mapper.member.updateMember",member);
		return vo;
	}

	@Override
	 public LoginForm loginById(LoginForm loginForm) throws DataAccessException{
		LoginForm vo = sqlSession.selectOne("mapper.login.loginById",loginForm);
		return vo;
	}
	@Override
	 public idValidate validate(idValidate idValidate) throws DataAccessException{
		idValidate vo = sqlSession.selectOne("mapper.validate.validate",idValidate);
		return vo;
	}


}
