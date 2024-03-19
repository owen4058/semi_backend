package com.spring.myapp.member.repository;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.myapp.member.LoginForm;
import com.spring.myapp.member.Member;
import com.spring.myapp.member.ResMember;

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
		return sqlSession.insert("mapper.member.insertMember",member);
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		return sqlSession.delete("mapper.member.deleteMember",id);
	}
	@Override
	public int updateMember(Member member) throws DataAccessException {
		return sqlSession.update("mapper.member.updateMember",member);
	}

	@Override
	 public Optional<ResMember> loginById(LoginForm loginForm) throws DataAccessException{
	    return Optional.ofNullable(sqlSession.selectOne("mapper.member.loginById", loginForm));
	}
	@Override
	 public Optional<Member> validate(Member useraccount) throws DataAccessException{
		Member member = sqlSession.selectOne("mapper.member.validate",useraccount);
		return Optional.ofNullable(member);
	}


}
